package swp391.quizpracticing.Utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class Utility {
    public static String getSiteURL() {
        String siteUrl = ServletUriComponentsBuilder
                .fromCurrentRequest().build().toString();
        String domain=siteUrl.substring(0, siteUrl
                                .indexOf("/", 8));
        return domain;
    }
}