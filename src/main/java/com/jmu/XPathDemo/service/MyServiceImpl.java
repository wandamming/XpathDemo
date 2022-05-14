package com.jmu.XPathDemo.service;

import com.jmu.XPathDemo.domain.ResultNodeList;
//import org.dom.Document;
//import org.dom4j.Element;
//import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public ResultNodeList xPathTest(String xpathStr) throws Exception{

        String xmlFile="D:\\XmlDBLP\\DBLP\\dblp-s.xml";
        System.out.println(xpathStr);
        //String xpathStr=" // Workbook/ Worksheet / Table / Row[1]/ Cell[1]/Data[1] ";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//得到 DOM 解析器的工厂实例
        dbf.setValidating(false);//如果创建的解析器在解析 XML 文档时必须消除元素内容中的空白，则为 true； 否则为假。
        DocumentBuilder db = dbf.newDocumentBuilder();//从 DOM 工厂获得 DOM 解析器
        Document doc = db.parse(new FileInputStream(new File(xmlFile)));
        //这边是两步，一是将要解析的XML文档转化为输入流
        //二是解析XML的输入流，得到一个Document的对象
        XPathFactory factory = XPathFactory.newInstance();//得到XPath 解析器的工厂实例
        XPath xpath = factory.newXPath();//创建了XPath对象

        //功能：在指定的上下文中评估一个 XPath表达式，并将结果作为指定的类型返回。
        NodeList nodeList = (NodeList) xpath.evaluate(xpathStr, doc, XPathConstants.NODESET);//参数一：XPath表达式；参数二：Document对象；参数三：指定的返回类型：XPath 1.0 NodeSet数据类型。
        ResultNodeList resultNodeList = new ResultNodeList();

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(nodeList.item(i).getNodeName() +   "-->" + nodeList.item(i).getTextContent());
            resultNodeList.getName().add(nodeList.item(i).getNodeName());
            resultNodeList.getContent().add(nodeList.item(i).getTextContent());

        }
        resultNodeList.setName(resultNodeList.getName());
        resultNodeList.setContent(resultNodeList.getContent());
        resultNodeList.setNum(nodeList.getLength());
        //resultNodeList.setContent(resultNodeList.getContent());
        System.out.println();
        System.out.println("总记录数："+nodeList.getLength());
        return resultNodeList;
    }




}
