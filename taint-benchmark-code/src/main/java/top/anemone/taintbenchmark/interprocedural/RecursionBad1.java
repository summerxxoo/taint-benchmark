package top.anemone.taintbenchmark.interprocedural;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 */
@WebServlet("/InterProcedural/RecursionBad1")
public class RecursionBad1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source"); // source
        


        bad(source, System.out, 0);
    }

    private void bad(String s, PrintStream out, int l) throws IOException {
        if (l>100) return;
        bad(s, out,l+1);
        Runtime.getRuntime().exec(s); // sink
    }
}
