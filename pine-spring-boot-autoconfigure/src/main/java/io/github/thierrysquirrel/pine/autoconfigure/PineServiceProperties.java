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

package io.github.thierrysquirrel.pine.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: PineServiceProperties
 * Description:
 * date: 2019/10/17 20:38
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
@ConfigurationProperties(prefix = PineServiceProperties.PINE_SERVICE_PREFIX)
public class PineServiceProperties {
    public static final String PINE_SERVICE_PREFIX = "pine";
    /**
     * ServiceUrl
     */
    private String serviceUrl;
    /**
     * ClusterServiceUrl
     */
    private String clusterServiceUrl;
    /**
     * Heartbeat interval
     */
    private int heartbeatTime = 4096;
    /**
     * Reject the service after how many times the service is not received
     */
    private int maxNumberHeartbeatTimeouts = 3;
    /**
     * PineServerBusiness
     */
    private int serverBusinessThreadNums = Runtime.getRuntime ().availableProcessors () * 2;
}
