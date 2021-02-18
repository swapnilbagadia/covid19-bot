package com.demo.covidbot.configs;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Swapnil Bagadia
 */

@Configuration
public class RedisConfig {

    @Bean
    public RedisAsyncCommands<String, byte[]> redisAsyncCommands() {
        RedisURI redisUri = RedisURI.builder().withHost("localhost").withPort(6379).build();
        RedisClient client = RedisClient.create(redisUri);
        return client.connect(RedisCodec.of(new StringCodec(), new ByteArrayCodec())).async();
    }

    @Bean
    public RedisCommands<String, byte[]> redisCommands() {
        RedisURI redisUri = RedisURI.builder().withHost("localhost").withPort(6379).build();
        RedisClient client = RedisClient.create(redisUri);
        return client.connect(RedisCodec.of(new StringCodec(), new ByteArrayCodec())).sync();
    }
}
