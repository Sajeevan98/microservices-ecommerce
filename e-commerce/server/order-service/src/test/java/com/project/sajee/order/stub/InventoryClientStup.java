package com.project.sajee.order.stub;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStup {

    public static void call1(String code, Integer quantity) {
        stubFor(
                get(urlEqualTo("/api/v1.0/inventory?code=" + code + "&quantity=" + quantity))
                        .willReturn(aResponse()
                                .withStatus(200)
                                .withHeader("Content-Type", "application/json")
                                .withBody("true")
                        )
        );
    }
}
