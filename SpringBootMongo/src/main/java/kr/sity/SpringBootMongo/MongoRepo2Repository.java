package kr.sity.SpringBootMongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoRepo2Repository extends MongoRepository<MongoRepoDoc, String>{
	public List<MongoRepoDoc> findByTitle(String title);
}
