package UddUpp.NaucnaCentrala.DTO;


public class ArticleDTO {
	
	
    private String title;

    private String keyWords;

    private String abstract_description;
    
    private Long id_magazine;
    
    private String idTask;
    
    private String scientific_field_name;
    
    private String scientific_field_id;
    
    
    
    public ArticleDTO(){}

	public ArticleDTO(String title, String keyWords, String abstract_description, Long id_magazine) {
	
		this.title = title;
		this.keyWords = keyWords;
		this.abstract_description = abstract_description;
		this.id_magazine = id_magazine;
	}
	
	

	public Long getId_magazine() {
		return id_magazine;
	}

	public void setId_magazine(Long id_magazine) {
		this.id_magazine = id_magazine;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public String getAbstract_description() {
		return abstract_description;
	}

	public void setAbstract_description(String abstract_description) {
		this.abstract_description = abstract_description;
	}

	public String getIdTask() {
		return idTask;
	}

	public void setIdTask(String idTask) {
		this.idTask = idTask;
	}

	public String getScientific_field_name() {
		return scientific_field_name;
	}

	public void setScientific_field_name(String scientific_field_name) {
		this.scientific_field_name = scientific_field_name;
	}

	public String getScientific_field_id() {
		return scientific_field_id;
	}

	public void setScientific_field_id(String scientific_field_id) {
		this.scientific_field_id = scientific_field_id;
	}
	
	
    
    

}
