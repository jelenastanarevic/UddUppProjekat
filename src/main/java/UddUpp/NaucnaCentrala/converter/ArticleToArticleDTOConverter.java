package UddUpp.NaucnaCentrala.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import UddUpp.NaucnaCentrala.DTO.ArticleDTO;
import UddUpp.NaucnaCentrala.model.Article;



@Component
public class ArticleToArticleDTOConverter implements Converter<Article, ArticleDTO>{

	@Override
	public ArticleDTO convert(Article source) {
		if(source == null){
			return null;
		}
		
		ArticleDTO articleDTO = new ArticleDTO();
		articleDTO.setAbstract_description(source.getAbstract_description());
		articleDTO.setKeyWords(source.getKeyWords());
		articleDTO.setTitle(source.getTitle());
		articleDTO.setId_magazine(source.getMagazine().getId());
		
		if(source.getScientific_field()!=null){
			articleDTO.setScientific_field_name(source.getScientific_field().getScientific_field_name());
			articleDTO.setScientific_field_id(source.getScientific_field().getScientific_field_id().toString());
			
		}
		
		return articleDTO;
	}
	
	public List<ArticleDTO> convert(List<Article> source) {
		List<ArticleDTO> ret = new ArrayList<ArticleDTO>();
		for(Article article : source) {
			ret.add(convert(article));
		}
		return ret;
	}

}
