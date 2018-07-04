package com.ryw.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * 从外部配置文件读取的相关配置
 * @author ryw
 *
 */
@Configuration
@ConfigurationProperties
public class ContextConfig {

	private String springClientA;
	
	private String springServerB;

	public String getSpringClientA() {
		return springClientA;
	}

	public void setSpringClientA(String springClientA) {
		this.springClientA = springClientA;
	}

	public String getSpringServerB() {
		return springServerB;
	}

	public void setSpringServerB(String springServerB) {
		this.springServerB = springServerB;
	}

	@Override
	public String toString() {
		return "ContextConfig [springClientA=" + springClientA
				+ ", springServerB=" + springServerB + "]";
	}
}
