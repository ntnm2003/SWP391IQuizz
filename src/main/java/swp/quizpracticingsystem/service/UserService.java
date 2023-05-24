package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.NotFound.UserNotFoundException;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository userRepo;

    public List<User> listAll() {
        return (List<User>) userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = userRepo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new UserNotFoundException("Could not find any users with ID " + id);
    }


}
