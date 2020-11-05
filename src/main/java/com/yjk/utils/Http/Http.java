package com.yjk.utils.Http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http {

	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		String xmlStr = "baidu";
		post(url, xmlStr);
	}

	public static String post(String url,String xmlStr) {
		System.out.println("发送的地址为："+url);
		System.out.println("发送的报文为："+xmlStr);
		String response = null;
		HttpURLConnection urlCon = null;
		BufferedReader bfr = null;
		DataOutputStream dos = null;
		InputStream in = null;
		InputStreamReader insr = null;
		OutputStream out = null;
		String readLine = null;
		StringBuffer sb = new StringBuffer();
		try {
			urlCon = (HttpURLConnection)new URL(url).openConnection();
			urlCon.setDoInput(true);
			urlCon.setDoOutput(true);
			urlCon.setRequestMethod("POST");
			urlCon.setRequestProperty("content-Length", String.valueOf(xmlStr.getBytes("UTF-8").length));
			urlCon.setRequestProperty("content-type", "text/xml;charset=UTF-8");
			urlCon.setUseCaches(false);
			out = urlCon.getOutputStream();
			dos = new DataOutputStream(out);
			dos.writeBytes(xmlStr);
			out.flush();
			out.close();
			dos.close();
			
			in = urlCon.getInputStream();
		    insr = new InputStreamReader(in);
		    bfr = new BufferedReader(insr);
		    while ((readLine = bfr.readLine()) != null) {
				sb.append(readLine);
				sb.append("\r\n");
			}
		    response = sb.toString();
		    in.close();
		    insr.close();
		    bfr.close();
		    urlCon.disconnect();
		    System.out.println("返回报文为："+response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
				if (dos != null) {
					dos.close();
				}
				if (in != null) {
					in.close();
				}
				if (insr != null) {
					insr.close();
				}
				if (bfr != null) {
					bfr.close();
				}
				if (urlCon != null) {
					urlCon.disconnect();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return response;
	}
}
