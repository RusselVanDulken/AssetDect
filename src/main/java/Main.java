import org.dom4j.DocumentException;
import utils.AssetDet_Masscan;


import java.io.IOException;

/**
 * @author 7w1st22
 * @package_name PACKAGE_NAME    创建新文件的包的名称
 * @date 2022/2/28	当前系统日期
 * @time 10:24	当前系统时间
 */
public class Main {
    public static void main(String[] args) throws IOException, DocumentException {
        String[] IPaddress= {"192.168.103.1/24","192.168.102.1/24"};
        for (String ip:IPaddress){
            new AssetDet_Masscan(ip);
        }
    }
}
