package UddUpp.NaucnaCentrala.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import UddUpp.NaucnaCentrala.DTO.FieldIdNamePairDto;
import UddUpp.NaucnaCentrala.model.Article;
import UddUpp.NaucnaCentrala.model.Magazine;
import UddUpp.NaucnaCentrala.model.User;
import UddUpp.NaucnaCentrala.service.MagazineService;

@Component
public class ListOfFormFieldsToArticleConverter implements Converter<List<FieldIdNamePairDto>, Article>{

	@Autowired
	private MagazineService magazineService;
	
	@Override
	public Article convert(List<FieldIdNamePairDto> source) {
		if(source == null){
			return null;
		}
		Article article = new Article();
		for(FieldIdNamePairDto field : source){
			if(field.getFieldId().equals("title")){
				article.setTitle(field.getFieldValue());
			}
			if(field.getFieldId().equals("apstract")){
				article.setAbstract_description(field.getFieldValue());
			}
			if(field.getFieldId().equals("keywords")){
				article.setKeyWords(field.getFieldValue());
			}
			if(field.getFieldId().equals("id_magazine")){
				Magazine magazine = magazineService.findOne(Long.parseLong(field.getFieldValue()));
				article.setMagazine(magazine);
			}
			
		
		}
		return article;
	}
	
	public List<Article> convertList(List<List<FieldIdNamePairDto>> source) {
		List<Article> ret = new ArrayList<Article>();
		for(List<FieldIdNamePairDto> field : source) {
			ret.add(convert(field));
		}
		return ret;
	}

}
