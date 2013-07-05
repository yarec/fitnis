package com.rtest.util;

import org.apache.oro.text.regex.MalformedPatternException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RegxpUtilTest {

    RegxpUtil ru;
    @Before
    public void before(){
        ru = new RegxpUtil();
    }

    @Test
    public void testextractRegxpContains() throws MalformedPatternException {
        List l = ru.extractRegxpContains("{\"uid\":\"SDUMZYRB\",\"succ\":1,\"username\":\"test\",\"errormsg\":\"\",\"errorfield\":\"\"} ", "\\\\u975e\\\\u6cd5");

        for(Object o: l){
            System.out.println(o);
        }
    }

    public String getUrl(){
        return "http://www.baidu.com?aa=$a&b=$b";
    }

    public String getHtml(){
           return "<?xml version=\"1.0\" encoding=\"gbk\"?>\n" +
                   "<html>\n" +
                   "  <head>\n" +
                   "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=7\"/>\n" +
                   "    <meta http-equiv=\"content-type\" content=\"text/html;charset=gb2312\"/>\n" +
                   "    <title>\n" +
                   "      百度搜索_fitnesse      \n" +
                   "    </title>\n" +
                   "    <style>\n" +
                   "      body{color:#000;background:#fff;padding:7px 0 0;margin:0;position:relative}body,th,td,.p1,.p2{font-family:arial}p,form,ol,ul,li,dl,dt,dd,h3{margin:0;padding:0;list-style:none}input{padding-top:0;padding-bottom:0;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;box-sizing:border-box}table,img{border:0}td{font-size:9pt;line-height:18px}em{font-style:normal;color:#cc0000}a em{text-decoration:underline}cite{font-style:normal;color:#008000}.m,a.m{color:#666}a.m:visited{color:#606}.g,a.g{color:#008000}.c{color:#77c}.f14{font-size:14px}.f10{font-size:10.5pt}.f16{font-size:16px}#u,#head,#tool,#search,#foot{font-size:12px}.p1{line-height:120%;margin-left:-12pt}.p2{width:100%;line-height:120%;margin-left:-12pt}#out{_margin-left:880px;_zoom:1}#in{_position:relative;_float:left;_margin-left:-880px}#wrapper{min-width:880px;_zoom:1}#container{padding-left:20px}#u{white-space:nowrap;position:absolute;right:10px;top:6px;_top:0;z-index:299}#u_m{color:#00c;cursor:pointer}#u_ms{text-decoration:underline}#u_m_tip{position:absolute;right:40px;top:24px;_top:26px;z-index:299;border:1px solid #9a99ff;display:none;background:#fff;overflow:hidden;width:100px}#u_m_tip a{display:block;line-height:22px;color:#0001cf;padding:0 10px;font-size:12px;text-decoration:none;border-bottom:1px solid #e6e6e6;width:100%}#u_m_tip a:hover{background:#d9e1f6}#u_m_tip a.last{border-bottom:0}#head{padding-left:20px}.fm{clear:both;position:relative;z-index:297}.nv{height:45px;position:relative;z-index:298}.nv .logo{float:left;margin-right:20px}.nv .tab{float:left;padding:20px 0 0;line-height:18px}.nv a,.nv b,.btn,#page,#more{font-size:14px}.nv a{color:#0000cc}.i{width:536px;*width:519px;height:32px;*height:20px;padding:3px 7px;padding-top:7px\\9;font:16px arial;background:url(http://www.baidu.com/img/i-1.0.0.png) no-repeat -304px 0;_background-attachment:fixed;border:1px solid #b6b6b6;border-color:#7b7b7b #b6b6b6 #b6b6b6 #7b7b7b;vertical-align:top;margin-right:5px}.btn{width:95px;height:32px;padding:0;padding-top:2px\\9;border:0;background:#ddd url(http://www.baidu.com/img/i-1.0.0.png);cursor:pointer}.btn_h{background-position:-100px 0}.btn_wr{width:97px;height:34px;display:inline-block;background:url(http://www.baidu.com/img/i-1.0.0.png) no-repeat -202px 0;_top:1px;*position:relative}.seth{margin-left:22px;display:none}.seth a{color:#00c}#tb_mr{color:#00c;cursor:pointer;position:relative;z-index:298}#tb_mr b{font-weight:normal;text-decoration:underline}#tb_mr small{font-size:11px}#more{width:58px;height:100px;border:1px solid #9A99FF;background:#fff;position:absolute;z-index:298;left:452px;top:45px;*top:46px;overflow:hidden;display:none;outline:none}#more a{width:53px;height:25%;line-height:24px;display:block;padding:0 0 0 7px;color:#0001CF;text-decoration:none}#more a span{font-family:\"宋体\"}#more a:hover{background:#D9E1F6}#more div{height:1px;overflow:hidden;background:#ccf;margin:0 3px}#page{white-space:nowrap}#page{word-spacing:4px}#page .n{font-size:16px}#rs{width:100%;background:#eff2fa;padding:8px 0;margin:20px 0 0}#rs td{width:5%}#rs th{font-size:14px;font-weight:normal;line-height:19px;white-space:nowrap;text-align:left;vertical-align:top}#rs .tt{font-weight:bold;padding:0 10px 0 20px}#search{padding:35px 0 16px 20px}#search .btn_wr{vertical-align:middle}#foot{height:20px;line-height:20px;color:#77c;background:#e6e6e6;text-align:center}#foot span{color:#666}.site_tip{font-size:13px;line-height:18px;padding:3px 0 5px 72px;margin-bottom:20px;background:url(http://www.baidu.com/img/bg-1.0.0.gif) no-repeat}.to_zhidao,.to_tieba{font-size:16px;line-height:24px;margin:20px 0 0;padding:0 0 0 32px;background:url(http://www.baidu.com/img/bg-1.0.0.gif) no-repeat 0 -68px}.to_tieba{background-position:0 -102px}.f{line-height:115%;*line-height:120%;font-size:100%;width:33.7em;word-break:break-all;word-wrap:break-word}.h{margin-left:8px;width:100%}.r{word-break:break-all;cursor:hand;width:238px}.t{font-weight:normal;font-size:medium}.pl{padding-left:3px;height:8px;padding-right:2px;font-size:14px}.mo,a.mo:link,a.mo:visited{color:#666;font-size:100%;line-height:10px}.htb{margin-bottom:5px}.jc a{color:#cc0000}a font[size=\"3\"] font, font[size=\"3\"] a font{text-decoration:underline}div.blog,div.bbs{color:#707070;padding-top:3px}.result{width:33.7em;table-layout:fixed}.result-op .f{word-wrap:normal}.nums{font-size:12px;color:#999}.tools{width:220px;position:absolute;top:10px}#mHolder{width:62px;position:relative;z-index:296;top:-18px;margin-left:9px;margin-right:-12px;display:none}#mCon{height:18px;position:absolute;right:7px;top:3px;top:6px\\9;cursor:pointer;padding:0 18px 0 0;line-height:18px;background:url(http://www.baidu.com/img/bg-1.0.0.gif) no-repeat right -133px;background-position:right -135px\\9}#mCon span{color:#00c;cursor:default;display:block}#mCon .hw{text-decoration:underline;cursor:pointer}#mMenu{width:56px;border:1px solid #9a99ff;position:absolute;right:7px;top:28px;display:none;background:#fff}#mMenu a{width:100%;height:100%;color:#00c;display:block;line-height:22px;text-indent:6px;text-decoration:none}#mMenu a:hover{background:#d9e1f6}#mMenu .ln{height:1px;background:#ccf;overflow:hidden;margin:2px;font-size:1px;line-height:1px}.op_LAMP{background:url(\"http://open.baidu.com/stat/image/Icon_Aladdin.gif\") no-repeat 0 2px;color:#77C;display:inline-block;font-size:13px;height:12px;*height:14px;width:16px;text-decoration:none;zoom:1;}\n" +
                   ".EC_mr15{margin-left:0}.pd15{padding-left:0}.map_1{width:30em;font-size:80%;line-height:145%}.map_2{width:25em;font-size:80%;line-height:145%}.favurl{background-repeat:no-repeat;background-position:0 1px;padding-left:20px;}\n" +
                   "    </style>\n" +
                   "    <script>\n" +
                   "//<![CDATA[\n" +
                   "var bds={se:{}},name,location,navigate,bdQid=\"841ac62109ddaf7e\",al_arr=[];var selfOpen = window.open;eval(\"var open = selfOpen;\");function G(id){return document.getElementById(id);}function h(obj){obj.style.behavior='url(#default#homepage)';obj.setHomePage('http://www.baidu.com');var img=window[\"BD_PS_C\"+(new Date()).getTime()]=new Image();img.src=\"http://sclick.baidu.com/w.gif?fm=hp&tn=baidu&t=\"+new Date().getTime();}function al_c(A){while(A.tagName!=\"TABLE\"){A=A.parentNode;}return A.getAttribute(\"id\");}function al_c2(n,c){while(c--){while((n=n.parentNode).tagName!=\"TABLE\");};return n.getAttribute(\"id\");}function c(q){var p = window.document.location.href, sQ = '', sV = '', mu='', img = window[\"BD_PS_C\" + (new Date()).getTime()] = new Image();for (v in q) {switch (v) {case \"title\":sV = encodeURIComponent(q[v].replace(/<[^<>]+>/g, \"\"));break;case \"url\":sV = escape(q[v]);break;default:sV = q[v];}sQ += \"&\" + v + \"=\" + sV;}try{if ((\"p2\" in q)&&G(q[\"p1\"]).getAttribute(\"mu\") && q[\"fm\"]!=\"pl\") {mu= \"&mu=\" + escape(G(q[\"p1\"]).getAttribute(\"mu\"));}}catch(e){};img.src = \"http://sclick.baidu.com/w.gif?q=fitnesse\" + sQ + mu + \"&rsv_sid=&cid=0&qid=841ac62109ddaf7e&t=\"+new Date().getTime()+\"&path=\"+p;return true;}function ns_c(q){var p = encodeURIComponent(window.document.location.href), sQ = '',wd='fitnesse', sV = '', mu='', img = window[\"BD_PS_C\" + (new Date()).getTime()] = new Image();for (v in q) {switch (v) {case \"title\":sV = encodeURIComponent(q[v].replace(/<[^<>]+>/g, \"\"));break;case \"url\":sV = encodeURIComponent(q[v]);break;default:sV = q[v]}sQ += v + \"=\" + sV + \"&\"} mu= \"&mu=\" + p ;img.src = \"http://nsclick.baidu.com/v.gif?pid=201&pj=www&\" + sQ + \"path=\"+p+\"&wd=\"+wd+\"&t=\"+new Date().getTime();return true;}window[\"bdUser\"]=null;window[\"login_success\"]=[];window[\"bdQuery\"] = \"fitnesse\";window[\"bdUseFavo\"] = \"0\";window[\"bdCid\"] = \"0\";window[\"bdServerTime\"] = \"1312787590\";\n" +
                   "//]]>\n" +
                   "    </script>\n" +
                   "    <script type=\"text/javascript\">\n" +
                   "//<![CDATA[\n" +
                   "(function(){window.A=bds.aladdin={};A.ids=[0].slice(0,-1);A.has=A.ids.length>0;if(A.has){document.write('<script src=\"http://www.baidu.com/cache/aladdin/base.js\"></' + 'script>');}})();\n" +
                   "//]]>\n" +
                   "    </script>\n" +
                   "  </head>\n" +
                   "  <body link=\"#0000cc\">\n" +
                   "    <div id=\"out\">\n" +
                   "      <div id=\"in\">\n" +
                   "        <div id=\"wrapper\">\n" +
                   "          <p id=\"u\">\n" +
                   "            <a href=\"http://www.baidu.com/gaoji/preferences.html\" onmousedown=\"return user_c({'fm':'set','tab':'setting','url':this.href})\">\n" +
                   "              搜索设置\n" +
                   "            </a>\n" +
                   "             | \n" +
                   "            <a id=\"lb\" href=\"http://passport.baidu.com/?login&tpl=mn\" onclick=\"return false;\" onmousedown=\"return user_c({'fm':'set','tab':'login','url':this.href})\">\n" +
                   "              登录\n" +
                   "            </a>\n" +
                   "          </p>\n" +
                   "          <div id=\"head\">\n" +
                   "            <div class=\"nv\">\n" +
                   "              <a href=\"/\" class=\"logo\" onmousedown=\"return c({'fm':'tab','tab':'logo'})\">\n" +
                   "                <img src=\"http://www.baidu.com/img/baidu_jgylogo3.gif\" width=\"117\" height=\"38\" border=\"0\" alt=\"到百度首页\"/>\n" +
                   "              </a>\n" +
                   "              <div class=\"tab\">\n" +
                   "                <a href=\"http://news.baidu.com/ns?cl=2&rn=20&tn=news&word=fitnesse\" onmousedown=\"return c({'fm':'tab','tab':'news'})\">\n" +
                   "                  新闻\n" +
                   "                </a>\n" +
                   "                　\n" +
                   "                <b>\n" +
                   "                  网页\n" +
                   "                </b>\n" +
                   "                　\n" +
                   "                <a href=\"http://tieba.baidu.com/f?kw=fitnesse&fr=wwwt\" onmousedown=\"return c({'fm':'tab','tab':'tieba'})\">\n" +
                   "                  贴吧\n" +
                   "                </a>\n" +
                   "                　\n" +
                   "                <a href=\"http://zhidao.baidu.com/q?ct=17&pn=0&tn=ikaslist&rn=10&word=fitnesse&fr=wwwt\" onmousedown=\"return c({'fm':'tab','tab':'zhidao'})\">\n" +
                   "                  知道\n" +
                   "                </a>\n" +
                   "                　\n" +
                   "                <a href=\"http://mp3.baidu.com/m?tn=baidump3&ct=134217728&lm=-1&word=fitnesse\" onmousedown=\"return c({'fm':'tab','tab':'mp3'})\">\n" +
                   "                  MP3\n" +
                   "                </a>\n" +
                   "                　\n" +
                   "                <a href=\"http://image.baidu.com/i?tn=baiduimage&ct=201326592&lm=-1&cl=2&word=fitnesse\" onmousedown=\"return c({'fm':'tab','tab':'pic'})\">\n" +
                   "                  图片\n" +
                   "                </a>\n" +
                   "                　\n" +
                   "                <a href=\"http://video.baidu.com/v?ct=301989888&rn=20&pn=0&db=0&s=25&word=fitnesse\" onmousedown=\"return c({'fm':'tab','tab':'video'})\">\n" +
                   "                  视频\n" +
                   "                </a>\n" +
                   "                　\n" +
                   "                <a href=\"http://map.baidu.com/m?word=fitnesse&fr=ps01000\" onmousedown=\"return c({'fm':'tab','tab':'map'})\">\n" +
                   "                  地图\n" +
                   "                </a>\n" +
                   "                　\n" +
                   "                <span id=\"tb_mr\" onmousedown=\"return c({'fm':'tab','tab':'tbmore'});\">\n" +
                   "                  <b>\n" +
                   "                    更多\n" +
                   "                  </b>\n" +
                   "                  <small>\n" +
                   "                    ▼\n" +
                   "                  </small>\n" +
                   "                </span>\n" +
                   "              </div>\n" +
                   "              <div id=\"more\">\n" +
                   "                <a href=\"http://baike.baidu.com/searchword/?word=fitnesse&pic=1\" onmousedown=\"return c({'fm':'tab','tab':'baike'})\">\n" +
                   "                  百科\n" +
                   "                </a>\n" +
                   "                <a href=\"http://wenku.baidu.com/search?word=fitnesse&lm=0&od=0\" onmousedown=\"return c({'fm':'tab','tab':'wenku'})\">\n" +
                   "                  文库\n" +
                   "                </a>\n" +
                   "                <a href=\"http://dict.baidu.com/s?wd=fitnesse\" onmousedown=\"return c({'fm':'tab','tab':'dict'})\">\n" +
                   "                  词典\n" +
                   "                </a>\n" +
                   "                <div>\n" +
                   "                </div>\n" +
                   "                <a href=\"http://www.baidu.com/more/\" onmousedown=\"return c({'fm':'tab','tab':'more'})\">\n" +
                   "                  更多\n" +
                   "                  <span>\n" +
                   "                    >>\n" +
                   "                  </span>\n" +
                   "                </a>\n" +
                   "              </div>\n" +
                   "            </div>\n" +
                   "            <form name=\"f\" action=\"s\" class=\"fm\">\n" +
                   "              <input type=\"hidden\" name=\"bs\" value=\"fitnesse\"/>\n" +
                   "              <input type=\"hidden\" name=\"f\" value=\"8\"/>\n" +
                   "              <input type=\"hidden\" name=\"rsv_bp\" value=\"1\"/>\n" +
                   "              <input name=\"wd\" id=\"kw\" class=\"i\" value=\"fitnesse\" maxlength=\"100\" type=\"text\"/>\n" +
                   "              <span class=\"btn_wr\">\n" +
                   "                <input type=\"submit\" id=\"su\" value=\"百度一下\" class=\"btn\" onmousedown=\"this.className='btn btn_h'\" onmouseout=\"this.className='btn'\"/>\n" +
                   "              </span>\n" +
                   "              <span class=\"tools\">\n" +
                   "                <span id=\"mHolder\">\n" +
                   "                  <div id=\"mCon\">\n" +
                   "                    <span>\n" +
                   "                      输入法\n" +
                   "                    </span>\n" +
                   "                  </div>\n" +
                   "                  <ul id=\"mMenu\">\n" +
                   "                    <li>\n" +
                   "                      <a href=\"#\" name=\"ime_hw\">\n" +
                   "                        手写\n" +
                   "                      </a>\n" +
                   "                    </li>\n" +
                   "                    <li>\n" +
                   "                      <a href=\"#\" name=\"ime_py\">\n" +
                   "                        拼音\n" +
                   "                      </a>\n" +
                   "                    </li>\n" +
                   "                    <li class=\"ln\"/>\n" +
                   "                    <li>\n" +
                   "                      <a href=\"#\" name=\"ime_cl\">\n" +
                   "                        关闭\n" +
                   "                      </a>\n" +
                   "                    </li>\n" +
                   "                  </ul>\n" +
                   "                </span>\n" +
                   "                <span class=\"seth\" id=\"seth\">\n" +
                   "                  <strong>\n" +
                   "                    推荐 : \n" +
                   "                  </strong>\n" +
                   "                  <a href=\"#\" onclick=\"h(this)\" onmousedown=\"return ns_c({'fm':'behs','tab':'homepage','pos':1})\">\n" +
                   "                    把百度设为主页\n" +
                   "                  </a>\n" +
                   "                </span>\n" +
                   "              </span>\n" +
                   "            </form>\n" +
                   "          </div>\n" +
                   "          <br/>\n" +
                   "          <div id=\"container\">\n" +
                   "            <table width=\"30%\" cellpadding=\"0\" cellspacing=\"0\" align=\"right\">\n" +
                   "              <tr>\n" +
                   "                <td align=\"left\" style=\"padding-right:10px\">\n" +
                   "                  <div style=\"border-left:1px solid #e1e1e1;padding-left:10px;word-break:break-all;word-wrap:break-word;\">\n" +
                   "                    <style type=\"text/css\">\n" +
                   "                      \n" +
                   ".r.ec_bdtg{ width:238px;}\n" +
                   ".ec_bdtg .fsblock{padding:0;word-break:normal;font-family:arial}\n" +
                   ".ec_bdtg .fsblock a{text-decoration:none;}\n" +
                   ".ec_bdtg .title a{ text-decoration:underline; margin:0; padding:0; cursor:pointer;}\n" +
                   "\n" +
                   "                    </style>\n" +
                   "                    <div class=\"r ec_bdtg\">\n" +
                   "                      <div class=\"fsblock\">\n" +
                   "                        <div class=\"title\">\n" +
                   "                          <a href=\"http://www.baidu.com/adrc.php?t=000a00c00f7Ul0D0SOY00FTFK6aAWjqr0000000000000000XLusw6.THdhpgw8ugP1ufK85yF9pywd0ZnqrjfkmynvnWDsrywbmymLufKd5H-7PDPDn1TzwbD4wbc1P1TLPjfkfbcYwWmkPWTzfWKa0ADquZCkUy7mRMNpyD4ly-PpX-KRu1KPNYuJHhGFXDdDUAVpwYuVHWFNUyFgHMKpwj0sHgGonY4Dp1P2URR4HNm3IYG8RMwfRdCkm-fsUyc1iMKfNDNVm1Pypyc1iMKfRdGLmvdorR4Hyh9piD44ygCsIsK-5y9YIZ0lQzq-QhF9pywdQhPEUitOThNhugcqnH0z0APzm1Yknj0zrf\" target=\"_blank\">\n" +
                   "                            <font size=\"3\" style=\"_font-size:8pt;\">\n" +
                   "                              &#9654\n" +
                   "                            </font>\n" +
                   "                            <font size=\"3\">\n" +
                   "                              来百度推广您的产品\n" +
                   "                            </font>\n" +
                   "                          </a>\n" +
                   "                        </div>\n" +
                   "                        <a href=\"http://www.baidu.com/adrc.php?t=000a00c00f7Ul0D0SOY00FTFK6aAWjqr0000000000000000XLusw6.THdhpgw8ugP1ufK85yF9pywd0ZnqrjfkmynvnWDsrywbmymLufKd5H-7PDPDn1TzwbD4wbc1P1TLPjfkfbcYwWmkPWTzfWKa0ADquZCkUy7mRMNpyD4ly-PpX-KRu1KPNYuJHhGFXDdDUAVpwYuVHWFNUyFgHMKpwj0sHgGonY4Dp1P2URR4HNm3IYG8RMwfRdCkm-fsUyc1iMKfNDNVm1Pypyc1iMKfRdGLmvdorR4Hyh9piD44ygCsIsK-5y9YIZ0lQzq-QhF9pywdQhPEUitOThNhugcqnH0z0APzm1Yknj0zrf\" target=\"_blank\">\n" +
                   "                          <font color=\"#000\" size=\"-1\">\n" +
                   "                            咨询热线：400-800-8888\n" +
                   "                          </font>\n" +
                   "                          <br/>\n" +
                   "                          <font color=\"#008000\" size=\"-1\">\n" +
                   "                            e.baidu.com\n" +
                   "                          </font>\n" +
                   "                        </a>\n" +
                   "                      </div>\n" +
                   "                    </div>\n" +
                   "                    <br/>\n" +
                   "                  </div>\n" +
                   "                  <br/>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"1\" mu=\"http://baike.baidu.com/view/2576367.htm\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a target=\"_blank\" href=\"http://baike.baidu.com/view/2576367.htm\" onmousedown=\"return c({'fm':'albk','title':this.innerHTML,'url':this.href,'p1':al_c(this)});\">\n" +
                   "                      <em>\n" +
                   "                        fitnesse\n" +
                   "                      </em>\n" +
                   "                      _百度百科\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                    一、什么是\n" +
                   "                    <em>\n" +
                   "                      Fitnesse\n" +
                   "                    </em>\n" +
                   "                    ? \n" +
                   "                    <em>\n" +
                   "                      FitNesse\n" +
                   "                    </em>\n" +
                   "                    是一套软件开发协作工具 \n" +
                   "                    <em>\n" +
                   "                      FitNesse\n" +
                   "                    </em>\n" +
                   "                    是帮助大家加强软件开发过程中的协作的工具。能够让客户、测试人员和开发人员了解软...\n" +
                   "                    <font color=\"#666666\">\n" +
                   "                      共1次编辑\n" +
                   "                    </font>\n" +
                   "                    <br/>\n" +
                   "                    <a target=\"_blank\" href=\"http://baike.baidu.com/view/2576367.htm#1\" onmousedown=\"return c({'fm':'albk','title':this.innerHTML,'url':this.href,'p1':al_c(this),'p2':'1'});\">\n" +
                   "                      一、什么是Fitnesse?\n" +
                   "                    </a>\n" +
                   "                     - \n" +
                   "                    <a target=\"_blank\" href=\"http://baike.baidu.com/view/2576367.htm#2\" onmousedown=\"return c({'fm':'albk','title':this.innerHTML,'url':this.href,'p1':al_c(this),'p2':'2'});\">\n" +
                   "                      二、FitNesse的安装\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                    <font color=\"#008000\">\n" +
                   "                      baike.baidu.com/view/2576367.htm 2011-6-17\n" +
                   "                    </font>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"2\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779317EA','F1':'9D73F1E4','F2':'4CA63EEA','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':2,'y':'FDBBFFDF'})\" href=\"http://fitnesse.org/\" target=\"_blank\">\n" +
                   "                      <em>\n" +
                   "                        fitnesse\n" +
                   "                      </em>\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                    <em>\n" +
                   "                      FitNesse\n" +
                   "                    </em>\n" +
                   "                    ! The fully integrated standalone wiki, and acceptance testing framework. Be-monster not thy feature, wer't my \n" +
                   "                    <em>\n" +
                   "                      fitnesse\n" +
                   "                    </em>\n" +
                   "                    \"...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      <b>\n" +
                   "                        fitnesse\n" +
                   "                      </b>\n" +
                   "                      .org/ 2011-7-29  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9d78d513d9971ae904bad53f5a029026475bda257a95c7140cc98e1cc82207160627b4ac27554d4486d8&p=8b2a9215d9c441eb18bbc66f490e&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=2\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table id=\"3\" cellpadding=\"0\" cellspacing=\"0\" mu=\"http://wenku.baidu.com/view/ac14483031126edb6f1a101b.html\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a href=\"http://wenku.baidu.com/view/ac14483031126edb6f1a101b.html\" target=\"_blank\" onmousedown=\"return c({'fm':'alwk','title':this.innerHTML,'url':this.href,'p1':al_c(this)});\">\n" +
                   "                      <em>\n" +
                   "                        FitNesse\n" +
                   "                      </em>\n" +
                   "                      学习_百度文库\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                    <em>\n" +
                   "                      FitNesse\n" +
                   "                    </em>\n" +
                   "                    学习 - 参考文献：fixturegallery-20080708.pdf fixtures（ 夹具） Basic FIT fixtures（基本 FIT 夹具） 1） 、Col... \n" +
                   "                    <span class=\"m\">\n" +
                   "                      17页  浏览:128次\n" +
                   "                    </span>\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      wenku.baidu.com/view/ac14483031126edb6f1a ...  2011-4-19\n" +
                   "                    </span>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <p style=\"margin-left:1em\">\n" +
                   "                    <font size=\"-1\">\n" +
                   "                      <a href=\"http://wenku.baidu.com/view/7a5e48030740be1e650e9a65.html\" target=\"_blank\" onmousedown=\"return c({'fm':'alwk','title':this.innerHTML,'url':this.href,'p1':al_c(this),'p2':1});\">\n" +
                   "                        <em>\n" +
                   "                          FitNesse\n" +
                   "                        </em>\n" +
                   "                        安装与编译.\n" +
                   "                        <span class=\"doc_class\">\n" +
                   "                          doc\n" +
                   "                        </span>\n" +
                   "                      </a>\n" +
                   "                      <font color=\"#666666\">\n" +
                   "                        3页 浏览:117次\n" +
                   "                      </font>\n" +
                   "                      <br/>\n" +
                   "                      <a href=\"http://wenku.baidu.com/view/1169991ffc4ffe473368ab07.html\" target=\"_blank\" onmousedown=\"return c({'fm':'alwk','title':this.innerHTML,'url':this.href,'p1':al_c(this),'p2':2});\">\n" +
                   "                        <em>\n" +
                   "                          Fitnesse\n" +
                   "                        </em>\n" +
                   "                         Fixture.\n" +
                   "                        <span class=\"doc_class\">\n" +
                   "                          doc\n" +
                   "                        </span>\n" +
                   "                      </a>\n" +
                   "                      <font color=\"#666666\">\n" +
                   "                        29页 浏览:231次\n" +
                   "                      </font>\n" +
                   "                      <br/>\n" +
                   "                      <a href=\"http://wenku.baidu.com/search?word=fitnesse&lm=0&od=0\" target=\"_blank\" class=\"c\" onmousedown=\"return c({'fm':'alwk','title':this.innerHTML,'url':this.href,'p1':al_c(this),'p2':3})\">\n" +
                   "                        更多文库相关文档>>\n" +
                   "                      </a>\n" +
                   "                    </font>\n" +
                   "                  </p>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"4\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779317EA','F1':'9D73F1E4','F2':'4CA6BE6B','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':4,'y':'79F1FFFF'})\" href=\"http://blog.csdn.net/loardo/archive/2007/04/05/1552648.aspx\" target=\"_blank\">\n" +
                   "                      <em>\n" +
                   "                        FitNesse\n" +
                   "                      </em>\n" +
                   "                      安装与编译 - loardo的专栏 - CSDN博客\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                     二，安装和build \n" +
                   "                    <em>\n" +
                   "                      Fitnesse\n" +
                   "                    </em>\n" +
                   "                    ，有两种\n" +
                   "                    <em>\n" +
                   "                      Fitnesse\n" +
                   "                    </em>\n" +
                   "                    文件，一种是build好的\n" +
                   "                    <em>\n" +
                   "                      fitnesse\n" +
                   "                    </em>\n" +
                   "                    .jar安装文件包，一种是没有build的\n" +
                   "                    <em>\n" +
                   "                      fitnesse\n" +
                   "                    </em>\n" +
                   "                     源代码。首先介绍第一种文件包的安装,这种安装...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      blog.csdn.net/loardo/archive/2007/04/05/1 ... 2011-6-17  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9f65cb4a8c8507ed4fece7631046893b4c4380146d96864968d4e414c422461f1a35a3ed7a3f4344829f272356b2495ee8f52b70311e22b086cb8f4dddbf942238885067315ecc55578e59f9c4127e877cc71ba8f8&p=c23ec64ad08852ff57ed97681e0a&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=4\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"5\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779717EA','F1':'9D73F1E4','F2':'4CA6BE6B','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':5,'y':'FA7F9FE5'})\" href=\"http://www.douban.com/note/151471809/\" target=\"_blank\">\n" +
                   "                      [\n" +
                   "                      <em>\n" +
                   "                        fitnesse\n" +
                   "                      </em>\n" +
                   "                      ]与hudson的集成\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                    <em>\n" +
                   "                      fitnesse\n" +
                   "                    </em>\n" +
                   "                    允许客户和测试人员通过表格的方式(如MicroSoft Excel),来告诉Programmer需求所希望的结果是什么。FIT通过相应的Fixture代码来自动确认需求是否被正确实现。 它...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      www.douban.com/note/151471809/ 2011-7-29  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9d78d513d9971ae904bad53f5a029026475bda257a95c7140cc98e0dd6214c413030befc77714c13d3b22d3a5eb21501aca72b71300026b298c28a41c0&p=8b2a9315d9c042eb18bbc66f490e&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=5\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"6\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779717EA','F1':'9D73F1E4','F2':'4CA6BE6B','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':6,'y':'7F5979EF'})\" href=\"http://www.docin.com/p-71234744.html\" target=\"_blank\">\n" +
                   "                      <em>\n" +
                   "                        Fitnesse\n" +
                   "                      </em>\n" +
                   "                       and NET - docin.com豆丁网\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                     Achieving Customer Zen with \n" +
                   "                    <em>\n" +
                   "                      Fitnesse\n" +
                   "                    </em>\n" +
                   "                     and .NET Cory Foy (foyc@cornetdesign.com) http://www.cornetdesign.com Tampa Code Camp July 15 th , 2006 Business...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      www.docin.com/p-71234744.html 2011-6-19  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9d78d513d9971ae904bad53f5a029026475bda257a95c7140cc98e0dd6214c413030beea7c7e0704a49421381ced5e5c9cf53572360525b19ddf883d87fdcd76&p=99759a43d6d81df010be9b7a587a&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=6\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"7\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779717EA','F1':'9D73F1E4','F2':'4CA6FD6B','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':7,'y':'7FC7FBEB'})\" href=\"http://www.tudou.com/programs/view/ut4kzdBQTGI/\" target=\"_blank\">\n" +
                   "                      <em>\n" +
                   "                        fitnesse\n" +
                   "                      </em>\n" +
                   "                       quipment_在线视频观看_土豆网视频 fitness equipment ...\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                     Dezhou Strongway Fitness Equipment Co., Ltd was set up in March 2005, which is a professional manufacturer mainly specializes in commercial fitness eq fitnes...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      www.tudou.com/programs/view/ut4kzdBQTGI/ 2010-8-17  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9f65cb4a8c8507ed4fece763105392230e54f7257b818d5268d4e419ce3b4603073bb6fb747d5119979e2b221ce80f5ab3b86002546555cc86dccd179ded9d7c74ce7b63315dd1&p=867ace1e918712a05fbd9b7f1e&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=7\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"8\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779717EA','F1':'9D73F1E4','F2':'4CA63E6B','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':8,'y':'DFE7FEDF'})\" href=\"http://tool.chinaz.com/Ip/?ip=fitnessequipmentonlinestore.com\" target=\"_blank\">\n" +
                   "                      <em>\n" +
                   "                        fitnesse\n" +
                   "                      </em>\n" +
                   "                      quipmentonlinestore.com的IP信息 - 站长工具\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                     查询结果[1]: \n" +
                   "                    <em>\n" +
                   "                      fitnesse\n" +
                   "                    </em>\n" +
                   "                    quipmentonlinestore.com ==>> 61.140.3.66 ==>> 1032586050 ==>> 广东省广州市 电信  上面四项依次显示的是 : 原始输入内容 ==>>...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      tool.chinaz.com/Ip/?ip=\n" +
                   "                      <b>\n" +
                   "                        fitnesse\n" +
                   "                      </b>\n" +
                   "                      quipment ... 2011-7-3  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9f65cb4a8c8507ed4fece76310508a3b474380146d8d8b492c9c8448e435061e5a1da1a63023645f91d27d1155f40f00bdb1772574447bf5c49fd40c80e7cc7373df66722d5cd15612a448f29452609c60c655bdf45fbbedb173c4&p=86759a41dd9633e402fbc7710a05&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=8\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"9\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779717EA','F1':'9D73F1E4','F2':'4CA6BD6B','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':9,'y':'C74FFDD5'})\" href=\"http://www.51testing.com/html/76/n-88376.html\" target=\"_blank\">\n" +
                   "                      初识验收测试管理工具\n" +
                   "                      <em>\n" +
                   "                        FitNesse\n" +
                   "                      </em>\n" +
                   "                       - 51Testing软件测试网-中国软件测...\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                     摘要:\n" +
                   "                    <em>\n" +
                   "                      FitNesse\n" +
                   "                    </em>\n" +
                   "                    是帮助大家加强软件开发过程中的协作的工具。从另外一个角度看，\n" +
                   "                    <em>\n" +
                   "                      FitNesse\n" +
                   "                    </em>\n" +
                   "                    是一个轻量级的、开源的框架，能够帮助开发团队方便的定义验收测试（Acceptance Test...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      www.51testing.com/html/76/n-88376.html 2011-7-11  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9d78d513d9971ae904bad53f5a029026475bda257a95c7140cc98e0dd6214c413061e0fd7063565f8f906b6776fe1403f7aa702d691e25b386949f4aabb198292a8c30340746c01e4c&p=99759a4ed4d81df010be9b7a587a&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=9\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <table cellpadding=\"0\" cellspacing=\"0\" class=\"result\" id=\"10\">\n" +
                   "              <tr>\n" +
                   "                <td class=\"f\">\n" +
                   "                  <h3 class=\"t\">\n" +
                   "                    <a onmousedown=\"return c({'fm':'as','F':'779717EA','F1':'9D73F1E4','F2':'4CA6BD6B','F3':'54E5243F','T':'1312787590','title':this.innerHTML,'url':this.href,'p1':10,'y':'E77DFFD2'})\" href=\"http://webservices.ctocio.com.cn/java/226/9338726.shtml\" target=\"_blank\">\n" +
                   "                      通过FIT和\n" +
                   "                      <em>\n" +
                   "                        FitNesse\n" +
                   "                      </em>\n" +
                   "                      进行业务沟通_JAVA专区_IT专家网\n" +
                   "                    </a>\n" +
                   "                  </h3>\n" +
                   "                  <font size=\"-1\">\n" +
                   "                     FIT（集成测试框架）和 \n" +
                   "                    <em>\n" +
                   "                      FitNesse\n" +
                   "                    </em>\n" +
                   "                    虽然都被用于敏捷项目进行集成测试（integration test）和验收测试（acceptance test），但很多人已经尝试将两者结合起来作为通用的测试框架...\n" +
                   "                    <br/>\n" +
                   "                    <span class=\"g\">\n" +
                   "                      webservices.ctocio.com.cn/java/226/933872 ... 2011-7-24  \n" +
                   "                    </span>\n" +
                   "                     - \n" +
                   "                    <a href=\"http://cache.baidu.com/c?m=9f65cb4a8c8507ed4fece763105380365803c0276786875468d4e419d5390a1a1a71e3cc767f4f13d3b22d3b1cf71a18b9ed3672331e2bb69ac28d4ad9ac925f6ed2616b2e08c31c528516fb9000799661d10d&p=867ace1e918712a05ebd9b7a0905&user=baidu&fm=sc&query=fitnesse&qid=841ac62109ddaf7e&p1=10\" target=\"_blank\" class=\"m\">\n" +
                   "                      百度快照\n" +
                   "                    </a>\n" +
                   "                    <br/>\n" +
                   "                  </font>\n" +
                   "                </td>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "            <br/>\n" +
                   "            <script>\n" +
                   "            </script>\n" +
                   "            <br clear=\"all\"/>\n" +
                   "            <p id=\"page\">\n" +
                   "              <span>\n" +
                   "                1\n" +
                   "              </span>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=10\">\n" +
                   "                [2]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=20\">\n" +
                   "                [3]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=30\">\n" +
                   "                [4]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=40\">\n" +
                   "                [5]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=50\">\n" +
                   "                [6]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=60\">\n" +
                   "                [7]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=70\">\n" +
                   "                [8]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=80\">\n" +
                   "                [9]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=90\">\n" +
                   "                [10]\n" +
                   "              </a>\n" +
                   "              <a href=\"s?wd=fitnesse&pn=10\" class=\"n\">\n" +
                   "                下一页\n" +
                   "              </a>\n" +
                   "              <span class=\"nums\" style=\"margin-left:120px\">\n" +
                   "                找到相关结果约24,000个\n" +
                   "              </span>\n" +
                   "            </p>\n" +
                   "          </div>\n" +
                   "          <div id=\"rs\">\n" +
                   "            <table cellpadding=\"0\">\n" +
                   "              <tr>\n" +
                   "                <th rowspan=\"2\" class=\"tt\">\n" +
                   "                  相关搜索\n" +
                   "                </th>\n" +
                   "                <th>\n" +
                   "                  <a href=\"s?wd=fitnesse%20class&rsp=0&oq=fitnesse&f=1&rsv_ers=xn1\">\n" +
                   "                    fitnesse class\n" +
                   "                  </a>\n" +
                   "                </th>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "              </tr>\n" +
                   "              <tr>\n" +
                   "                <th/>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "                <td/>\n" +
                   "                <th/>\n" +
                   "              </tr>\n" +
                   "            </table>\n" +
                   "          </div>\n" +
                   "          <div id=\"search\">\n" +
                   "            <form name=\"f2\" action=\"/s\">\n" +
                   "              <input type=\"hidden\" name=\"bs\" value=\"fitnesse\"/>\n" +
                   "              <input type=\"hidden\" name=\"f\" value=\"8\"/>\n" +
                   "              <input type=\"hidden\" name=\"rsv_bp\" value=\"2\"/>\n" +
                   "              <input name=\"wd\" class=\"i\" value=\"fitnesse\" maxlength=\"100\" type=\"text\"/>\n" +
                   "              <span class=\"btn_wr\">\n" +
                   "                <input type=\"submit\" value=\"百度一下\" class=\"btn\" onmouseout=\"this.className='btn'\" onmousedown=\"this.className='btn btn_h'\"/>\n" +
                   "              </span>\n" +
                   "                 \n" +
                   "              <a href=\"/s?wd=fitnesse&tn=baidufir\" onmousedown=\"return c({'almid':'fir','stl':'link'})\">\n" +
                   "                结果中找\n" +
                   "              </a>\n" +
                   "                 \n" +
                   "              <a href=\"http://www.baidu.com/search/jiqiao.html\" target=\"_blank\" onmousedown=\"return c({'fm':'behb','tab':'help','url':this.href,'title':this.innerHTML})\">\n" +
                   "                帮助\n" +
                   "              </a>\n" +
                   "                 \n" +
                   "              <a href=\"http://www.baidu.com/search/jubao.html\" target=\"_blank\" onmousedown=\"return c({'fm':'behb','tab':'jubao','url':this.href,'title':this.innerHTML})\">\n" +
                   "                举报\n" +
                   "              </a>\n" +
                   "                 \n" +
                   "              <a href=\"http://www.baidu.com/gaoji/advanced.html\" onclick=\"location.href=this.href+\"?q=\"+encodeURIComponent(document.f.kw.value);return false;\" onmousedown=\"return c({'fm':'behb','tab':'gaoji','url':this.href,'title':this.innerHTML})\">\n" +
                   "                高级搜索\n" +
                   "              </a>\n" +
                   "            </form>\n" +
                   "          </div>\n" +
                   "          <div id=\"foot\">\n" +
                   "            ©2011 Baidu \n" +
                   "            <span>\n" +
                   "              此内容系百度根据您的指令自动搜索的结果，不代表百度赞成被搜索网站的内容或立场\n" +
                   "            </span>\n" +
                   "          </div>\n" +
                   "        </div>\n" +
                   "      </div>\n" +
                   "    </div>\n" +
                   "    <img src=\"http://c.baidu.com/c.gif?t=0&q=fitnesse&p=0&pn=1\" style=\"display:none\"/>\n" +
                   "    <script>\n" +
                   "//<![CDATA[\n" +
                   "for(ai in al_arr){al_arr[ai]()};c({'fm':'se','T':'1312787590','y':'FA4FA79D'});if(navigator.cookieEnabled && !/sug?=0/.test(document.cookie)){document.write('<script src=http://www.baidu.com/js/bdsug.js?v=1.0.3.0><\\/script>')};\n" +
                   "//]]>\n" +
                   "    </script>\n" +
                   "    <script>\n" +
                   "//<![CDATA[\n" +
                   "window.onunload=function(){};window.onload=function(){document.forms[0].reset();document.forms[document.forms.length-1].reset()};function addEV(C,B,A){if(window.attachEvent){C.attachEvent(\"on\"+B,A)}else{if(window.addEventListener){C.addEventListener(B,A,false)}}}addEV(document,\"click\",function(E){var E=E||window.event;var A=E.target||E.srcElement;var D=window.event?E.button:E.which;var C=G(\"tb_mr\"),B=G(\"more\");while(A&&A!=document.body&&A.tagName.toLowerCase()!=\"html\"){if(A==C){break}A=A.parentNode}if(A!=C){B.style.display=\"none\"}else{if(D<2){B.style.display=B.style.display==\"block\"?\"none\":\"block\"}}});var bdimeHW={hasF:1};var imeTar=\"kw\";var ime_t1=(new Date()).getTime();(function(){var a=navigator,X=document,f=window,b=a.userAgent.indexOf(\"MSIE\")!=-1;var Z=G(\"mCon\"),c=G(\"mMenu\");var l=[\"输入法\",\"手写\",\"拼音\"],m=[\"cl\",\"hw\",\"py\"],h=[\"\",\"http://www.baidu.com/hw/hwInput_1.1.js\",\"http://www.baidu.com/olime/bdime.js\"],j=[0,0,0];var g=a.cookieEnabled;if(g&&/\\bbdime=(\\d)/.test(X.cookie)){U(m[RegExp[\"\\x241\"]],false)}var i=c.getElementsByTagName(\"a\");for(var Y=0;Y<i.length;Y++){i[Y].onclick=W}if(b){var d=[];var e=Z.getElementsByTagName(\"*\");for(var Y=0;Y<e.length;Y++){d.push(e[Y])}d.push(Z);var e=c.getElementsByTagName(\"*\");for(var Y=0;Y<e.length;Y++){d.push(e[Y])}d.push(c);for(var Y=0;Y<d.length;Y++){d[Y].setAttribute(\"unselectable\",\"on\")}}function W(){ime_t1=(new Date()).getTime();var A=this.name.split(\"_\")[1];try{if(f.bdime){bdime.control.closeIme()}}catch(B){}U(A,true);return false}function U(D,C){var F=0;if(D==m[1]){F=1;G(\"mHolder\").style.display=\"inline-block\";Z.innerHTML='<span id=\"imeS\" class=\"hw\">'+l[1]+\"</span>\";if(b){G(\"imeS\").setAttribute(\"unselectable\",\"on\")}function A(){if(!j[1]){if(X.selection&&X.activeElement.id&&X.activeElement.id==\"kw\"){bdimeHW.hasF=1}bdimeHW.input=imeTar;bdimeHW.submit=\"su\";V(h[1]);setTimeout(function(){if(typeof bdsug!=\"undefined\"){bdsug.sug.initial()}},1000);j[1]=1}else{bdimeHW.reload(C)}}if(C){A()}else{addEV(G(\"imeS\"),\"click\",A)}}else{if(D==m[2]){F=2;G(\"mHolder\").style.display=\"inline-block\";Z.innerHTML=\"<span>\"+l[2]+\"</span>\";if(!j[2]){V(h[2]);j[2]=1}else{try{if(f.bdime){bdime.control.openIme()}}catch(E){}}}else{Z.innerHTML=\"<span>\"+l[0]+\"</span>\"}}if(C&&g){var B=new Date();B.setTime(B.getTime()+365*24*3600*1000);X.cookie=\"bdime=\"+F+\";domain=baidu.com;path=/;expires=\"+B.toGMTString()}}function V(B){if(B){var A=X.createElement(\"script\");A.src=B;X.getElementsByTagName(\"head\")[0].appendChild(A)}}function k(A){var A=A||window.event;var B=A.target||A.srcElement;c.style.display=B.id==\"mCon\"&&c.style.display!=\"block\"?\"block\":\"none\"}addEV(X,\"click\",k)})();\n" +
                   "//]]>\n" +
                   "    </script>\n" +
                   "    <script src=\"/user/js/u.js\">\n" +
                   "    </script>\n" +
                   "    <script type=\"text/javascript\" src=\"http://www.baidu.com/cache/hps/js/hps-1.1.js\">\n" +
                   "    </script>\n" +
                   "    <!--7ddf4129fc404350-->  </body>\n" +
                   "</html>";
    }
}
