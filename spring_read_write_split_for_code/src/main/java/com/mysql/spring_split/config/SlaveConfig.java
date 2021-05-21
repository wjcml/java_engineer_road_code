package com.mysql.spring_split.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 从数据源配置
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.slave")
public class SlaveConfig extends HikariConfig {

	@Bean
	public DataSource slaveDataSource() {
		final HikariDataSource slaveDataSource = new HikariDataSource(this);

		return slaveDataSource;
	}

}
