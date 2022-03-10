//package io.harmed.easyeng.service.security;
//
//import io.harmed.easyeng.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private final UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(final String login) {
//        final var user = userRepository
//                .findByLogin(login)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found, login: %s", login)));
//
//        /*todo: extend logic by allowing multiple roles*/
//        final var authority = new SimpleGrantedAuthority(user.getRole().name());
//
//        return new User(user.getLogin(), user.getPassword(), Set.of(authority));
//    }
//}
