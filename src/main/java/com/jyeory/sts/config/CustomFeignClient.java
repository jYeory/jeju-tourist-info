package com.jyeory.sts.config;

import feign.Client;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.jyeory.sts.data.feign")
public class CustomFeignClient {

	private SSLSocketFactory sslContextFactory() throws
		NoSuchAlgorithmException, KeyManagementException {
		SSLContext ssl_ctx = SSLContext.getInstance("TLS");
		TrustManager[] certs = new TrustManager[]{
			new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[]{};
				}

				public void checkClientTrusted(X509Certificate[] certs, String t) {
				}

				public void checkServerTrusted(X509Certificate[] certs, String t) {
				}
			}};
		ssl_ctx.init(null, certs, new SecureRandom());
		return ssl_ctx.getSocketFactory();
	}

	@Bean
	public feign.Client client() throws KeyManagementException, NoSuchAlgorithmException {
		return new Client.Default(sslContextFactory(), (hostname, session) -> true);
	}
}
