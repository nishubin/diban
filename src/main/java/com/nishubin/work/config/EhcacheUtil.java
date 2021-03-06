package com.nishubin.work.config;

import java.net.URL;

import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
@Component
public class EhcacheUtil {
	private static final String path = "/ehcache.xml";  
	  
    private URL url;  
  
    private CacheManager manager;  
  
    private EhcacheUtil() {  
    	System.out.println("初始化cach");
        url = getClass().getResource(path);  
        manager = CacheManager.create(url);  
    }  
  
    public void put(String cacheName, String key, Object value) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = new Element(key, value);  
        cache.put(element);  
    }  
  
    public Object get(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        Element element = cache.get(key);  
        return element == null ? null : element.getObjectValue();  
    }  
  
    public Cache get(String cacheName) {  
        return manager.getCache(cacheName);  
    }  
  
    public void remove(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        cache.remove(key);  
    }  
    
}
