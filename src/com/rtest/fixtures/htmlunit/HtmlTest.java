package com.rtest.fixtures.htmlunit;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import com.gargoylesoftware.htmlunit.xml.XmlPage;
import com.rtest.util.HtmlUtil;
import com.rtest.util.RegxpUtil;
import com.rtest.util.ZipUtil;
import fit.Parse;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.oro.text.regex.MalformedPatternException;

import static com.rtest.util.ListUtility.list;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;

public class HtmlTest {

    static Logger logger = Logger.getLogger(HtmlTest.class);
    static { PropertyConfigurator.configure("/upg/fitnis/log4j.properties"); }

    protected static HashMap<String, Method> commands = new HashMap<String, Method>();
    int HTMLPAGE = 1;
    int JSPAGE = 2;
    int TEXTPAGE = 3;
    int XMLPAGE = 4;
    int UNEXPECTEDPAGE = 5;

    static WebClient webClient;

    protected HtmlPage htmlpage;
    private JavaScriptPage jsPage;
    private TextPage textPage;
    private XmlPage xmlPage;
    private UnexpectedPage unExpectedPage;
    private String failPage;

    protected int pagetype = HTMLPAGE;

    HtmlElement focusElement;

    Map save_pages = new HashMap();

    public HtmlTest() {
        if (webClient == null)
            webClient = new WebClient(BrowserVersion.CHROME);
    }


    public List doTable(List<List<String>> table) {
        List ret = list();
        for (List list : table) {
            row(list, ret);
            ret.add(list);
        }
        no_check(table.get(0));
        return ret;
    }

    public void row(List<String> row, List ret) {
        String cmdText = row.get(0);
        Method command = (Method) commands.get(cmdText);
        try {
            if (command == null)
                logger.error("empty cmd: " + cmdText);
            assert command != null;
            command.invoke(this, row);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void cmd_postUrl(List<String> row) {
        try {
            String url = fixUrl(row.get(1));
            String data = row.get(2).replaceAll("&amp;", "&");
            debug("cmd_postUrl: " + url);

            //webClient.setRedirectEnabled(true);
            Page page = null;
            try {

                WebRequest wreq = new WebRequest(new URL(url),  HttpMethod.POST);
                wreq.setRequestBody(data);

                page = webClient.getPage( wreq );
            } catch (FailingHttpStatusCodeException e) {
	            fail(row, "" + e.getStatusCode());
	            failPage = e.toString();
            } catch (Exception e) {
	            e.printStackTrace();
            }

            if (page == null) {
                fail(row, "Page Null");
            } else {
                no_check(row);
	            int url_len_limit = 30;
	            if(url.length()>url_len_limit){
		            row.set(1, "report:  <a title='"+url+"' href='"+url+"'>"+url.substring(0, url_len_limit)+"</a>");
	            }
                row.set(2, "report: <span title='"+data+"'>postdata</span>");

                WebResponse wr = page.getWebResponse();
                htmlpage = (HtmlPage) page;
                pagetype = HTMLPAGE;

                String ret = wr.getContentAsString();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void cmd_setUrl(List<String> row) {
        try {
            String url = row.get(1);
			url = fixUrl(url);
            debug("cmd_setUrl: " + url);

            //webClient.setRedirectEnabled(true);
            Page page = null;
            try {
                page = webClient.getPage(url);
            } catch (FailingHttpStatusCodeException e) {
	            fail(row, "" + e.getStatusCode());
	            failPage = e.toString();
            } catch (Exception e) {
	            e.printStackTrace();
            }

            if (page == null) {
                fail(row, "Page Null");
            } else {
                no_check(row);

	            int url_len_limit = 30;
	            if(url.length()>url_len_limit){
                    String str_link = "report:  <a title='"+url+"' href='"+url+"'>"+url.substring(0, url_len_limit)+"</a>";
		            row.set(1, str_link);
	            }

                if (page instanceof TextPage) {
                    debug("is TextPage");
                    textPage = (TextPage) page;
                    pagetype = TEXTPAGE;
                } else if (page instanceof UnexpectedPage) {
                    debug("is UnexpectedPage");
                    unExpectedPage = (UnexpectedPage) page;
                    pagetype = UNEXPECTEDPAGE;
                } else if (page instanceof JavaScriptPage) {
                    debug("is JavaScriptPage");
                    jsPage = (JavaScriptPage) page;
                    pagetype = JSPAGE;
                } else if (page instanceof XmlPage) {
                    debug("is XmlPage");
                    xmlPage = (XmlPage) page;
                    pagetype = XMLPAGE;
                } else {
                    debug("maybe HtmlPage");
                    htmlpage = (HtmlPage) page;
                    pagetype = HTMLPAGE;
                    if (row.size() >= 3 && row.get(2).equals("html")) {
                        appendRow(row, ((HtmlPage) page).asXml());
                    }
                    else if (row.size() >= 3 && row.get(2).equals("text")) {
                        appendRow(row, ((HtmlPage) page).asText());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void cmd_clearCookies(List<String> row) {
        webClient.getCookieManager().clearCookies();
        no_check(row);
    }

	protected String fixUrl(String url) {
		url = url.replaceAll("&amp;", "&");
		url = url.replaceAll("<a.*?>", "");
		url = url.replaceAll("</a>", "");
		if (!url.startsWith("http://")) {
			url = "http://" + url;
		}
		return url;
	}

	private void cmd_savePage(List<String> row) {
        save_pages.put(row.get(1), htmlpage.asXml());
    }
    private void cmd_hasTitle(List<String> row) {
        String text = row.get(1);
        appendRow(row, 3);

        String ret_text = htmlpage.getTitleText();
        System.out.println("has-title"+ret_text + "|" + text);
        int matchCount = regxp_contains(ret_text,text);
        if(matchCount>0){
            pass(row, 2, "match "+matchCount, 3);
        } else {
            fail(row, 3, "Title \"" + row.get(1) + "\" not found!");
        }
    }

    private void cmd_hasText(List<String> row) {
        String text = row.get(1);
        appendRow(row);

        String ret_text = "";
	    if(pagetype == HTMLPAGE || (pagetype == JSPAGE))
			text = HtmlUtil.toHtmlChar(text);

	    ret_text = getPageTxt(row,2);

	    int rowSize = row.size();
        int matchCount = regxp_contains(ret_text,text);
        if(matchCount>0){
            pass(row, 2, "match "+matchCount, rowSize);
        }
        else{
            fail(row, 3, " \"" + text + "\" not found!");
        }
    }

	private String getPageTxt(List<String> row, int key_pos) {
		String ret_text;
		if (pagetype == HTMLPAGE) {
		    if (htmlpage != null) {
		        ret_text = getPageContents(row, htmlpage, key_pos);
		    } else {
		        ret_text = failPage;
		    }
		} else if (pagetype == JSPAGE) {
		    ret_text = jsPage.getContent();
		} else if (pagetype == XMLPAGE) {
		    ret_text = getPageContents(row, xmlPage, key_pos);
		} else if (pagetype == TEXTPAGE) {
		    ret_text = textPage.getContent();
		} else if (pagetype == UNEXPECTEDPAGE){
			String contenttype = unExpectedPage.getWebResponse().getContentType();
			if(contenttype.equals("application/zip")){
				ret_text = ZipUtil.unzipStream(unExpectedPage);
			}
			else{
				ret_text = getCharsetPageTxt(unExpectedPage, "UTF-8");
			}
		}
		else{
			ret_text = "unknow page";
		}
		return ret_text;
	}

	private String getCharsetPageTxt(Page page) {
		String charset = page.getWebResponse().getContentCharset();
		logger.debug(charset);
		return getCharsetPageTxt(page, charset);
	}
	
	private String getCharsetPageTxt(Page page, String charset) {
		return unExpectedPage.getWebResponse().getContentAsString(charset);
	}

	private void cmd_hasHeader(List<String> row) {
        List l = htmlpage.getWebResponse().getResponseHeaders();
        NameValuePair ret_nv = null;
        for(Object o : l){
            NameValuePair nv = (NameValuePair) o;
            if(nv.getName().equals(row.get(1)) && nv.getValue().equals(row.get(2))){
                ret_nv = nv;
                break;
            }
        }

        if(ret_nv==null){
            fail(row, "Header [" + row.get(1) + ":" + row.get(2) + "] not found");
        }
        else{
            pass(row);
        }
    }

    private void cmd_focus(List<String> row) {
        String text = row.get(1);
        HtmlElement el = (HtmlElement) htmlpage.getElementById(text);

        if (el == null) {
            el = htmlpage.getElementByName(text);
        }

        if (el != null) {
            el.focus();
            focusElement = el;
            no_check(row);
        } else {
            fail(row, 3, "Element \"" + row.get(1) + "\" not found!");
        }
    }

    private void cmd_hasAttr(List<String> row) {
        String text = row.get(1);
        HtmlElement el = null;
        if (text == null || text.equals("")) {
            el = focusElement;
        } else {
            el = (HtmlElement) htmlpage.getElementById(text);
            if (el == null) {
                try{
                    el = htmlpage.getElementByName(text);
                }catch(ElementNotFoundException e){
                    debug(e.toString());
                }
            }
        }

        if(el!=null){
            pass(row);
        }
        else{
            fail(row, "id/name of \"" + text + "\" not found!");
        }
//        String attr_name = row.size() > 2 ? row.get(2) : "";
//        String attr_val = row.size() > 3 ? row.get(3) : "";
//        String expectation = row.size() > 4 ? row.get(4) : "";
//
//        if (attr_name == null || attr_name.equals("")) {
//            fail(row, 3, "Attr's name is empty!");
//        } else {
//            boolean has_attr = false;
//            if (attr_val.equals("")) {
//                if (!expectation.equals("")) {
//                    has_attr = Boolean.valueOf(expectation) == !el.getAttribute(attr_name).equals("");
//                } else
//                    has_attr = !el.getAttribute(attr_name).equals("");
//            } else {
//                if (!expectation.equals("")) {
//                    has_attr = Boolean.valueOf(expectation) == el.getAttribute(attr_name).equals(attr_val);
//                } else
//                    has_attr = el.getAttribute(attr_name).equals(attr_val);
//            }
//
//            appendRow(row);
//            if (has_attr) {
//                pass(row);
//            } else {
//                fail(row, "Attr \"" + attr_name + "='" + attr_val + "'\" of \"" + row.get(1) + "\" not found!");
//            }
//        }
    }

    private void cmd_text(List<String> row) {
        String id, text;
        if (row.size() == 2) {
            text = row.get(1);
        } else {
            id = row.get(1);
            HtmlElement el = (HtmlElement) htmlpage.getElementById(id);
            if (el == null) {
                el = htmlpage.getElementByName(id);
            }
            el.focus();
            focusElement = el;

            text = row.get(2);
        }

        focusElement.setAttribute("value", text);
        appendRow(row);
        report(row, 3, focusElement.asXml(), 4);
    }

    private void cmd_showPage(List<String> row) {
	    String ret_text = getPageTxt(row,1);
	    if (row.size() > 1 && row.get(1).equals("src")) {
		    String pre = "<textarea>" + ret_text + "</textarea>";
		    report(row, 1, pre, 2);
	    } else {
		    report(row, 1, ret_text, 2);
	    }
        report(row, row.get(1));
    }

    private void cmd_showHeader(List<String> row) {
        String ret = "";
        boolean showSRC = false;
        if (row.size() > 1 && row.get(1).equals("src")) {
            showSRC = true;
        }

        List l = htmlpage.getWebResponse().getResponseHeaders();
        NameValuePair ret_nv = null;
        for(Object o : l){
            NameValuePair nv = (NameValuePair) o;
            if(showSRC) ret += nv.getName()+":"+nv.getValue()+"\n";
            else ret += "<tr><td>"+nv.getName()+"</td><td>"+nv.getValue()+"</td></tr><br>";
        }

        if (showSRC) ret = "<textarea>" + ret + "</textarea>";
        else ret = "<table>"+ret+"</table>";
        report(row, ret);
    }

    private void cmd_click(List<String> row) {
        if (row.size() > 1) {
            String text = row.get(1);
            if (text != null && !text.equals("")) {
                cmd_focus(row);
            }
        }

        try {
            htmlpage = focusElement.click();
        } catch (IOException e) {
            e.printStackTrace();
        }
        no_check(row);
    }

    private void cmd_enableJS(List<String> row) {
        String text = row.get(1);
        //webClient.setJavaScriptEnabled(Boolean.valueOf(text));
        no_check(row);
    }

    private void cmd_closeWin(List<String> row) {
        no_check(row);
    }

    private void cmd_print(List<String> row) {
        ignore(row, row.get(1));
    }

    private void cmd_host(List<String> row) {
        String url = row.get(1);
        Pattern p = Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        String ip = getServerIP(matcher.group());
        report(row, ip);
    }

    /* appendRow */
    private void appendRow(List<String> row, int n) {
        if (row.size() < n)
            row.add(n - 1, "None");
    }

    private void appendRow(List<String> row, String msg) {
        row.add(row.size(), msg);
    }

    private void appendRow(List<String> row) {
        row.add(row.size(), "None");
    }

    /* fail */
	protected void fail(List<String> row, String msg) {
        appendRow(row);
        fail(row, row.size(), msg, row.size());
    }

    private void fail(List<String> row, int n, String msg) {
        fail(row, row.size(), msg, n);
    }

    private void fail(List<String> row, int col, String msg, int msg_col) {
        msg(row, col, msg, msg_col, "fail");
    }

    /* pass */
	protected void pass(List<String> row) {
        pass(row, "ok");
    }

    private void pass(List<String> row, String msg) {
        appendRow(row);
        pass(row, row.size(), msg, row.size());
    }

    private void pass(List<String> row, int col, String msg, int msg_col) {
        msg(row, col, msg, msg_col, "pass");
    }

    /* report */
    private void report(List<String> row,  String msg) {
        appendRow(row);
        report(row, row.size(), msg, row.size());
    }

    private void report(List<String> row, int col, String msg, int msg_col) {
        msg(row, col, msg, msg_col, "report");
    }

    /* msg */
    private void msg(List<String> row, int col, String msg, int msg_col, String key) {

        //debug("msg(): "+row.size() + " | " + col + " | " +msg + " | " +msg_col + " | " +key);

        for (int i = 0; i < row.size(); i++) {
            if (i == col - 1 && msg_col==0) {
                row.add(row.size(), key);
            } else if (msg_col != 0 && i == msg_col - 1) {
                row.set(i, key+":" + msg + "");
            } else {
                row.set(i, "");
            }
        }
    }

    private void no_check(List<String> row){
        for (int i = 0; i < row.size(); i++) {
            row.set(i, "");
        }
    }

    private void ignore(List<String> row, String msg){
        row.set(0, "");
        row.set(1, "ignore:" + msg);
    }

    private void debug(Object o){
        logger.debug(o.toString());
    }

	private String getPageContents(List<String> row, SgmlPage page, int key_pos){
		String ret_text = "";
		if (row.size() > key_pos) {
			String key_str = row.get(key_pos);
			if (key_str.equals("src") || key_str.equals("source")) {
				ret_text = page.asXml();
			} else if (key_str.equals("text") || key_str.equals("visible")) {
				ret_text = page.asText();
			} else if (!key_str.equals("None")) {
				fail(row, 4, " column 3 must be 'visible' or 'source'" );
			} else {
				ret_text = page.asXml();
			}
		} else {
			ret_text = page.asXml();
		}
		return ret_text;
	}

	private int regxp_contains(String strs, String sub_strs){
		int ret = 0;
		try {
			RegxpUtil ru = new RegxpUtil();
			List l = ru.extractRegxpContains(strs, sub_strs);
			ret = l.size();
		} catch (MalformedPatternException e) {
			e.printStackTrace();
		}
		return ret;
	}

	/**
	 * 　　* 获得某域名的IP地址
	 * 　　* @param domain 域名
	 * 　　* @return
	 *
	 */
	public static String getServerIP(String domain) {
		InetAddress[] addrs = new InetAddress[0];
		try {
			addrs = InetAddress.getAllByName(domain);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		String ip = addrs[0].getCanonicalHostName();
		return ip;
	}

    static {

        Class<HtmlTest> myClass = HtmlTest.class;
        //Class<Parse> args = Parse.class;
        Class<List> args = List.class;
        try {
            commands.put("Set Url", myClass.getDeclaredMethod("cmd_setUrl", args));
            commands.put("Post Url", myClass.getDeclaredMethod("cmd_postUrl", args));
            commands.put("Clear Cookies", myClass.getDeclaredMethod("cmd_clearCookies", args));
            commands.put("Save Page", myClass.getDeclaredMethod("cmd_savePage", args));
            commands.put("Has Title", myClass.getDeclaredMethod("cmd_hasTitle", args));
            commands.put("Has Text", myClass.getDeclaredMethod("cmd_hasText", args));
            commands.put("Has Header", myClass.getDeclaredMethod("cmd_hasHeader", args));
            commands.put("Has Attr", myClass.getDeclaredMethod("cmd_hasAttr", args));
            commands.put("Focus", myClass.getDeclaredMethod("cmd_focus", args));
            commands.put("Text", myClass.getDeclaredMethod("cmd_text", args));
            commands.put("Click", myClass.getDeclaredMethod("cmd_click", args));
            commands.put("Show Page", myClass.getDeclaredMethod("cmd_showPage", args));
            commands.put("Show Header", myClass.getDeclaredMethod("cmd_showHeader", args));
            commands.put("Enable JS", myClass.getDeclaredMethod("cmd_enableJS", args));
            commands.put("Close Win", myClass.getDeclaredMethod("cmd_closeWin", args));
            commands.put("Print", myClass.getDeclaredMethod("cmd_print", args));
            commands.put("Host", myClass.getDeclaredMethod("cmd_host", args));
            /**
             *
             commands.put("Elements", myClass.getDeclaredMethod("cmd_elements", args));
             commands.put("Element", myClass.getDeclaredMethod("cmd_element", args));
             commands.put("Element Focus", myClass.getDeclaredMethod("cmd_element", args));

             commands.put("Focus Relative", myClass.getDeclaredMethod("cmd_focusRelative", args));
             commands.put("Types", myClass.getDeclaredMethod("cmd_types", args));
             commands.put("Type", myClass.getDeclaredMethod("cmd_type", args));
             commands.put("Type Focus", myClass.getDeclaredMethod("cmd_type", args));

             commands.put("Attribute", myClass.getDeclaredMethod("cmd_attribute", args));
             commands.put("Attribute Focus", myClass.getDeclaredMethod("cmd_attributeFocus", args));

             commands.put("Matches Text", myClass.getDeclaredMethod("cmd_matchesText", args));
             commands.put("Save", myClass.getDeclaredMethod("cmd_save", args));
             commands.put("Execute", myClass.getDeclaredMethod("cmd_execute", args));
             commands.put("Set Value", myClass.getDeclaredMethod("cmd_setValue", args));

             commands.put("Submit", myClass.getDeclaredMethod("cmd_submit", args));
             commands.put("Nodes", myClass.getDeclaredMethod("cmd_nodes", args));
             commands.put("Node", myClass.getDeclaredMethod("cmd_node", args));
             commands.put("Blank Token", myClass.getDeclaredMethod("cmd_blankToken", args));
             commands.put("Preserve", myClass.getDeclaredMethod("cmd_preserve", args));
             commands.put("Javascript", myClass.getDeclaredMethod("cmd_javascript", args));
             commands.put("Clear", myClass.getDeclaredMethod("cmd_clear", args));
             commands.put("Symbol", myClass.getDeclaredMethod("cmd_symbol", args));
             commands.put("List", myClass.getDeclaredMethod("cmd_list", args));
             commands.put("Symbol Token", myClass.getDeclaredMethod("cmd_symbolToken", args));
             commands.put("Last Element Token", myClass.getDeclaredMethod("cmd_lastElementToken", args));
             commands.put("Timeout", myClass.getDeclaredMethod("cmd_timeout", args));
             commands.put("Soft Timeout", myClass.getDeclaredMethod("cmd_timeout", args));
             commands.put("Append Value", myClass.getDeclaredMethod("cmd_appendValue", args));
             commands.put("Parent Focus", myClass.getDeclaredMethod("cmd_focusParent", args));
             commands.put("Parent Type Focus", myClass.getDeclaredMethod("cmd_focusParent", args));
             //original command names Focus Parent... didn't follow the convention...keeping for backwards compatibility
             commands.put("Focus Parent", myClass.getDeclaredMethod("cmd_focusParent", args));
             commands.put("Focus Parent Type", myClass.getDeclaredMethod("cmd_focusParent", args));

             commands.put("Sleep", myClass.getDeclaredMethod("cmd_sleep", args));
             commands.put("Print Dom", myClass.getDeclaredMethod("cmd_printDom", args));
             commands.put("Print Cookies", myClass.getDeclaredMethod("cmd_printCookies", args));
             commands.put("Cookie", myClass.getDeclaredMethod("cmd_cookie", args));
             commands.put("Matches Cookie", myClass.getDeclaredMethod("cmd_cookie", args));
             commands.put("Set User Agent", myClass.getDeclaredMethod("cmd_setUserAgent", args));
             commands.put("Run Command", myClass.getDeclaredMethod("cmd_runCommand", args));
             commands.put("Submit Confirm", myClass.getDeclaredMethod("cmd_submitConfirm", args));
             commands.put("Click Confirm", myClass.getDeclaredMethod("cmd_submitConfirm", args));
             commands.put("Javascript Message", myClass.getDeclaredMethod("cmd_javascriptMessage", args));
             commands.put("Response Header", myClass.getDeclaredMethod("cmd_header", args));
             commands.put("Print Response Headers", myClass.getDeclaredMethod("cmd_printResponseHeaders", args));
             commands.put("Set Request Header", myClass.getDeclaredMethod("cmd_setRequestHeader", args));
             commands.put("Matches Response Header", myClass.getDeclaredMethod("cmd_header", args));
             commands.put("Get Response", myClass.getDeclaredMethod("cmd_getResponse", args));
             commands.put("Status Code", myClass.getDeclaredMethod("cmd_statusCode", args));
             commands.put("Matches Attribute", myClass.getDeclaredMethod("cmd_attribute", args));
             commands.put("Switch Web Client", myClass.getDeclaredMethod("cmd_switchWebClient", args));
             commands.put("Load Frame", myClass.getDeclaredMethod("cmd_loadFrame", args));
             commands.put("Text Focus", myClass.getDeclaredMethod("cmd_textFocus", args));
             commands.put("Show Javascript Errors", myClass.getDeclaredMethod("cmd_throwExceptionOnJavascriptError", args));
             commands.put("Drag Drop", myClass.getDeclaredMethod("cmd_dragDrop", args));
             commands.put("Show SSL Errors", myClass.getDeclaredMethod("cmd_throwExceptionOnSSLError", args));
             commands.put("Sleep Until Has Text", myClass.getDeclaredMethod("cmd_sleepUntilHasText", args));
             commands.put("Sleep Until Fail Has Text", myClass.getDeclaredMethod("cmd_sleepUntilHasText", args));
             commands.put("Display HTML", myClass.getDeclaredMethod("cmd_displayHTML", args));
             commands.put("Escape HTML", myClass.getDeclaredMethod("cmd_escapeHTML", args));
             commands.put("Child Type", myClass.getDeclaredMethod("cmd_type", args));
             commands.put("Focus Child Type", myClass.getDeclaredMethod("cmd_type", args));
             commands.put("Child Types", myClass.getDeclaredMethod("cmd_types", args));
             commands.put("Set Browser Version", myClass.getDeclaredMethod("cmd_setBrowserVersion", args));
             commands.put("Enable CSS", myClass.getDeclaredMethod("cmd_css", args));
             commands.put("Set Proxy", myClass.getDeclaredMethod("cmd_setProxy", args));
             commands.put("Response Size", myClass.getDeclaredMethod("cmd_responseSize", args));
             commands.put("Display Javascript", myClass.getDeclaredMethod("cmd_displayJavascript", args));
             commands.put("Set Script Preprocessor", myClass.getDeclaredMethod("cmd_setScriptPreProcessor", args));
             */

        } catch (Exception e) {
            System.out.println("Exception in startup. " + e.toString());
        }
    }
}
