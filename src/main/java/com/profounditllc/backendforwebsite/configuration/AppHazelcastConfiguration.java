package com.profounditllc.backendforwebsite.configuration;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppHazelcastConfiguration {

    @Bean
    public HazelcastInstance createHazelcastBean() {
        HazelcastInstance hzInstance = Hazelcast.newHazelcastInstance();
        return hzInstance;
    }
}
