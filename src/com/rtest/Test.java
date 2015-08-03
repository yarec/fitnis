package com.rtest;

import com.rtest.util.HtmlUtil;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
		t.testUnicode();
    }

    public void testUnicode(){
        String s = "请选择项目";
        System.out.println(HtmlUtil.chinaToUnicode("选"));

    }

    public void testValidatexml() {
        try {
            Validatexml("e:/test.xsd", "e:/test1.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public void testReplace(){
		String url = "http://track.weiyi.com/sr.aspx?w=A100036436&d=0000&t=[pl]&m=joyo&u=AI9P9Y3LAAAA";
		url = url.replaceAll("\\[pl\\]","http://test.com");
		System.out.println(url);
	}

    public boolean Validatexml(String xsdpath, String xmlpath) throws SAXException, IOException {
        //建立schema工厂
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        //建立验证文档文件对象，利用此文件对象所封装的文件进行schema验证
        File schemaFile = new File(xsdpath);
        //利用schema工厂，接收验证文档文件对象生成Schema对象
        Schema schema = schemaFactory.newSchema(schemaFile);
        //通过Schema产生针对于此Schema的验证器，利用schenaFile进行验证
        Validator validator = schema.newValidator();
        //得到验证的数据源
        Source source = new StreamSource(xmlpath);
        //开始验证，成功输出success!!!，失败输出fail
        try {

            validator.validate(source);

        } catch (Exception ex) {

            ex.printStackTrace();

        }
        return true;
    }


}
