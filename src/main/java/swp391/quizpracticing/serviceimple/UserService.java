package swp391.quizpracticing.serviceimple;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import swp391.quizpracticing.dto.UserDTO;
import swp391.quizpracticing.model.User;
import swp391.quizpracticing.repository.IUserRepository;
import swp391.quizpracticing.service.IUserService;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Mosena
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    private UserDTO convertEntityToDTO(User entity){
        UserDTO user=modelMapper.map(entity, UserDTO.class);
        return user;
    }

    @Override
    public List<UserDTO> getUsers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return userRepository
                .findAll(pageable)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }
}
