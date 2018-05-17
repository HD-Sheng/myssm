package com.demo.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

public class UNIDUtil {
	private SecureRandom seeder;

	public UNIDUtil() {
		this.seeder = new SecureRandom();
	}

	public String getUNID() {
		StringBuffer buf = new StringBuffer();
		long time = System.currentTimeMillis();
		int timeLow = (int) time & 0xFFFFFFFF;
		int node = this.seeder.nextInt();
		String midString = null;
		try {
			InetAddress inet = InetAddress.getLocalHost();
			byte[] bytes = inet.getAddress();
			String hexAddress = hexFormat(getInt(bytes), 8);
			String hash = hexFormat(System.identityHashCode(this), 8);
			midString = hexAddress + hash;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if (midString == null) {
			midString = "0000000000000000";
		}
		buf.append(midString).append(hexFormat(timeLow, 8)).append(hexFormat(node, 8));
		return buf.toString();
	}

	private String hexFormat(int number, int digits) {
		String hex = Integer.toHexString(number).toUpperCase();
		if (hex.length() >= digits) {
			return hex.substring(0, digits);
		}
		int padding = digits - hex.length();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < padding; i++) {
			buf.append("0");
		}
		buf.append(hex);
		return buf.toString();
	}

	private int getInt(byte[] bytes) {
		int size = bytes.length > 32 ? 32 : bytes.length;
		int result = 0;
		for (int i = size - 1; i >= 0; i--) {
			if (i == size - 1)
				result += bytes[i];
			else
				result += (bytes[i] << 4 * (size - 1 - i));
		}
		return result;
	}
}
