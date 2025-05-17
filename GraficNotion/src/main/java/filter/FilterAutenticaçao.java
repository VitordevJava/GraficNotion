package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/principal/*") // Intercepta todas as requisições que vierem do projeto ou mapeamentos
public class FilterAutenticaçao extends HttpFilter implements Filter {
       
    public FilterAutenticaçao() {
        super();
    }

    // encerra os processos quando o servidor é parado
	public void destroy() {
		
	}
	
	// Intercepta todas as requisições que vem do projeto
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletRequest session = (HttpServletRequest) req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");

		String urlParaAutenticar = req.getServletPath(); // Url que está sendo acessada
		
		// Valida se o usuario está logado, senão envia novamente para a tela de login 
		
		if (usuarioLogado == null || (usuarioLogado != null && usuarioLogado.isEmpty())
				&& urlParaAutenticar.contains("ServletLogin")) {
			
			RequestDispatcher redirecionar = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login");
			redirecionar.forward(request, response);
		}
		chain.doFilter(request, response);
	}
	
	// é executado assim que inicia o sistema
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
