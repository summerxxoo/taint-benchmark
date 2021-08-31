package top.anemone.taintbenchmark.fieldsensitive;


import top.anemone.taintbenchmark.auxiliary.Container;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FieldSensitive/FieldGood2")
@SuppressWarnings("Duplicates")
public class FieldGood2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("xss");
        
        Container<String> a = new Container<>(source,"clean");
        
        Runtime.getRuntime().exec(a.getClean()); // sink
    }

}
