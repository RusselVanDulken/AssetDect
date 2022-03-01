package utils;

import org.dom4j.DocumentException;
import java.io.IOException;
import java.util.ArrayList;
/**
 * @author 7w1st22
 * @package_name utils    创建新文件的包的名称
 * @date 2022/2/28	当前系统日期
 * @time 10:29	当前系统时间
 */
public class AssetDet_Masscan {
    private static Runtime runtime = Runtime.getRuntime();
    private static String path = "/usr/lib/kxyjyids/data/assetscan/";
    public AssetDet_Masscan(String IPAddress) throws IOException, DocumentException {
        //masscan --ping {segment} --rate 10000 -oX /usr/lib/kxyjyids/data/assetscan/ip_result.xml --wait 0
        String masscan_result = path+"Masscan_"+IPAddress+".xml";
        runtime.exec(new String[]{"masscan","--ping",IPAddress,"--rate","10000","-oX",masscan_result,"--wait","0"});
        MasscanParsing mp = new MasscanParsing();
        ArrayList<String> ip_result = mp.masscanParsing(masscan_result);
        for(int i = 0 ; i< ip_result.size();i++){
            new AssetDet_Nmap(ip_result.get(i).trim());
        }
    }
}