package UddUpp.NaucnaCentrala.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import UddUpp.NaucnaCentrala.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String string);

	User findByPassword(String fieldValue);

	

}
