package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//3.提供SpringBoot项目启动器(初始化项目内部Servlet组件)
/*原：public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}*/
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//4.重写一个父类中的方法configure(),执行初始化的项目启动类是谁(SbPackApplication)
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    //return super.configure(builder);
		return builder.sources(DemoApplication.class);
	}
}