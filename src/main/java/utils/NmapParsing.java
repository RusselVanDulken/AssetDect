package utils;

import entity.Nmap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 7w1st22
 * @package_name utils    创建新文件的包的名称
 * @date 2022/2/28	当前系统日期
 * @time 10:27	当前系统时间
 */
public class NmapParsing {
    public Nmap nampparsing(String filepath) throws DocumentException {
        Nmap nmap = new Nmap();
        List<Map<String, String>> ports = new ArrayList<Map<String, String>>();
        Map<String, String> port = new HashMap<>();
        File file = new File(filepath);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(file);
        Element root = doc.getRootElement();
        //取得根节点下的所有节点
        List<Element> elements = root.elements();
        //遍历根节点下的所有节点
        for (Element element : elements) {
            if (element.getName().equals("host")) {
                List<Element> elements_host = element.elements();
                //遍历host下的所有节点
                for (Element element_host : elements_host) {
                    if (element_host.getName().equals("address")) {
                        if (element_host.attributeValue("addrtype").equals("mac")) {
                            nmap.setMac(element_host.attributeValue("addr"));
                        }
                        if (element_host.attributeValue("addrtype").equals("ipv4")) {
                            nmap.setIp(element_host.attributeValue("addr"));
                        }
                    }
                    if (element_host.getName().equals("os")) {
                        List<Element> elements_os = element_host.elements();
                        for (Element element_os : elements_os) {
                            if (element_os.getName().equals("osmatch")) {
                                nmap.setOs(element_os.attributeValue("name"));
                            }
                        }
                    }
//                    取出port中的信息
                    if (element_host.getName().equals("ports")) {
                        List<Element> elements_ports = element_host.elements();
                        //遍历ports下的所有节点
                        for (Element element_ports : elements_ports) {
                            if (element_ports.getName().equals("port")) {
                                port.put("protocol", element_ports.attributeValue("protocol"));
                                port.put("portid", element_ports.attributeValue("portid"));
                                List<Element> elements_port = element_ports.elements();
                                for (Element element_port : elements_port) {
                                    if (element_port.getName().equals("service")) {
                                        port.put("version", element_port.attributeValue("version"));
                                        port.put("name", element_port.attributeValue("name"));
                                        port.put("product", element_port.attributeValue("product"));
                                        ports.add(port);
                                        nmap.setPorts(ports);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return nmap;
    }
}
