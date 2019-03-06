package com.example.shixing.cwx.cardiy.utils;

import android.util.Log;


import com.jinglangtech.cardiy.constants.Constants;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;


public class DESUtils
{

	private static final String KEY = "sfebhyu#";


	// 解密数据

	/**
	 * DES解密
	 *
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception lee on 2016-12-26 00:28:18
	 */
	public static String DecodeDES(String message, String key) throws Exception
	{

		byte[] bytesrc = convertHexString(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	/**
	 * DES解密
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public static String EncodeDES(String message) throws Exception
	{
		Log.i(Constants.Log_key,message);
		return EncodeDES(message, KEY);
	}


	/**
	 * DES加密
	 *
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception lee on 2016-12-26 00:28:28
	 */
	public static String EncodeDES(String message, String key) throws Exception
	{
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
		return toHexString(cipher.doFinal(message.getBytes("UTF-8")));
	}



	public static byte[] convertHexString(String ss)
	{
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++)
		{
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}
		return digest;
	}

	public static String toHexString(byte b[])
	{
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++)
		{
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}
		return hexString.toString();
	}

//	public static void main(String[] args) throws Exception
//	{
//
//		String cKey = "sfebhyu#";
//		// 需要加密的字串
//		String cSrc = "reg☯15962128923☯zq";
//		System.out.println(cSrc);
//		// 加密
//		String enString = Md5Utils.EncodeDES(cSrc, cKey);
//		System.out.println("加密后的字串是：" + enString);
//
//		// 解密
//		String DeString = Md5Utils.DecodeDES(enString, cKey);
//		System.out.println("解密后的字串是：" + DeString);
//	}
}
