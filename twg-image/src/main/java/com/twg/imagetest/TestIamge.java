package com.twg.imagetest;


import org.xml.sax.SAXException;

import javax.script.ScriptException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class TestIamge {

    public static void main(String[] args) throws IOException, ScriptException, NoSuchMethodException, ParserConfigurationException, SAXException {
        HtmlToImageUtils html = new HtmlToImageUtils();
        html.convertHtmlToImage();
    }


}
