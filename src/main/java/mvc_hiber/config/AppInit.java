package mvc_hiber.config;

        import jakarta.servlet.FilterRegistration;
        import jakarta.servlet.ServletContext;
        import jakarta.servlet.ServletException;
        import org.springframework.web.filter.CharacterEncodingFilter;
        import org.springframework.web.filter.HiddenHttpMethodFilter;
        import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
/*    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }
    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
    }*/
//метод, который регистрирует фильтр для установки кодировки символов
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        FilterRegistration.Dynamic encodingFilter = aServletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameter("encoding", "UTF-8");
        encodingFilter.setInitParameter("forceEncoding", "true");
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");
        aServletContext.addFilter("hiddenHttpMethodFilter", new HiddenHttpMethodFilter()) //добавление фильтра, который передаст запрос в нужный метод контроллера
            .addMappingForUrlPatterns(null, true, "/*");
    }
}