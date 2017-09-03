package com.vkkzlabs;

import com.vkkzlabs.api.service.*;
import com.vkkzlabs.api.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemOfOrganizationStudyProcessApplicationTests {


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
	@Autowired private GenderService genderService;
	@Autowired private UniversityService universityService;
	@Autowired private ChairService chairService;
	@Autowired private FacultyService facultyService;

	@Test
	public void fullDB(){
		UserType userType = new UserType();
		userType.setNameUserType("Admin");
		userTypeService.saveUserType(userType);
		userType = new UserType();
		userType.setNameUserType("Professor");
		userTypeService.saveUserType(userType);
		userType = new UserType();
		userType.setNameUserType("Student");
		userTypeService.saveUserType(userType);

		Gender gender = new Gender();
		gender.setNameOfGender("Male");
		genderService.saveGender(gender);
		gender = new Gender();
		gender.setNameOfGender("Female");
		genderService.saveGender(gender);

		University university = new University();
		university.setNameUniversity("BSUIR");
		universityService.saveUniversity(university);

		Faculty faculty = new Faculty();
		faculty.setUniversity(university);
		faculty.setNameFaculty("FKSIS");
		facultyService.saveFaculty(faculty);

		Chair chair = new Chair();
		chair.setFaculty(faculty);
		chair.setNameChair("POIT");
		chairService.saveChair(chair);

		MyUser myUser = new MyUser();
		myUser.setUserName("Admin");
		myUser.setUserSurname("Admin");
		myUser.setUserPatronymic("Admin");
		myUser.setUserType(userTypeService.getUserTypeByID(1));
		Calendar calendar = Calendar.getInstance();
		myUser.setDateOfEnrollment(new Date(calendar.getTime().getTime()));
		myUser.setEmail("Admin@Mail.ru");
		myUser.setGender(gender);
		userService.saveUser(myUser);

		myUser = new MyUser();
		myUser.setUserName("Professor");
		myUser.setUserSurname("Professor");
		myUser.setUserPatronymic("Professor");
		myUser.setUserType(userTypeService.getUserTypeByID(2));
		myUser.setDateOfEnrollment(new Date(calendar.getTime().getTime()));
		myUser.setEmail("Professor@Mail.ru");
		myUser.setGender(gender);
		userService.saveUser(myUser);

		myUser = new MyUser();
		myUser.setUserName("Student");
		myUser.setUserSurname("Student");
		myUser.setUserPatronymic("Student");
		myUser.setUserType(userTypeService.getUserTypeByID(3));
		myUser.setDateOfEnrollment(new Date(calendar.getTime().getTime()));
		myUser.setEmail("Student@Mail.ru");
		myUser.setGender(gender);
		userService.saveUser(myUser);

		StudentGroup studentGroup = new StudentGroup();
		studentGroup.setChair(chair);
		studentGroup.setCourse(1);
		studentGroup.setIdMyUserStarosta(3);
		studentGroup.setNumberOfGroup("351002");
		studentGroupService.saveStudentGroup(studentGroup);

		myUser.setStudentGroup(studentGroup);
		userService.saveUser(myUser);

		MyUserCredentials myUserCredentials = new MyUserCredentials();
		myUserCredentials.setUserLogin("Admin");
		myUserCredentials.setUserPassword("c1c224b03cd9bc7b6a86d77f5dace40191766c485cd55dc48caf9ac873335d6f");
		myUserCredentials.setMyUser(userService.getUserById(1));
		userCredentialsService.saveUserCredentials(myUserCredentials);

		myUserCredentials = new MyUserCredentials();
		myUserCredentials.setUserLogin("Professor");
		myUserCredentials.setUserPassword("6511f4dadcda5bfb2b28869f8cf34d36866ce01a08c0f1eb432b8ea4fa70e75a");
		myUserCredentials.setMyUser(userService.getUserById(2));
		userCredentialsService.saveUserCredentials(myUserCredentials);

		myUserCredentials = new MyUserCredentials();
		myUserCredentials.setUserLogin("Student");
		myUserCredentials.setUserPassword("2a164d5415787b6e0e8d8d937c708a6f4c856e293022d24bde016e8549fb86b5");
		myUserCredentials.setMyUser(userService.getUserById(3));
		userCredentialsService.saveUserCredentials(myUserCredentials);


		UserSettings userSettings = new UserSettings();
		userSettings.setSittingInfo("PathToFiles");
		userSettingsService.saveUserSettings(userSettings);

		TypeOfWork typeOfWork = new TypeOfWork();
		typeOfWork.setNameTypeOfWOrk("Practical");
		typeOfWorkService.saveTypeOfWork(typeOfWork);

		Subject subject = new Subject();
		subject.setChair(chair);
		subject.setNameSubject("POVS");
		subjectService.saveSubject(subject);

		subject = new Subject();
		subject.setChair(chair);
		subject.setNameSubject("POTSP");
		subjectService.saveSubject(subject);

		Work work = new Work();
		work.setProfessorId(userService.getUserById(2));
		work.setNameOfWork("Masses");
		work.setNumberOfWOrk("2");
		work.setTextOfWork("Do work with masses");
		work.setTypeOfWork(typeOfWork);
		work.setSubject(subject);
		workService.saveWork(work);

		work = new Work();
		work.setProfessorId(userService.getUserById(2));
		work.setNameOfWork("Works");
		work.setNumberOfWOrk("1");
		work.setTextOfWork("Do sum work");
		work.setTypeOfWork(typeOfWork);
		work.setSubject(subjectService.getSubjectByIdSubject(1));
		workService.saveWork(work);

		work = new Work();
		work.setProfessorId(userService.getUserById(2));
		work.setNameOfWork("Works");
		work.setNumberOfWOrk("1");
		work.setTextOfWork("Do sum work");
		work.setTypeOfWork(typeOfWork);
		work.setSubject(subject);
		workService.saveWork(work);


		TypeOfAcceptWork typeOfAcceptWork = new TypeOfAcceptWork();
		typeOfAcceptWork.setNameOfAccaptWork("Not watched");
		typeOfAcceptWorkService.saveTypeOfAcceptWork(typeOfAcceptWork);

		typeOfAcceptWork = new TypeOfAcceptWork();
		typeOfAcceptWork.setNameOfAccaptWork("Watched");
		typeOfAcceptWorkService.saveTypeOfAcceptWork(typeOfAcceptWork);

		typeOfAcceptWork = new TypeOfAcceptWork();
		typeOfAcceptWork.setNameOfAccaptWork("Under construction");
		typeOfAcceptWorkService.saveTypeOfAcceptWork(typeOfAcceptWork);

		typeOfAcceptWork = new TypeOfAcceptWork();
		typeOfAcceptWork.setNameOfAccaptWork("In queue");
		typeOfAcceptWorkService.saveTypeOfAcceptWork(typeOfAcceptWork);

		typeOfAcceptWork = new TypeOfAcceptWork();
		typeOfAcceptWork.setNameOfAccaptWork("Accepted");
		typeOfAcceptWorkService.saveTypeOfAcceptWork(typeOfAcceptWork);

		M2MStudentWork m2MStudentWork = new M2MStudentWork();
		m2MStudentWork.setIdOfAccaptWork(typeOfAcceptWorkService.getTypeOfAcceptWorkByIdAcceptWork(1));
		m2MStudentWork.setIdOfWork(work);
		m2MStudentWork.setIdUser(userService.getUserById(3));
		m2MStudentWork.setMark(0);
		m2MStudentWork.setDeadlineForWork(new Date(calendar.getTime().getTime()));
		studentWorkService.saveStudentWork(m2MStudentWork);

		m2MStudentWork = new M2MStudentWork();
		m2MStudentWork.setIdOfAccaptWork(typeOfAcceptWorkService.getTypeOfAcceptWorkByIdAcceptWork(1));
		m2MStudentWork.setIdOfWork(workService.getWorkByIdWork(2));
		m2MStudentWork.setIdUser(userService.getUserById(3));
		m2MStudentWork.setMark(0);
		m2MStudentWork.setDeadlineForWork(new Date(calendar.getTime().getTime()));
		studentWorkService.saveStudentWork(m2MStudentWork);

		m2MStudentWork = new M2MStudentWork();
		m2MStudentWork.setIdOfAccaptWork(typeOfAcceptWorkService.getTypeOfAcceptWorkByIdAcceptWork(1));
		m2MStudentWork.setIdOfWork(workService.getWorkByIdWork(3));
		m2MStudentWork.setIdUser(userService.getUserById(3));
		m2MStudentWork.setMark(0);
		m2MStudentWork.setDeadlineForWork(new Date(calendar.getTime().getTime()));
		studentWorkService.saveStudentWork(m2MStudentWork);

		CommentToWork commentToWork = new CommentToWork();
		commentToWork.setDate(new Date(calendar.getTime().getTime()));
		commentToWork.setProfessor(userService.getUserById(2));
		commentToWork.setStudent(userService.getUserById(3));
		commentToWork.setWork(workService.getWorkByIdWork(1));
		commentToWork.setTextOfCommentWork("BadWork");
		commentToWorkService.saveCommentToWork(commentToWork);

		commentToWork = new CommentToWork();
		commentToWork.setDate(new Date(calendar.getTime().getTime()));
		commentToWork.setProfessor(userService.getUserById(2));
		commentToWork.setStudent(userService.getUserById(3));
		commentToWork.setWork(workService.getWorkByIdWork(1));
		commentToWork.setTextOfCommentWork("Wary bad work");
		commentToWorkService.saveCommentToWork(commentToWork);

		commentToWork = new CommentToWork();
		commentToWork.setDate(new Date(calendar.getTime().getTime()));
		commentToWork.setProfessor(userService.getUserById(2));
		commentToWork.setStudent(userService.getUserById(3));
		commentToWork.setWork(workService.getWorkByIdWork(2));
		commentToWork.setTextOfCommentWork("Wary bad work");
		commentToWorkService.saveCommentToWork(commentToWork);

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
