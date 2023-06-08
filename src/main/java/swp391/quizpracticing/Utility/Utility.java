package swp391.quizpracticing.Utility;

import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.model.User;

public class Utility {

    private ModelMapper modelMapper;
        private static final ModelMapper mapper = new ModelMapper();

        private Utility() {
            //    Overwrite default constructor
        }

        public static String getSiteURL(HttpServletRequest request) {
            String siteURL = request.getRequestURL().toString();
            return siteURL.replace(request.getServletPath(), "");
        }

    private UserDTO convertEntityToDTO(User entity){
        return modelMapper.map(entity, UserDTO.class);
    }

}
