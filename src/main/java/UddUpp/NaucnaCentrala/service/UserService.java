package UddUpp.NaucnaCentrala.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import UddUpp.NaucnaCentrala.model.User;
import UddUpp.NaucnaCentrala.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User findByEmail(String string) {
		return userRepository.findByEmail(string);
		
	}

	

	public User save(User createdUser) {
		// TODO Auto-generated method stub
		return userRepository.save(createdUser);
	}



	public User findOne(Long i) {
		// TODO Auto-generated method stub
		return userRepository.getOne(i);
	}
	
	public void setCurrentUser(User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("Author"));
        Authentication authentication = new PreAuthenticatedAuthenticationToken(user.getId(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        try {
            Long id = Long.parseLong(auth.getName());
            Optional<User> user = userRepository.findById(id);
            User ret = user.orElseGet(null);
            return ret;
        } catch (Exception e) {
            return null;
        }
    }



	public User checkUser(User checkLoggedIn) {
		User found = userRepository.findByEmail(checkLoggedIn.getEmail());
		if(found!=null){
			if(checkLoggedIn.getPassword().equals(found.getPassword())){
				return found;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}



	public User findByPassword(String fieldValue) {
		// TODO Auto-generated method stub
		return userRepository.findByPassword(fieldValue);
	}
	
	
}
