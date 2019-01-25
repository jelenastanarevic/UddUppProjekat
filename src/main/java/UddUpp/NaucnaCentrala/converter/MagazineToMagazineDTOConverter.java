package UddUpp.NaucnaCentrala.converter;

import java.util.ArrayList;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import UddUpp.NaucnaCentrala.DTO.MagazineDTO;
import UddUpp.NaucnaCentrala.model.Magazine;


@Component
public class MagazineToMagazineDTOConverter implements Converter<Magazine, MagazineDTO> {

	@Override
	public MagazineDTO convert(Magazine source) {
		if(source == null){
			return null;
		}
		
		MagazineDTO magazineDTO = new MagazineDTO();
		magazineDTO.setId(source.getId());
		magazineDTO.setIssn(source.getIssn());
		magazineDTO.setTitle(source.getTitle());
		
		return magazineDTO;
		
	}
	
	public List<MagazineDTO> convert(List<Magazine> source) {
		List<MagazineDTO> ret = new ArrayList<MagazineDTO>();
		for(Magazine grad : source) {
			ret.add(convert(grad));
		}
		return ret;
	}

}
