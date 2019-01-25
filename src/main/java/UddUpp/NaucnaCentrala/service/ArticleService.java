package UddUpp.NaucnaCentrala.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UddUpp.NaucnaCentrala.model.Article;
import UddUpp.NaucnaCentrala.model.ScientificField;
import UddUpp.NaucnaCentrala.repository.ArticleRepository;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	public Article save(Article createdArticle) {
		// TODO Auto-generated method stub
		return articleRepository.save(createdArticle);
	}

	public Optional<Article> findOne(Long articleId) {
		// TODO Auto-generated method stub
		return articleRepository.findById(articleId);
	}

	public void addField(Article orElse, ScientificField found) {
		orElse.setScientific_field(found);
		articleRepository.save(orElse);
		
	}

	public Article updateFields(Article createdArticle, Optional<Article> found) {
		// createdArticle - source, found-destination
		Article foundArt = found.orElse(null);
		foundArt.setAbstract_description(createdArticle.getAbstract_description());
		foundArt.setKeyWords(createdArticle.getKeyWords());
		foundArt.setTitle(createdArticle.getTitle());
		return foundArt;
	}

	public void removeField(Article orElse) {
		orElse.setScientific_field(null);
		articleRepository.save(orElse);
		
	}
	

}
