package com.interface21.webmvc.servlet.view;

import static com.interface21.web.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interface21.webmvc.servlet.View;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public class JsonView implements View {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void render(final Map<String, ?> model, final HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(APPLICATION_JSON_UTF8_VALUE);

        final var responseBody = objectMapper.writeValueAsString(model);
        response.getWriter().write(responseBody);
    }
}
