package UddUpp.NaucnaCentrala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UddUpp.NaucnaCentrala.model.Author;
import UddUpp.NaucnaCentrala.model.User;
import UddUpp.NaucnaCentrala.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author create(User user){
		Author author = new Author();
		author.setFirst_name(user.getFirst_name());
		author.setLast_name(user.getLast_name());
		author.setEmail(user.getEmail());
		author.setCountry(user.getCountry());
		author.setCity(user.getCity());
		author.setPassword("govno123");
		return authorRepository.save(author);
	}

	public Author findByEmail(String email) {
		// TODO Auto-generated method stub
		return authorRepository.findByEmail(email);
	}
}
