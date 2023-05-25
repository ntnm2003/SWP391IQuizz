package swp.quizpracticingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swp.quizpracticingsystem.NotFound.UserNotFoundException;
import swp.quizpracticingsystem.model.User;
import swp.quizpracticingsystem.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService  {

    public List<User> listAll() ;

    public void save(User user) ;

    public User get(Integer id) throws UserNotFoundException;


}
