package com.mysql.spring_split.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 主数据源配置
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.master")
public class MasterConfig extends HikariConfig {

	@Bean
	public DataSource masterDataSource() {
		final HikariDataSource masterDataSource = new HikariDataSource(this);

		return masterDataSource;
	}

}
