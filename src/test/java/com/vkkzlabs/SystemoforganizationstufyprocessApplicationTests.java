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
	@Autowired private GroupTimetableService groupTimetableService;
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
	@Autowired private UserAchievementService userAchievementService;
	@Autowired private UserSettingsService userSettingsService;
	@Autowired private AchievementService achievementService;

	@Test
	public void fullDB(){
		UserType userType = new UserType();
		userType.setNameUserType("NameUserType");
		userTypeService.saveUserType(userType);

		TypeOfWork typeOfWork = new TypeOfWork();
		typeOfWork.setNameTypeOfWOrk("TypeOfWork");
		typeOfWorkService.saveTypeOfWork(typeOfWork);

		TypeOfQuestion typeOfQuestion = new TypeOfQuestion();
		typeOfQuestion.setNameQuestionType("TypeOfQuestion");
		typeOfQuestionService.saveTypeOfQuestion(typeOfQuestion);

		TypeOfAttorney typeOfAttorney = new TypeOfAttorney();
		typeOfAttorney.setNameOfTypeAttorney("TypeOfAttorney");
		typeOfAttorneyService.saveTypeOfAttorney(typeOfAttorney);

		TypeOfAnswer typeOfAnswer = new TypeOfAnswer();
		typeOfAnswer.setNameTypeOfAnswer("TypeOfAnswer");
		typeOfAnswerService.saveTypeOfAnswer(typeOfAnswer);

		TypeOfAcceptWork typeOfAcceptWork = new TypeOfAcceptWork();
		typeOfAcceptWork.setNameOfAccaptWork("TypeOfAcceptWork");
		typeOfAcceptWorkService.saveTypeOfAcceptWork(typeOfAcceptWork);

		TypeInClass typeInClass = new TypeInClass();
		typeInClass.setNameTypeInClass("TypeInClass");
		typeInClassService.saveTypeInClass(typeInClass);

		Subject subject = new Subject();
		subject.setNameSubject("Subject");
		subjectService.saveSubject(subject);

		MyUser myUser = new MyUser();
		myUser.setUserName("Name");
		myUser.setUserPatronymic("Seccondname");
		myUser.setUserSurname("Surname");
		myUser.setUserType(userType);
		userService.saveUser(myUser);

		MyUserCredentials myUserCredentials = new MyUserCredentials("login", "e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a");
		myUserCredentials.setMyUser(myUser);
		myUserCredentials.setUserLogin("Login");
		myUserCredentials.setUserPassword("e7cf3ef4f17c3999a94f2c6f612e8a888e5b1026878e4e19398b23bd38ec221a"); //Password
		userCredentialsService.saveUserCredentials(myUserCredentials);
	}

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
