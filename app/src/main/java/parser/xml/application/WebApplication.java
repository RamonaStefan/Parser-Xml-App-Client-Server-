package parser.xml.application;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.omg.CORBA.Request;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

//    public void handle(String target,
//                       Request baseRequest,
//                       HttpServletRequest request,
//                       HttpServletResponse response)
//            throws IOException, ServletException
//    {
//        response.setContentType("text/html;charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_OK);
////        baseRequest.setHandled(true);
////        response.getWriter().println(new String(Files.readAllBytes(Paths.get("E:\\FACULTATE\\SBC\\ParserXmlApplication\\client\\src\\main\\resources\\home.html")), StandardCharsets.UTF_8));
//
//    }

    public WebApplication() {
        super();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(WebApplication.class, args);
//        Server server = new Server(8080);
//        server.setHandler(new ServletHandler());
//
//        server.start();
//        server.join();
    }
}