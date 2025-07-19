package com.pateluday07.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "care-tip-service", url = "${care.tip.service.url}")
public interface CareTipClient {
}
