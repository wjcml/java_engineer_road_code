package com.mysql.spring_split.common.datasource;

import com.mysql.spring_split.common.DataSourceKey;
import com.mysql.spring_split.config.MasterConfig;
import com.mysql.spring_split.config.SlaveConfig;
import com.zaxxer.hikari.HikariConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Primary
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {
	/**多个数据源的Map*/
	private final Map<Object, Object> targetDataSources = new ConcurrentHashMap<>();

	@Autowired
	MasterConfig masterConfig;
	
	@Autowired
	SlaveConfig slaveConfig;
		
	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceHolder.getDataSource();
	}

	@PostConstruct
	public void init(){
		targetDataSources.put(DataSourceKey.MASTER, masterConfig.masterDataSource());
		targetDataSources.put(DataSourceKey.SLAVE, slaveConfig.slaveDataSource());

		// 配置数据源
		this.setTargetDataSources(targetDataSources);
		// 默认为主数据源用于写数据
		this.setDefaultTargetDataSource(masterConfig.masterDataSource());
	}
}
