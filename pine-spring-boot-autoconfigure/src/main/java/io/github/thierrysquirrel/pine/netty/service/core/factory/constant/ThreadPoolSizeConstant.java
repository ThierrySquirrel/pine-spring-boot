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

package io.github.thierrysquirrel.pine.netty.service.core.factory.constant;

/**
 * ClassName: ThreadPoolSizeConstant
 * Description:
 * date: 2019/10/18 13:33
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public enum ThreadPoolSizeConstant {

    /**
     * PineServiceInitCorePoolSize
     */
    PINE_SERVICE_INIT_CORE_POOL_SIZE (1),
    /**
     * PineServiceInitMaximumPoolSize
     */
    PINE_SERVICE_INIT_MAXIMUM_POOL_SIZE (1),
    /**
     * PineServiceInitKeepAliveTime
     */
    PINE_SERVICE_INIT_KEEP_ALIVE_TIME (0),
    /**
     * PineServiceInitCapacity
     */
    PINE_SERVICE_INIT_CAPACITY (1),
    /**
     * PineServiceBusinessKeepAliveTime
     */
    PINE_SERVICE_BUSINESS_KEEP_ALIVE_TIME (0),
    /**
     * PineServiceHeartbeatCorePoolSize
     */
    PINE_SERVICE_HEARTBEAT_CORE_POOL_SIZE (1),
    /**
     * SynchronousProducersKeepAliveTime
     */
    SYNCHRONOUS_PRODUCERS_KEEP_ALIVE_TIME (0),
    /**
     * SynchronousProducersCapacity
     */
    SYNCHRONOUS_PRODUCERS_CAPACITY (1024);
    private final int value;

    ThreadPoolSizeConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
