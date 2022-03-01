package entity;

import java.util.List;
import java.util.Map;

/**
 * @author 7w1st22
 * @package_name entity    创建新文件的包的名称
 * @date 2022/2/28	当前系统日期
 * @time 10:22	当前系统时间
 */
public class Nmap {
    private String ip;
    private String mac;
    private String os;
    private List<Map<String, String>> ports;

    public Nmap() {
    }

    public Nmap(String ip, String mac, String os, List<Map<String, String>> ports) {
        this.ip = ip;
        this.mac = mac;
        this.os = os;
        this.ports = ports;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public List<Map<String, String>> getPorts() {
        return ports;
    }

    public void setPorts(List<Map<String, String>> ports) {
        this.ports = ports;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "Nmap{" +
                "ip='" + ip + '\n' +
                ", mac='" + mac + '\n' +
                ", os='" + os + '\n' +
                ", ports=" + ports +
                '}';
    }
}
