package studentservice.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studentservice.api.shared.StudentDto;
import studentservice.data.StudentsRepository;
import studentservice.service.StudentService;
import studentservice.service.StudentServiceImpl;
import studentservice.ui.model.CreateStudentRequestModel;

@RestController
@RequestMapping("/students")
public class StudentServiceContoller {
	@Autowired
	private Environment env;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/status/check")
	public String status() {
		return "working on port "+env.getProperty("local.server.port");
	}

	@PostMapping
	public String createStudent(@Valid @RequestBody CreateStudentRequestModel studentDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		StudentDto studentDto = modelMapper.map(studentDetails, StudentDto.class);
		studentService.createUser(studentDto);
		
		return "Create user method is called";
	}

}
