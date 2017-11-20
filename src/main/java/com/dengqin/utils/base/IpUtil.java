package com.dengqin.utils.base;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by dq on 2017/11/20.
 */
public class IpUtil {

	public static String getLocalIp() {
		Enumeration<NetworkInterface> allNetInterfaces = null;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			return "";
		}
		InetAddress inetAddress = null;
		while (allNetInterfaces.hasMoreElements()) {
			NetworkInterface netInterface = allNetInterfaces.nextElement();
			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				inetAddress = addresses.nextElement();
				if (inetAddress != null && inetAddress instanceof Inet4Address) {
					String ip = inetAddress.getHostAddress();
					if ("127.0.0.1".equals(StringUtil.trim(ip))) {
						continue;
					}
					if ("localhost".equals(inetAddress.getHostName())) {
						continue;
					}
					return ip;
				}
			}
		}
		return "";
	}
}
