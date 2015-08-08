package sage.web.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(0)
public class AuthExceptionHandler {
  @ExceptionHandler(RequireLoginException.class)
  public String redirectToLogin(HttpServletRequest request) {
    String uri = request.getRequestURI();
    if (request.getQueryString() != null) {
      uri += ("?" + request.getQueryString());
    }
    return "redirect:/login?" + Auth.getRedirectGoto(uri);
  }
}
