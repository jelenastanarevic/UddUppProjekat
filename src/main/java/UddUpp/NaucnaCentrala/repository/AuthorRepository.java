package UddUpp.NaucnaCentrala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import UddUpp.NaucnaCentrala.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Author findByEmail(String email);

}
