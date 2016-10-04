/*
 * #%L
 * GarethHealy :: ElasticSearch with Watcher Plugin :: Elastic Loader
 * %%
 * Copyright (C) 2013 - 2016 Gareth Healy
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.garethahealy.elastawatch.elasticloader.processors;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class JsonParserProcessor implements Processor {

    private static final TypeReference<List<Map<String, String>>> TYPE_REF = new TypeReference<List<Map<String, String>>>() { };

    @Override
    public void process(Exchange exchange) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Map<String, String>> data = objectMapper.readValue(exchange.getIn().getBody(String.class), TYPE_REF);
        for (Map<String, String> line : data) {
            DateTime date = new DateTime(Long.parseLong(line.get("timeMillis")));
            String value = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").print(date);

            line.put("@timestamp", value);
        }


        exchange.getIn().setBody(data);
    }


}
