package com.chatRobot.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

/**
 * Created by Administrator on 2017/5/24.
 */
public class XMLUtil2{

    /**
     * map转成xml
     *
     * @param arr
     * @return
     */
    public static String ArrayToXml(Map arr) {
        String xml = "<xml>";

        Iterator<Map.Entry<String, String>> iter = arr.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String val = entry.getValue();
            xml += "<" + key + ">" + val + "</" + key + ">";
        }

        xml += "</xml>";
        return xml;
    }
    public static InputStream getStringStream(String sInputString) {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
        }
        return tInputStringStream;
    }

    /**
     *
     * @param xmlString
     * @return
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static Map<String,Object> getMapFromXML(String xmlString) throws ParserConfigurationException, IOException, SAXException {

        //这里用Dom的方式解析回包的最主要目的是防止API新增回包字段
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputStream is =  XMLUtil2.getStringStream(xmlString);
        Document document = builder.parse(is);

        //获取到document里面的全部结点
        NodeList allNodes = document.getFirstChild().getChildNodes();
        Node node;
        Map<String, Object> map = new HashMap<String, Object>();
        int i=0;
        while (i < allNodes.getLength()) {
            node = allNodes.item(i);
            if(node instanceof Element){
                map.put(node.getNodeName(),node.getTextContent());
            }
            i++;
        }
        return map;

    }

    /**
     * 流转换String
     * @param in
     * @return
     * @throws Exception
     */
    public static String getStrFromInputSteam(InputStream in)throws Exception{
        BufferedReader bf=new BufferedReader(new InputStreamReader(in,"UTF-8"));
        //最好在将字节流转换为字符流的时候 进行转码
        StringBuffer buffer=new StringBuffer();
        String line="";
        while((line=bf.readLine())!=null){
            buffer.append(line);
        }

        return buffer.toString();
    }

}
