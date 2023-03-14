package health.data.optoehr.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import health.data.optoehr.models.User;
import health.data.optoehr.repositories.RoleRepository;
import health.data.optoehr.repositories.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void newUser(User user, String role) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName(role));
        userRepository.save(user);
    }

    // // 2
    // public void saveUserWithAdminRole(User user) {
    // user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    // user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
    // userRepository.save(user);
    // }

    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public User upgradeUser(User user) {
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User findById(Long id) {
        Optional<User> potentialUser = userRepository.findById(id);
        if (potentialUser.isPresent()) {
            return potentialUser.get();
        }
        return null;
    }
}
