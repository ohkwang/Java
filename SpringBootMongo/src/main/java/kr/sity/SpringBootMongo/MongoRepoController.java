package kr.sity.SpringBootMongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoRepoController {
	@Autowired
	private MongoRepoRepository mongoRepoRepository;
	
	@GetMapping(value = "/listData/{title}")
	public String listData(@PathVariable String title) {
		List<MongoRepoDoc> aaaa = mongoRepoRepository.findAll();
        System.out.println("out: "+aaaa.get(1).getTitle());
        aaaa.forEach(System.out::println);
        return aaaa.toArray().toString();
	}

}
