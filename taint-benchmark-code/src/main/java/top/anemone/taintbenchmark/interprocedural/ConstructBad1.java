package top.anemone.taintbenchmark.interprocedural;

import top.anemone.taintbenchmark.auxiliary.BadConstructor;
import top.anemone.taintbenchmark.auxiliary.Transformer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 该类误报很可能扫描器使用CHA构建调用图
 */
@WebServlet("/IntraProcedural/ConstructBad1")
public class ConstructBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        
        Transformer constructor=new BadConstructor(source);
        source = constructor.transform("nonce");
        
        Runtime.getRuntime().exec(source); // sink
    }
}
