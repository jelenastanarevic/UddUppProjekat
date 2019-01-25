package UddUpp.NaucnaCentrala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UddUpp.NaucnaCentrala.model.Magazine;
import UddUpp.NaucnaCentrala.repository.MagazineRepository;

@Service
public class MagazineService {
	
	@Autowired
	private MagazineRepository magazineRepository;

	public List<Magazine> findAll() {
		return magazineRepository.findAll();
	}

	public Magazine findOne(Long l) {
		// TODO Auto-generated method stub
		return magazineRepository.getOne(l);
	}
	
	

}
