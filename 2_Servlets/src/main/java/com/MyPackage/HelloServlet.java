package com.MyPackage;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("In Service");

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        out.println("<H2><b>Hello from HelloServlet</b></H2>");
    }
}
