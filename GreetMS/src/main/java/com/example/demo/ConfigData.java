package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "configdata")
public class ConfigData {
	private String manageEmployeeUrl;

	public String getManageEmployeeUrl() {
		return manageEmployeeUrl;
	}

	public void setManageEmployeeUrl(String manageEmployeeUrl) {
		this.manageEmployeeUrl = manageEmployeeUrl;
	}
}

