package cn.bywin.by;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching
@MapperScan("cn.bywin.*.dao")
@SpringBootApplication(scanBasePackages = "cn.bywin",exclude = {DataSourceAutoConfiguration.class})
@EnableSwagger2
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class);

    }
}