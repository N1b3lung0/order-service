package com.n1b3lung0.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "inventory", url = "http://localhost:8082")
public interface InventoryClient {

    @RequestMapping(method = RequestMethod.GET, value = "/inventories")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}