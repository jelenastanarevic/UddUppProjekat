package UddUpp.NaucnaCentrala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import UddUpp.NaucnaCentrala.model.Coauthor;

public interface CoauthorRepository extends JpaRepository<Coauthor, Long> {

	List<Coauthor> findByArticleId(Long id);

}
