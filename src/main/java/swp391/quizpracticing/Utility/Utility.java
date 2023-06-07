package swp391.quizpracticing.Utility;

import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.model.User;

public class Utility {

        private static final ModelMapper mapper = new ModelMapper();

        private Utility() {
            //    Overwrite default constructor
        }

        public static String getSiteURL(HttpServletRequest request) {
            String siteURL = request.getRequestURL().toString();
            return siteURL.replace(request.getServletPath(), "");
        }

        public static UserDTO mapUser(User user) {
            if (user == null) return null;
            if (user.getId() == null) return null;
            return mapper.map(user, UserDTO.class);
        }

}
