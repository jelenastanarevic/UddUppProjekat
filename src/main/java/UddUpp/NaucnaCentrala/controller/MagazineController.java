package UddUpp.NaucnaCentrala.controller;

import java.util.List;

import org.camunda.bpm.engine.FormService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import UddUpp.NaucnaCentrala.DTO.MagazineDTO;
import UddUpp.NaucnaCentrala.converter.MagazineToMagazineDTOConverter;
import UddUpp.NaucnaCentrala.model.Magazine;
import UddUpp.NaucnaCentrala.service.MagazineService;

@Controller
@RequestMapping("/naucna_centrala")
public class MagazineController {
	
	@Autowired
	private MagazineService magazineService;
	
	@Autowired
	private MagazineToMagazineDTOConverter magazineConverter;
	
	@CrossOrigin
	@RequestMapping(
			value = "/getMagazines",
			method = RequestMethod.GET
	)
	public ResponseEntity<?> getMagazines() {
		//metoda za pocetnu stranu sa listom svih NC
		List<Magazine> allMagazines = magazineService.findAll();
		List<MagazineDTO> allMagazinesDTO = magazineConverter.convert(allMagazines);
		return new ResponseEntity<>(allMagazinesDTO,HttpStatus.OK);
	}

}
