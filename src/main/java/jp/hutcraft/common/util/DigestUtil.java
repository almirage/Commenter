package jp.hutcraft.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestUtil {
	private DigestUtil(){}
	
	public static String toMD5(String base) {
		try {
			final MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(base.getBytes());
			final byte[] messageDigest = digest.digest();
			StringBuffer hexString = new StringBuffer();
			for (final byte b : messageDigest) {
				hexString.append(String.format("%02x", b));
			}
			return hexString.toString();
		} catch (final NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(toMD5("test"));
		System.out.println("098f6bcd4621d373cade4e832627b4f6");
	}
}
