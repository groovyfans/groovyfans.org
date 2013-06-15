dataSource {
    pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	username = "rain"
	password = "rain"
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 60000
		timeBetweenEvictionRunsMillis = 60000
		maxWait = 10000
	}
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "create" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/groovyfans_dev"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/linkq_test"
        }
    }
    production {
        dataSource {
			dbCreate = "update"
			url = 'jdbc:mysql://localhost/groovyfans?useUnicode=true&characterEncoding=utf8'
			dialect = org.hibernate.dialect.MySQLInnoDBDialect
			driverClassName = 'com.mysql.jdbc.Driver'
			username = 'gf'
			password = "gf"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
