package swp.quizpracticingsystem.serviceImple;

import swp.quizpracticingsystem.NotFound.UserNotFoundException;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.UserRepository;
import swp.quizpracticingsystem.service.IUserService;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

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
