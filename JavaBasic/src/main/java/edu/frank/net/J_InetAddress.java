/**
 * CopyRight:
 * ProjectName:
 * JDK Version:
 * File Version:
 * Create Time:
 * Author:
 * Modify History:
 * <date>			<modifier>				<content>
 */
package edu.frank.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @author yoyudenghihi
 *
 */
public class J_InetAddress {

	/**
	 * constructor
	 */
	public J_InetAddress() {

		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param strUrl
	 */
	public static void readNetData(String strUrl){
		try{
			URL url = new URL(strUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String strRev = null;
			while(null != (strRev = br.readLine())){
				System.out.println(strRev);
			}
			br.close();
		}catch(MalformedURLException ex){
			System.err.print(ex);
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}

	/**
	 * main method
	 * @param args console arguments
	 */
	public static void main(String[] args) {

		//String strUrlName = "www.scnu.edu.cn";
		String strUrlAddress = "10.123.15.147";
		String strUrlAll = "http://www.114la.com:8080/image/amazon_120.gif#my_img";
		InetAddress net_ts = null;
		URL url = null;
		try{
			url = new URL(strUrlAll);
			net_ts = InetAddress.getByName(strUrlAddress);
		}catch(UnknownHostException ex){
			System.err.println(ex);
		} catch (MalformedURLException ex) {
			System.err.println(ex);
		}
		if (net_ts != null && url != null){
			System.out.println("The Remote Host IP:" + net_ts.getHostAddress());
			System.out.println("The Remote Host Name:" + net_ts.getHostName());
			System.out.println("isLocal:" + net_ts.isAnyLocalAddress());
			System.out.println("isLinkLocal:" + net_ts.isLinkLocalAddress());
			System.out.println("isLoopback:" + net_ts.isLoopbackAddress());
			System.out.println("protocol=" + url.getProtocol());
			System.out.println("host=" + url.getHost());
			System.out.println("port=" + url.getPort()) ;
			System.out.println("defport=" + url.getDefaultPort());
			System.out.println("file=" + url.getFile());
			System.out.println("ref=" + url.getRef());
			System.out.println("path=" + url.getPath());
			System.out.println("userinfo=" + url.getUserInfo());
			System.out.println("query=" + url.getQuery());
			System.out.println("author=" + url.getAuthority());
			
		}else{
			System.out.println("Can't access:" + net_ts);
		}
		
		readNetData("http://www.baidu.com/index.html");

	}

}
