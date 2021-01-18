package studentservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentServiceContoller {
	
	@GetMapping("/status/check")
	public String status() {
		return "working";
	}

}
