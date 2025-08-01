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
 * ClassName: ThreadPoolNameConstant
 * Description:
 * date: 2019/10/18 13:33
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public enum ThreadPoolNameConstant {
    /**
     * PineServiceInitThreadPool
     */
    PINE_SERVICE_INIT ("PineServiceInit"),
    /**
     * PingServiceBusiness
     */
    PING_SERVICE_BUSINESS ("PingServiceBusiness"),
    /**
     * PingServiceHeartbeat
     */
    PING_SERVICE_HEARTBEAT ("PingServiceHeartbeat"),
    /**
     * SynchronousProducers
     */
    SYNCHRONOUS_PRODUCERS("SynchronousProducers");
    private final String value;

    ThreadPoolNameConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
