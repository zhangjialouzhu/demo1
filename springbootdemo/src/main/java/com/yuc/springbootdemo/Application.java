package com.yuc.springbootdemo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.winter.mapper")//将项目中对应的mapper类的路径加进来
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	//配置mybatis的分页插件pageHelper
	@Bean
	PageInterceptor pageHelper() throws Exception{
		//分页插件
		PageInterceptor pageHelper = new PageInterceptor();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		//添加插件
		new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
		PathMatchingResourcePatternResolver resolver =new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 指定mybatis.xml文件路径
		sqlSessionFactoryBean.setMapperLocations(resolver
				.getResources("classpath:/mapper/*.xml"));
		return pageHelper;
	}
}
