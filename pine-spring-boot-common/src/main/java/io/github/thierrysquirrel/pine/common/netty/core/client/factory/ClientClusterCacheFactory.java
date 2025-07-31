package io.github.thierrysquirrel.pine.common.netty.core.client.factory;

import io.github.thierrysquirrel.pine.common.netty.core.client.ClientInit;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.constant.SeparatorConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: ClientFactory
 * Description:
 * date: 2025/7/31 13:49
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class ClientClusterCacheFactory {
    private static final ThreadLocal<Map<String, List<ClientInit>>> CLIENT_CACHE = new InheritableThreadLocal<>();
    private static final ThreadLocal<Map<String, AtomicInteger>> CLIENT_CACHE_OFFSET = new InheritableThreadLocal<>();

    private ClientClusterCacheFactory() {
    }

    public static ClientInit getClientInit(String clusterUrl, String producerName) {
        isEmpty(CLIENT_CACHE);
        isEmpty(CLIENT_CACHE_OFFSET);

        List<ClientInit> clientInitList = CLIENT_CACHE.get().computeIfAbsent(producerName, name -> createClientInitList(clusterUrl));
        int increment = CLIENT_CACHE_OFFSET.get().computeIfAbsent(producerName, key -> new AtomicInteger()).incrementAndGet();
        int offset = increment % clientInitList.size();
        int positiveOffset = (offset + clientInitList.size()) % clientInitList.size();
        return clientInitList.get(positiveOffset);
    }
    private static<K,V> void isEmpty(ThreadLocal<Map<K,V>> threadLocal){

        if (threadLocal.get()==null){
            threadLocal.set(new ConcurrentHashMap<>());
        }
    }

    private static List<ClientInit> createClientInitList(String clusterUrl) {
        String[] urlSplit = clusterUrl.split(SeparatorConstant.URL_SEPARATOR.getValue());
        List<ClientInit> clientInitList = new ArrayList<>();
        for (String url : urlSplit) {
            clientInitList.add(new ClientInit(url));
        }
        return clientInitList;
    }

}
