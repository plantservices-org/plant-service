package com.pateluday07.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;

@Component
public class CustomErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String s, Response response) {
        try {
            String body = StreamUtils.copyToString(response.body().asInputStream(), StandardCharsets.UTF_8);
            JsonNode json = objectMapper.readTree(body);
            String customMessage = json.get("message").asText();
            return new FeignException(response.status(), customMessage) {
            };
        } catch (Exception e) {
            return new RuntimeException("Unknown error", e);
        }
    }
}
