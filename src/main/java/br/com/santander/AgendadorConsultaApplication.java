package br.com.santander;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@SpringBootApplication
@EnableCaching
public class AgendadorConsultaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendadorConsultaApplication.class, args);
	}

	@Bean
	public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
		RedisCacheWriter redisCacheWriter = RedisCacheWriter
				.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
		RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
				.serializeValuesWith(
						RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()));
		return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
	}
}
