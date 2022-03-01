package utils;

import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * @author 7w1st22
 * @package_name utils    创建新文件的包的名称
 * @date 2022/2/28	当前系统日期
 * @time 11:26	当前系统时间
 */
public class AssetDet_Nmap {
    private static final String path = "/usr/lib/kxyjyids/data/assetscan/";
    private static Runtime runtime = Runtime.getRuntime();
    //nmap -O -A -Pn {ip} -oX /usr/lib/kxyjyids/data/assetscan/{ip}.xml --min-rate 64 --host-timeout 1440 --min-hostgroup 64 --min-parallelism 64 > /usr/lib/kxyjyids/data/assetscan/{ip}.out
    public AssetDet_Nmap(String IP) throws IOException, DocumentException {
        runtime.exec(new String[]{"nmap","-O","-A","-Pn",IP,"-oX",path+IP+".xml","--min-rate","64","--host-timeout","1440","--min-hostgroup","64","--min-parallelism","64",">",path+IP+".out"});
        NmapParsing NP = new NmapParsing();
        NP.nampparsing(path+IP+".xml");
    }
}
