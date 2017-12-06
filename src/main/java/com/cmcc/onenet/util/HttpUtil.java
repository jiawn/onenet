package com.cmcc.onenet.util;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.CharEncoding;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wannengjia@gmail.com
 */
public class HttpUtil {

	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	private static Charset chartset = Charset.forName(CharEncoding.UTF_8);

	/**
	 * 获取请求客户端的IP地址
	 *
	 * @param request
	 * @return
	 */
	public String getClientIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		// 判断是否为IPV6地址
		if (ip != null && ip.indexOf(":") >= 0) {
			ip = "127.0.0.1";
		}
		logger.debug("获取客户端浏览器ip地址=" + ip);
		return ip;
	}

	/**
	 * <pre>
	 * post发送json数据请求
	 * 设置了Content-Type=application/json
	 * </pre>
	 *
	 * @param url：请求路径
	 * @param jsonFormString：json格式的字符串
	 * @return
	 * @throws Exception
	 */
	public static JSONObject doPostJson(String url, String jsonFormString, Map<String, Object> headers) throws Exception {
		logger.info("doPostJson请求内容：{}", jsonFormString);

		HttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		if (headers != null && !headers.isEmpty()) {
			headers.forEach((k, v) -> {
				post.addHeader(k, StringUtil.isBlank(v) ? "" : v.toString());
			});
		}
		StringEntity s = new StringEntity(jsonFormString, chartset);
		post.setEntity(s);
		HttpResponse httpResponse = client.execute(post);

		JSONObject response = null;
		String result = EntityUtils.toString(httpResponse.getEntity());
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			logger.info("doPostJson响应结果：{}", result);
			response = JSONObject.parseObject(result);
		} else {
			logger.info("请求响应结果异常: {}", result);
		}
		return response;
	}

	/**
	 * 读取内容
	 *
	 * @param
	 * @return
	 */
	public static String readString(HttpServletRequest request) {
		try {
			StringBuffer out = new StringBuffer();
			InputStream in = request.getInputStream();
			byte[] b = new byte[4096];
			for (int n; (n = in.read(b)) != -1; ) {
				out.append(new String(b, 0, n, chartset));
			}
			return out.toString();
		} catch (Exception e) {
			logger.info("", e);
		}
		return "";
	}

	public static JSONObject doGet(String url, Map<String, Object> headers) throws Exception {

		HttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		if (headers != null && !headers.isEmpty()) {
			headers.forEach((k, v) -> {
				get.addHeader(k, StringUtil.isBlank(v) ? "" : v.toString());
			});
		}
		JSONObject response = null;
		HttpResponse httpResponse = client.execute(get);
		String result = EntityUtils.toString(httpResponse.getEntity()); // 返回JSON格式
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			logger.info("doPost响应结果：{}", result);
			response = JSONObject.parseObject(result);
		} else {
			throw new RuntimeException(result);
		}
		return response;
	}

}
