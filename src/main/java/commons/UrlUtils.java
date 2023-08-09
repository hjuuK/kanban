package commons;

import jakarta.servlet.http.HttpServletRequest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlUtils {
    public static long getPatternData(HttpServletRequest req, String pattern) {
        String URI = req.getRequestURI();
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(URI);
        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        }

        return 0L;
    }
}
