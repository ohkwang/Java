package kr.sity.SpringBootInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class TestController {

	private final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping("/mypage")
	@ResponseBody
	public String mypage() {
		
		logger.info("test Data");;
		return "{test:mypage}";
	}
	
	@GetMapping("/login")
	@ResponseBody
	public String login() {
		
		logger.info("login Data");;
		return "{test:login}";
	}
}
