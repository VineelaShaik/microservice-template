package com.company.platform.integration.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "sample-service",
        url = "${sample.service.url:http://localhost:9999}",
        dismiss404 = true
)
public interface SampleFeignClient {

    @GetMapping("/api/sample/{id}")
    String getSample(@PathVariable String id);
}
