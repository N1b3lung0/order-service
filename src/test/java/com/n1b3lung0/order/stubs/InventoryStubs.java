package com.n1b3lung0.order.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryStubs {

    public static void stubInventoryCall(String skuCode, Integer quantity) {
        stubFor(get(urlEqualTo("/inventories?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true")));
    }
}
