package com.vkkzlabs;

import com.vkkzlabs.dao.UserTypeDAO;
import com.vkkzlabs.entity.*;
import com.vkkzlabs.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemoforganizationstufyprocessApplicationTests {


	@Autowired private AttorneyService attorneyService;
	@Autowired private CommentToStudentService commentToStudentService;
	@Autowired private CommentToWorkService commentToWorkService;
	@Autowired private AnswerService answerService;
	@Autowired private InClassService inClassService;
	@Autowired private GroupTimeTableService groupTimeTableService;
	@Autowired private ProfessorSubjectService professorSubjectService;
	@Autowired private StudentWorkService studentWorkService;
	@Autowired private QuestionWorkService questionWorkService;
	@Autowired private UserService userService;
	@Autowired private UserCredentialsService userCredentialsService;
	@Autowired private QuestionService questionService;
	@Autowired private QueueService queueService;
	@Autowired private StudentGroupService studentGroupService;
	@Autowired private SubjectService subjectService;
	@Autowired private TimetableService timetableService;
	@Autowired private TopicsService topicsService;
	@Autowired private TypeInClassService typeInClassService;
	@Autowired private TypeOfAcceptWorkService typeOfAcceptWorkService;
	@Autowired private TypeOfAnswerService typeOfAnswerService;
	@Autowired private TypeOfAttorneyService typeOfAttorneyService;
	@Autowired private TypeOfQuestionService typeOfQuestionService;
	@Autowired private TypeOfWorkService typeOfWorkService;
	@Autowired private WorkService workService;
	@Autowired private UserTypeService userTypeService;


	@Test
	public void saveTypeOfWork(){
		TypeOfWork typeOfWork = new TypeOfWork();
		typeOfWork.setNameTypeOfWOrk("ff");
		typeOfWorkService.saveTypeOfWork(typeOfWork);
	}

	@Test
	public void contextLoads() {
		UserType userType = new UserType();
		userType = userTypeService.getUserTypeByID(1);
		System.out.print(userType);
	}

	@Test
	public void getAnswer(){
		Answer answer = answerService.getAnswerByIdAnswer(1);
	System.out.print(answerService.getAnswerByIdAnswer(1));
	}

}
