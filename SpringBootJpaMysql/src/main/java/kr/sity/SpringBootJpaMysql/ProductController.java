package kr.sity.SpringBootJpaMysql;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/create")  
	public void create(Product product) {
	productRepository.save(product);
	}
	
	@GetMapping("/readOne")
	public Optional<Product> readOne(Long id) {
	return productRepository.findById(id);
	}

	@GetMapping("/readAll")
	public List<Product> readAll() {
	return productRepository.findAll();
	}

}
