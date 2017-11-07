package org.epoint.menu.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/**
 * 
 * @author lilin
 * @date 2016年2月15日 下午2:41:40
 * @annotation 自定义信任管理器
 * 目的：让JSSE信任HTTPS服务器端的安全证书
 * 优点:避免手动导入证书的问题，相对灵活
 * 缺点:编码时要特别的小心，否则留下安全隐患
 */
public class MyX509TrustManager implements X509TrustManager {

	// 检查客户端证书
	public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	// 检查服务器端证书
	public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
	}

	// 返回受信任的X509证书数组
	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}



