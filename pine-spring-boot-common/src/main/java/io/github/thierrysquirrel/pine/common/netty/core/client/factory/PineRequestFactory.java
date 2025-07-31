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

package io.github.thierrysquirrel.pine.common.netty.core.client.factory;

import io.github.thierrysquirrel.pine.common.netty.domain.PineRequest;

/**
 * ClassName: PineRequestFactory
 * Description:
 * date: 2019/10/18 15:08
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class PineRequestFactory {
    private PineRequestFactory() {
    }

    private static PineRequest createPineRequest() {
        return new PineRequest ();
    }

    public static PineRequest buildPinePineRequest(String clientServiceName, String clientServiceUrl) {
        PineRequest pineRequest = createPineRequest ();
        pineRequest.setParameters (new Object[]{clientServiceName, clientServiceUrl});
        return pineRequest;
    }

    public static PineRequest buildSynchronousProducersPineRequest(String clientServiceName, String clientServiceUrl) {
        return buildPinePineRequest (clientServiceName, clientServiceUrl);
    }

    public static PineRequest buildByProducersNameGetUrls(String producersName) {
        PineRequest pineRequest = createPineRequest ();
        pineRequest.setParameters (new Object[]{producersName});
        return pineRequest;
    }

    public static PineRequest buildRpc(String coordinate, Object[] args) {
        PineRequest pineRequest = createPineRequest ();
        pineRequest.setParameters (new Object[]{coordinate, args});
        return pineRequest;
    }
}
