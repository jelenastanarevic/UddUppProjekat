package UddUpp.NaucnaCentrala.service;

import java.util.List;
import java.util.Optional;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UddUpp.NaucnaCentrala.DTO.FieldIdNamePairDto;
import UddUpp.NaucnaCentrala.converter.ListOfFormFieldsToUserConverter;
import UddUpp.NaucnaCentrala.model.Article;
import UddUpp.NaucnaCentrala.model.Author;
import UddUpp.NaucnaCentrala.model.Coauthor;
import UddUpp.NaucnaCentrala.model.User;

@Service
public class AddCoauthorTaskService implements JavaDelegate{

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private ListOfFormFieldsToUserConverter userConverter;
	
	@Autowired
	private CoauthorService coauthorService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		List<FieldIdNamePairDto> dto = (List<FieldIdNamePairDto>) execution.getVariable("coauthorInfo");
		
		Long articleId = Long.parseLong((String)execution.getVariable("articleId"));
		
		if(articleId !=null){
			Optional<Article> currentArticleOpt = articleService.findOne(articleId);
			Article currentArticle = currentArticleOpt.orElseGet(null);
			
			User user = userConverter.convert(dto);
			
			Author author = authorService.findByEmail(user.getEmail());
			
			if(author !=null){
				Coauthor coauthor = coauthorService.create(author,currentArticle);
			}else{
				Author created = authorService.create(user);
			}
		}
		for(FieldIdNamePairDto pair: dto){
			if(pair.getFieldId().equals("addMore")){
				execution.setVariable("addMore", pair.getFieldValue());
				break;
			}
		}

		
	}

}
