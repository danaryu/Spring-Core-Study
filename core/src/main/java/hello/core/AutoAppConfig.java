package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //TestConfig를 제외한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class),
        basePackages = "hello.core"
)
public class AutoAppConfig {
/*
    @Bean(name = "memoryMemberRepository")
    MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
*/
}
