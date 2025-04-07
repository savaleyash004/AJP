package inetAddress;
import java.net.InetAddress;
import java.net.UnknownHostException;
public class Exp_6{
    public static void main(String[] args) throws UnknownHostException {
    
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("1.Address of local host:=" + ip1);
        InetAddress ip2 = InetAddress.getByName("www.google.com");
        System.out.println("2.Address of string host:=" + ip2);
        byte[] ipaddress = {10, 10, 13, 38};
        InetAddress ip3 = InetAddress.getByAddress(ipaddress);
        System.out.println("3.Host name for ip address:=" + ip3);
        InetAddress[] ip4 = InetAddress.getAllByName("www.pict.edu");
        for (InetAddress inetAddress : ip4) {
            System.out.println("4.address of url=" + inetAddress);
        }
        InetAddress ip5 = InetAddress.getByAddress("pict.edu", ipaddress);
        System.out.println("5.Inetaddress of host with ip address and hostname=" + ip5);
        
        System.out.println("6.Host name of inetaddress=" + ip2.getHostName());
        System.out.println("7.Address of host hold by inetaddress object=" + ip2.getHostAddress());
        System.out.println("8.Address equals or not=" + ip2.equals(ip1));
        System.out.println("9.to sting convert="+ ip2);
        System.out.println("10. it is multicast address or not="+ip2.isMulticastAddress());
        System.out.println("This is InetAddress class use");
    }
}
