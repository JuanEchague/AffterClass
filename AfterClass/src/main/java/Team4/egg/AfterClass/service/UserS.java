/*
package Team4.egg.AfterClass.service;

import Team4.egg.AfterClass.entity.User;
import Team4.egg.AfterClass.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Transactional
    public void createUser(User newUser) {
        if (userRepository.existsByEmail(dto.getEmail()))
            throw new IllegalArgumentException("There is already a user associated with the email entered");

        User user = new User();

        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));

       /*
        userRepository.save(user);
    }

    @Transactional
    public void update(User dto) {
        User user = userRepository.findById(dto.getId()).get();

        user.setEmail(dto.getEmail());
        user.setPassword(encoder.encode(dto.getPassword()));
        user.setRole(dto.getRole());

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public void enableById(Integer id) {
        userRepository.enableById(id);
    }

    @Transactional
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
*/
/*
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("There is no user associated with the email entered"));
        GrantedAuthority authority = () -> "ROLE_" + user.getRole().name();

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attributes.getRequest().getSession(true);

        session.setAttribute("id", user.getId());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("role", user.getRole().name());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), singletonList(authority));
    }*//*


}
*/
