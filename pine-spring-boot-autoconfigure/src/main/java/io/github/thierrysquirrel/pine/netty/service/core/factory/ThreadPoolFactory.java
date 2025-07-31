/**
 * Copyright 2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.thierrysquirrel.pine.netty.service.core.factory;

import io.github.thierrysquirrel.pine.netty.service.core.factory.constant.ThreadPoolNameConstant;
import io.github.thierrysquirrel.pine.netty.service.core.factory.constant.ThreadPoolSizeConstant;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * ClassName: ThreadPoolFactory
 * Description:
 * date: 2019/10/17 19:57
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ThreadPoolFactory {
    private ThreadPoolFactory() {
    }

    public static ThreadPoolExecutor createPineServiceInitThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder ()
                .setNameFormat (ThreadPoolNameConstant.PINE_SERVICE_INIT.getValue ()).build ();
        return new ThreadPoolExecutor (ThreadPoolSizeConstant.PINE_SERVICE_INIT_CORE_POOL_SIZE.getValue (),
                ThreadPoolSizeConstant.PINE_SERVICE_INIT_MAXIMUM_POOL_SIZE.getValue (),
                ThreadPoolSizeConstant.PINE_SERVICE_INIT_KEEP_ALIVE_TIME.getValue (),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (ThreadPoolSizeConstant.PINE_SERVICE_INIT_CAPACITY.getValue ()),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy ()
        );
    }

    public static ThreadPoolExecutor createPingServiceBusinessThreadPool(int threadNums) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder ()
                .setNameFormat (ThreadPoolNameConstant.PING_SERVICE_BUSINESS.getValue ()).build ();
        return new ThreadPoolExecutor (threadNums,
                threadNums,
                ThreadPoolSizeConstant.PINE_SERVICE_BUSINESS_KEEP_ALIVE_TIME.getValue (),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy ()
        );
    }

    public static ScheduledThreadPoolExecutor createPineServiceHeartbeatThreadPool() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder ()
                .setNameFormat (ThreadPoolNameConstant.PING_SERVICE_HEARTBEAT.getValue ()).build ();
        return new ScheduledThreadPoolExecutor (ThreadPoolSizeConstant.PINE_SERVICE_HEARTBEAT_CORE_POOL_SIZE.getValue (), threadFactory);
    }

    public static ThreadPoolExecutor createSynchronousProducersThreadPool(int synchronousProducersThreadNums) {
        ThreadFactory threadFactory = new ThreadFactoryBuilder ()
                .setNameFormat (ThreadPoolNameConstant.SYNCHRONOUS_PRODUCERS.getValue ()).build ();
        return new ThreadPoolExecutor (synchronousProducersThreadNums,
                synchronousProducersThreadNums,
                ThreadPoolSizeConstant.SYNCHRONOUS_PRODUCERS_KEEP_ALIVE_TIME.getValue (),
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (ThreadPoolSizeConstant.SYNCHRONOUS_PRODUCERS_CAPACITY.getValue ()),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy ()
        );
    }

}
