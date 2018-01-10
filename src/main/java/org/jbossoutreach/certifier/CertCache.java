package org.jbossoutreach.certifier;

import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;

public class CertCache {
    private static final String CACHE_NAME = "local";
    private static CertCache sInstance;
    private final DefaultCacheManager mCacheManager;
    private final Cache<String, String> mCache; // Maps id to location

    private CertCache() {
        mCacheManager = new DefaultCacheManager();
        mCacheManager.defineConfiguration(CACHE_NAME, new ConfigurationBuilder().build());
        mCache = mCacheManager.getCache(CACHE_NAME);
    }

    public static CertCache getInstance() {
        if (sInstance == null) {
            sInstance = new CertCache();
        }
        return sInstance;
    }

    public String get(String key) {
        return mCache.get(key);
    }

    public void put(String key, String value) {
        mCache.put(key, value);
    }

    public void stop() {
        mCacheManager.stop();
    }
}
