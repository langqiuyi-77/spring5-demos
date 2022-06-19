package spring04.pojo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"spring04"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
