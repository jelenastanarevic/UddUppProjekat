package UddUpp.NaucnaCentrala.service;

import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UddUpp.NaucnaCentrala.DTO.FieldIdNamePairDto;
import UddUpp.NaucnaCentrala.DTO.LoginFormSubmissionDto;
import UddUpp.NaucnaCentrala.model.User;
import UddUpp.NaucnaCentrala.repository.UserRepository;

@Service
public class UserLoginTaskService implements JavaDelegate{

	@Autowired
	private UserService userService;
	
	
	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		List<FieldIdNamePairDto> dto = (List<FieldIdNamePairDto>) execution.getVariable("loginData");
		User user = null;
		for(FieldIdNamePairDto field : dto){
			if(field.getFieldId().equals("email")){
				user = userService.findByEmail(field.getFieldValue());
			}
				
		}
			if(user == null){
					execution.setVariable("userExists", false);
					
				}else{
					userService.setCurrentUser(user);
					execution.setVariable("userExists", true);
					execution.setVariable("userLoggedIn", user);
				}
				
				
			
		
		
	}

}
