package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.User;
import Team4.egg.AfterClass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void createUser(User user){ //poner validaciones
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user){ //validaciones
        User us = userRepository.findById(user.getId()).get();
        us.setEmail(user.getEmail()); //
        us.setPassword(user.getPassword());//
        us.setUser_name(user.getUser_name());//
        userRepository.save(us);
    }

    @Transactional(readOnly = true)
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)//validaciones
    public User getById(int id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    public void deleteById(int id){//validaciones
        userRepository.deleteById(id);
    }

//    @Transactional
//    public void enableById(Integer id){ userRepository.enableById(id); }
}
