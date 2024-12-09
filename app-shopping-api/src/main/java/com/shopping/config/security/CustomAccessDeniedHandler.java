package com.shopping.config.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @Component

// This is taken care as part of centralized Exception , keeping this for referal
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(
            HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex)
            throws IOException, ServletException {

        // Option 1: Custom error message in the response body
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter()
                .write("Access Denied: You do not have permission to access this resource.");

        // Option 2: Redirect to a custom error page (uncomment if needed)
        // response.sendRedirect("/error-403");

        // Option 3: Forward to a custom error page (using internal forwarding)
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/error-403");
        // dispatcher.forward(request, response);
    }
}
