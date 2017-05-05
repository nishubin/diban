package com.nishubin.work.util;

import java.net.URL;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;


public class EhcacheUtil {
	
	public static void main(String[] args) {
		
		CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
		          .withCache("preConfigured",
		               CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
		                                              ResourcePoolsBuilder.heap(100))
		               .build())
		          .build(true);

		     
		      Cache<String, Object> myCache = cacheManager.createCache("myCache",
		          CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, Object.class,
		                                        ResourcePoolsBuilder.heap(100)).build());

		      myCache.put("sss", "da one!");
		      String value = (String) myCache.get("sss");
		      System.out.println("測試"+value);
		      cacheManager.close();

	}
	 
}  