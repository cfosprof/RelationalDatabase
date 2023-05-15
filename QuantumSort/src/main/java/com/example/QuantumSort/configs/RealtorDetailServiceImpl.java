package com.example.QuantumSort.configs;
import com.example.QuantumSort.models.ApplicationUser;
import com.example.QuantumSort.repos.ClientRepository;
import com.example.QuantumSort.repos.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class RealtorDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser user = agentRepository.findByUsername(username);
        if (user == null) {
                throw new UsernameNotFoundException("You are not signed up.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(ApplicationUser user) {
        String userRole = user.isAgent() ? "AGENT" : "CLIENT";
        return AuthorityUtils.createAuthorityList(userRole);
    }
}
