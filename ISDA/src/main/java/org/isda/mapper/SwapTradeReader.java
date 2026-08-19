package org.isda.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public final class SwapTradeReader {

    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    private SwapTradeReader() {}

    public static SwapTrade readFromFile(String path) throws IOException {
        return MAPPER.readValue(new File(path), SwapTrade.class);
    }

    public static SwapTrade readFromJson(String json) throws IOException {
        return MAPPER.readValue(json, SwapTrade.class);
    }
}
