package kr.sity.SpringBootMongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoRepo2Controller {
	@Autowired
	private MongoRepo2Repository mongoRepo2Repository;
	
	/* 
	@Autowired
	public void setMongoRepoRepository(MongoRepoRepository mongoRepoRepository) {
		this.mongoRepoRepository = mongoRepoRepository;
	}
	*/
	
	@GetMapping(value = "/listData2/{title}")
	public String listData2(@PathVariable String title) {
		List<MongoRepoDoc> mongoRepo2 = mongoRepo2Repository.findByTitle(title);
		System.out.println("out: "+mongoRepo2);
		System.out.println("Content: "+mongoRepo2.get(0).getContent());
		return mongoRepo2.get(0).getTitle();
	}

}
