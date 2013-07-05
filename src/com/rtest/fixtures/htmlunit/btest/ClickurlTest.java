package com.rtest.fixtures.htmlunit.btest;

import com.rtest.fixtures.htmlunit.HtmlTest;
import fit.Parse;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ClickurlTest extends HtmlTest{

	private String title = "";
	private String shopurl = "";
	List<String> clickUrlList = new ArrayList<String>();

	public void cmd_setShopUrl(List<String> row) {
		shopurl = fixUrl(row.get(1));
		super.cmd_setUrl(row);
		if(htmlpage!=null)
		title = htmlpage.getTitleText();
	}

	public void cmd_checkTitle(List<String> row) {
		String url = fixUrl(row.get(1));
		if(url.contains("[pl_e]")){
			url = url.replaceAll("\\[pl_e\\]", shopurl);
		}
		else{
			try {
				url = url.replaceAll("\\[pl\\]", java.net.URLEncoder.encode(shopurl,"UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		url = url.replaceAll("\\[cspuid\\]","123456");

        row.set(1,url);
		super.cmd_setUrl(row);

		if( title!=null && htmlpage!=null && title.equals(htmlpage.getTitleText())){
			pass(row);
		}
		else{
			fail(row, "title 不匹配："+title+"------"+htmlpage.getTitleText());
		}
	}
	static {
		Class<ClickurlTest> myClass = ClickurlTest.class;
		Class<List> args = List.class;
		try {
			commands.put("Set Shopurl", myClass.getDeclaredMethod("cmd_setShopUrl", args));
			commands.put("Check Title", myClass.getDeclaredMethod("cmd_checkTitle", args));
		} catch (Exception e) {
			System.out.println("Exception in startup. " + e.toString());
		}
	}
}
