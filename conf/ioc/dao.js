var ioc = {
	dao : {
		type : "org.nutz.dao.impl.NutDao",
		args : [ {
			refer : "dataSource"
		} ]
	},
	dataSource : {
		type : "com.alibaba.druid.pool.DruidDataSource",
		fields : {
			driverClassName : "org.h2.Driver",
			url : 'jdbc:h2:nutz'
		}
	}
}