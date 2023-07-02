package App.config;

import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

public class CustomRequestMatcher implements RequestMatcher {
    private final Pattern pattern;

    public CustomRequestMatcher(String regexPattern) {
        this.pattern = Pattern.compile(regexPattern);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return pattern.matcher(request.getRequestURI()).matches();
    }
}
