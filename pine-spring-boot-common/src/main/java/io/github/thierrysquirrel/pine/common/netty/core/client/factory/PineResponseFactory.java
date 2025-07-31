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

import io.github.thierrysquirrel.pine.common.netty.domain.PineResponse;

import java.util.List;

/**
 * ClassName: PineResponseFactory
 * Description:
 * date: 2019/10/18 20:25
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class PineResponseFactory {
    private PineResponseFactory() {
    }

    private static PineResponse getPineResponse() {
        return new PineResponse ();
    }

    public static PineResponse buildByProducersNameGetUrls(List<String> clientServiceUrlList) {
        PineResponse pineResponse = getPineResponse ();
        pineResponse.setData (clientServiceUrlList);
        return pineResponse;
    }

    public static PineResponse buildRpc(Object object) {
        PineResponse pineResponse = getPineResponse ();
        pineResponse.setData (object);
        return pineResponse;
    }

    public static PineResponse buildSynchronous(String clientServiceUrl){
        PineResponse pineResponse = getPineResponse ();
        pineResponse.setData (clientServiceUrl);
        return pineResponse;
    }

}
