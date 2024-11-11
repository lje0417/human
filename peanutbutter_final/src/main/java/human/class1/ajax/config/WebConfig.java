package human.class1.ajax.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 정적 리소스 핸들러 등록
        registry.addResourceHandler("/uploadedImages/**")
                .addResourceLocations("file:C:/Users/user/admin/Documents/Peanutbutter/peanutbutter/src/main/webapp/resources/uploadedImages/");
    }

   @Override
   public void addFormatters(FormatterRegistry registry) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public Validator getValidator() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void configurePathMatch(PathMatchConfigurer configurer) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public MessageCodesResolver getMessageCodesResolver() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void addViewControllers(ViewControllerRegistry registry) {
      // TODO Auto-generated method stub
      
   }

   @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // JSP 파일의 위치와 확장자 설정
        registry.jsp("/WEB-INF/views/", "factoryDetail.jsp");
    }

   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void addCorsMappings(CorsRegistry registry) {
      // TODO Auto-generated method stub
      
   }
}
