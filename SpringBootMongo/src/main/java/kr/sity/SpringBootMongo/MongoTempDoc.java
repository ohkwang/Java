package kr.sity.SpringBootMongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("TestCollection")
@Getter
@Setter
public class MongoTempDoc {
	
	@Id
	private String _id;
	
	private String title;
	
	private String content;

}
