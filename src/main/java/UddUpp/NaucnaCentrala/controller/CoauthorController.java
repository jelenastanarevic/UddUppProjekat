package UddUpp.NaucnaCentrala.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import UddUpp.NaucnaCentrala.DTO.ArticleDTO;
import UddUpp.NaucnaCentrala.DTO.AuthorDTO;
import UddUpp.NaucnaCentrala.model.Article;
import UddUpp.NaucnaCentrala.model.Coauthor;
import UddUpp.NaucnaCentrala.service.ArticleService;
import UddUpp.NaucnaCentrala.service.CoauthorService;

@Controller
@RequestMapping("/coauthor")
public class CoauthorController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FormService formService;
	
	@Autowired
	private CoauthorService coauthorService;
	
	@Autowired
	private ArticleService articleService;
	
	
	
	@CrossOrigin
	@RequestMapping(
			value = "/getCoauthorsForArticle/{PID}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getCurrent(@PathVariable String PID) {
		String id_article = (String) runtimeService.getVariable(PID, "articleId");
		
		
		if(id_article == null){
			return new ResponseEntity<>(new ArticleDTO(),HttpStatus.OK);
		}else{
			Task task = taskService.createTaskQuery().processInstanceId(PID).list().get(0);
			System.out.println(task.getName());
			
			Optional<Article> optArticle= articleService.findOne(Long.parseLong(id_article));
			Article found = optArticle.orElseGet(null);
			List<Coauthor> ret = coauthorService.findByArticleId(found.getId());
			
			List<AuthorDTO> coauthorsForArticle = coauthorService.convertToAuthors(ret);
			
			if(coauthorsForArticle != null){
				return new ResponseEntity<>(coauthorsForArticle,HttpStatus.OK);
			}else{
				return new ResponseEntity<>(new ArrayList<AuthorDTO>(),HttpStatus.OK);
			}
		}
	}

}
