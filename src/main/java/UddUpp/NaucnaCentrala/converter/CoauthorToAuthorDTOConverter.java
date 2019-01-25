package UddUpp.NaucnaCentrala.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import UddUpp.NaucnaCentrala.DTO.AuthorDTO;
import UddUpp.NaucnaCentrala.DTO.FieldIdNamePairDto;
import UddUpp.NaucnaCentrala.model.Article;
import UddUpp.NaucnaCentrala.model.Coauthor;

public class CoauthorToAuthorDTOConverter implements Converter<Coauthor, AuthorDTO>{

	@Override
	public AuthorDTO convert(Coauthor source) {
		
		if(source == null){
			return null;
		}
		
		AuthorDTO authorDTO = new AuthorDTO();
		
		authorDTO.setCity(source.getAuthor().getCity());
		authorDTO.setCountry(source.getAuthor().getCountry());
		authorDTO.setFirst_name(source.getAuthor().getFirst_name());
		authorDTO.setLast_name(source.getAuthor().getLast_name());
		authorDTO.setEmail(source.getAuthor().getEmail());
		authorDTO.setId(source.getAuthor().getId());
		
		return authorDTO;
	}
	
	public List<AuthorDTO> convertList(List<Coauthor> source) {
		List<AuthorDTO> ret = new ArrayList<AuthorDTO>();
		for(Coauthor co : source) {
			ret.add(convert(co));
		}
		return ret;
	}
	

}
