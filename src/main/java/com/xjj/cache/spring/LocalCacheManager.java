package com.xjj.cache.spring;

import java.util.Collection;

import org.springframework.cache.support.AbstractCacheManager;

public class LocalCacheManager extends AbstractCacheManager {
	   private Collection<? extends LocalCache> caches; 
	   
	   /** 
	   * Specify the collection of Cache instances to use for this CacheManager. 
	   */ 
	   public void setCaches(Collection<? extends LocalCache> caches) { 
	     this.caches = caches; 
	   } 

	   @Override 
	   protected Collection<? extends LocalCache> loadCaches() { 
	     return this.caches; 
	   } 

}
