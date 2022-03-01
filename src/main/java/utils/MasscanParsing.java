package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

/**
 * @author 7w1st22
 * @package_name utils    创建新文件的包的名称
 * @date 2022/2/28	当前系统日期
 * @time 10:25	当前系统时间
 */
public class MasscanParsing {
    public ArrayList masscanParsing(String filepath) {
        ArrayList iplist = new ArrayList();
        try {
            File file = new File(filepath);
            SAXReader reader = new SAXReader();
            Document doc = reader.read(file);
            Element root = doc.getRootElement();
            List<Element> elements = root.elements();
            for (Element element : elements) {
                if (element.getName().equals("host")) {
                    List<Element> elements1 = element.elements();
                    for (Element element1 : elements1) {
                        if (element1.getName().equals("address")) {
                            String addr = element1.attributeValue("addr");
                            iplist.add(addr);
                        }
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return iplist;
    }
}
