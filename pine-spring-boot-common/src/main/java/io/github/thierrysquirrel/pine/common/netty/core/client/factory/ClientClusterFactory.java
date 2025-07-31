package io.github.thierrysquirrel.pine.common.netty.core.client.factory;

import io.github.thierrysquirrel.pine.common.netty.core.client.ClientInit;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.constant.ClientConstant;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * ClassName: ClientFactory
 * Description:
 * date: 2025/7/31 13:36
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class ClientClusterFactory {

    public static PineRequestContext request(String clusterUrl, String producerName, PineRequestContext pineRequestContext) throws InterruptedException, TimeoutException, ExecutionException {
        ClientInit clientInit = ClientClusterCacheFactory.getClientInit(clusterUrl,producerName);
        clientInit.init ();
        clientInit.getChannel ().writeAndFlush (pineRequestContext);
        return clientInit.getCompletableFuture ().get (ClientConstant.TIMEOUT.getValue (), TimeUnit.MILLISECONDS);
    }
}
