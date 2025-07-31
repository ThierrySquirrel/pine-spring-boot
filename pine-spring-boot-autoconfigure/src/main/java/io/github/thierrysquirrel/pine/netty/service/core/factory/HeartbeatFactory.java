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

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName: HeartbeatFactory
 * Description:
 * date: 2019/10/18 15:23
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class HeartbeatFactory {
    private HeartbeatFactory() {
    }

    private static Map<String, List<String>> clientServiceNameMap = Maps.newConcurrentMap ();
    private static Map<String, Integer> heartbeatMap = Maps.newConcurrentMap ();

    private static void putClientServiceName(String clientServiceName, String clientServiceUrl) {
        List<String> clientServiceUrlList = clientServiceNameMap.computeIfAbsent (clientServiceName, k -> new ArrayList<> ());
        clientServiceUrlList.add (clientServiceUrl);
    }

    public static void getClientServicePing(String clientServiceName, String clientServiceUrl, int maxNumberHeartbeatTimeouts) {
        Integer heartbeatQuantity = heartbeatMap.get (clientServiceUrl);
        if (ObjectUtils.isEmpty (heartbeatQuantity)) {
            heartbeatQuantity = maxNumberHeartbeatTimeouts;
            putClientServiceName (clientServiceName, clientServiceUrl);
            log.info ("Service：" + clientServiceName + clientServiceUrl + " Successfully Registered");
        }
        ++heartbeatQuantity;
        if (heartbeatQuantity > maxNumberHeartbeatTimeouts) {
            heartbeatQuantity = maxNumberHeartbeatTimeouts;
        }
        heartbeatMap.put (clientServiceUrl, heartbeatQuantity);

    }


    public static void heartbeatDetection() {
        for (Map.Entry<String, List<String>> entry : clientServiceNameMap.entrySet ()) {

            List<String> clientServiceUrlList = entry.getValue ();
            List<String> clientServiceUrlListBackups = new ArrayList<> (clientServiceUrlList);
            for (String clientServiceUrl : clientServiceUrlListBackups) {
                Integer heartbeatQuantity = heartbeatMap.get (clientServiceUrl);

                --heartbeatQuantity;

                if (heartbeatQuantity <= 0) {
                    heartbeatMap.remove (clientServiceUrl);
                    log.error (" Remove:" + clientServiceUrl);
                    clientServiceUrlList.remove (clientServiceUrl);
                    if (clientServiceUrlList.isEmpty ()) {
                        clientServiceNameMap.remove (entry.getKey ());
                        break;
                    }
                } else {
                    heartbeatMap.put (clientServiceUrl, heartbeatQuantity);
                }

            }

        }
    }

    public static List<String> getClientServiceUrlList(String clientServiceName) {
        return clientServiceNameMap.get (clientServiceName);
    }
}
