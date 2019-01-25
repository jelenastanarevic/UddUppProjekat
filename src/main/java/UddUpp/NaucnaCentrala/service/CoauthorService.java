package UddUpp.NaucnaCentrala.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UddUpp.NaucnaCentrala.DTO.AuthorDTO;
import UddUpp.NaucnaCentrala.converter.ListOfFormFieldsToUserConverter;
import UddUpp.NaucnaCentrala.model.Article;
import UddUpp.NaucnaCentrala.model.Author;
import UddUpp.NaucnaCentrala.model.Coauthor;
import UddUpp.NaucnaCentrala.repository.CoauthorRepository;

@Service
public class CoauthorService {
	
	@Autowired
	private CoauthorRepository coauthorRepository;
	
	@Autowired
	private ListOfFormFieldsToUserConverter authorConverter;

	public Coauthor create(Author author, Article currentArticle) {
		
		Coauthor coauthor = new Coauthor(author,currentArticle);
		coauthor.setArticle(currentArticle);
		return coauthorRepository.save(coauthor);
	}

	public List<Coauthor> findByArticleId(Long id) {
		
		 return coauthorRepository.findByArticleId(id);
	}

	public List<AuthorDTO> convertToAuthors(List<Coauthor> ret) {
		List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
		for(Coauthor coauthor : ret){
			
		}
		return null;
	}

	
	

}
