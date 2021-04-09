package kr.sity.SpringBootMongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoTempController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping(value = "/getData/{title}")
	public List<MongoTempDoc> getEventList(@PathVariable String title) {
		Query query = new Query().addCriteria(Criteria.where("title").is(title));
		System.out.println("query: "+query);
		
		return mongoTemplate.find(query, MongoTempDoc.class, "TestCollection");
	}
	
	@GetMapping("/insertData")
	public MongoTempDoc insertData() {
		MongoTempDoc MongoTempVO = new MongoTempDoc();
		MongoTempVO.setTitle("고길동");
		MongoTempVO.setContent("부처");
        
        return mongoTemplate.insert(MongoTempVO, "TestCollection");
	}
	
	@GetMapping("/updateData")
	public void updateData() throws Exception{
		Criteria criteria = new Criteria("title");
        criteria.is("고길동");

		Query query = new Query();
		query.addCriteria(criteria);
		
        Update update = new Update();
        update.set("content", "백수");
        
        try {
        	mongoTemplate.updateFirst(query, update, "TestCollection");
        } catch(Exception e) {
        	e.printStackTrace();
        }
	}
	
	@GetMapping("/updateData2")
	public boolean updateData2() throws Exception{
		Query query = new Query();
	    Update update = new Update();
		
	    query.addCriteria(Criteria.where("title").is("고길동"));
	    //query.addCriteria(Criteria.where("컬럼명2").is("조건값2"));

	    update.set("content", "변경값1");
	    //update.set("컬럼명2", "변경값2");
        
        try {
        	mongoTemplate.updateMulti(query, update, "TestCollection");
        	return true;
        } catch(Exception e) {
        	e.toString();
        	return false;
        }
	}
	
	
	@GetMapping("/updateData3")
	public int updateData3() throws Exception{
        try {
        	mongoTemplate.updateFirst(new Query(Criteria.where("title").is("고길동")),
    				Update.update("content", "4로 변경"), "TestCollection");
        	return 1;
        } catch(Exception e) {
        	e.printStackTrace();
        	return 0;
        }

	}

}
