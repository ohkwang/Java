package kr.sity.SpringBootMongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepoRepository extends MongoRepository<MongoRepoDoc, String>{

}
