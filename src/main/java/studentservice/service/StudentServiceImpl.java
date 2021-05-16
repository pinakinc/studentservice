package studentservice.service;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studentservice.api.shared.StudentDto;
import studentservice.data.StudentEntity;
import studentservice.data.StudentsRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	StudentsRepository studentsRepository;
	
	@Autowired
	public StudentServiceImpl(StudentsRepository studentsRepository) {
		this.studentsRepository=studentsRepository;
		
	}
	@Override
	public StudentDto createUser(StudentDto studentDetails) {
		studentDetails.setUserId(UUID.randomUUID().toString());
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		StudentEntity studentEntity = modelMapper.map(studentDetails, StudentEntity.class);
		studentEntity.setEncryptedPassword("test1");
		studentsRepository.save(studentEntity);
		return null;
	}

}
