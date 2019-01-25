package UddUpp.NaucnaCentrala.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import UddUpp.NaucnaCentrala.DTO.ArticleDTO;
import UddUpp.NaucnaCentrala.DTO.FieldIdNamePairDto;
import UddUpp.NaucnaCentrala.converter.ArticleToArticleDTOConverter;
import UddUpp.NaucnaCentrala.converter.ListOfFormFieldsToArticleConverter;
import UddUpp.NaucnaCentrala.converter.ListOfFormFieldsToUserConverter;
import UddUpp.NaucnaCentrala.model.Article;
import UddUpp.NaucnaCentrala.model.Author;
import UddUpp.NaucnaCentrala.model.Coauthor;
import UddUpp.NaucnaCentrala.model.User;
import UddUpp.NaucnaCentrala.service.ArticleService;
import UddUpp.NaucnaCentrala.service.AuthorService;
import UddUpp.NaucnaCentrala.service.CoauthorService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private FormService formService;
	
	
	@Autowired
	private ArticleService articleService;

	
	@Autowired
	private ArticleToArticleDTOConverter articleToArticleDTOConverter;
	
	
	
	@CrossOrigin
	@RequestMapping(
			value = "/getCurrent/{PID}",
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
			ArticleDTO ret = articleToArticleDTOConverter.convert(found);
			ret.setIdTask(task.getId());
			return new ResponseEntity<>(ret,HttpStatus.OK);
		}
	}
	
	
	@CrossOrigin
	@RequestMapping(
			value = "/addArticleForm/{PID}/{idMagazine}",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> addArticleForm(@PathVariable String PID, @PathVariable String idMagazine) {
		//metoda za pocetnu stranu sa listom svih NC
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", Long.parseLong(idMagazine));
		
		Task task = taskService.createTaskQuery().processInstanceId(PID).list().get(0);
		System.out.println(task.getName());
		formService.submitTaskForm(task.getId(), map);
        
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/createArticle/{taskId}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> createArticle(@RequestBody List<FieldIdNamePairDto> dto, @PathVariable String taskId) {
		Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		for(FieldIdNamePairDto pair:dto){
		map.put(pair.getFieldId(), pair.getFieldValue());
		}
		
		System.out.println(task.getName());
		runtimeService.setVariable(task.getProcessInstanceId(), "articleDTO", dto);
		formService.submitTaskForm(task.getId(), map);
		return new ResponseEntity<>(HttpStatus.OK);
		
		
	}
	
	@CrossOrigin
	@RequestMapping(
			value = "/addCoauthor/{PID}",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> addCoauthor(@RequestBody List<FieldIdNamePairDto> dto, @PathVariable String PID) {
				
		HashMap<String, Object> map = new HashMap<String, Object>();
		for(FieldIdNamePairDto pair:dto){
		map.put(pair.getFieldId(), pair.getFieldValue());
		}
		
		runtimeService.setVariable(PID, "coauthorInfo", dto);
		Task task = taskService.createTaskQuery().processInstanceId(PID).list().get(0);
		System.out.println(task.getName());
		
			formService.submitTaskForm(task.getId(), map);
			return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	

}
