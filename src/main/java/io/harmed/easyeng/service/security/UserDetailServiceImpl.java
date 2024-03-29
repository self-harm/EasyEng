package io.harmed.easyeng.service.security;

import io.harmed.easyeng.model.Role;
import io.harmed.easyeng.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String login) {
        final var user = userRepository
                .findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found, login: %s", login)));

        final Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().stream()
                .map(Role::getName)
                .forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

        return new User(user.getLogin(), user.getPassword(), authorities);
    }
}
