package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextPathListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc =  sce.getServletContext();
		sc.setAttribute("cp", sc.getContextPath()); // /pbl
	}
	//톰캣이 구동하기 직전에 딱 한번 수행함.(?) 맞나
}
