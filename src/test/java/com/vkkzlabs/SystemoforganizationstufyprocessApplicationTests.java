package com.vkkzlabs;

import com.vkkzlabs.dao.UserTypeDAO;
import com.vkkzlabs.entity.Answer;
import com.vkkzlabs.entity.UserType;
import com.vkkzlabs.service.AnswerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SystemoforganizationstufyprocessApplicationTests {
	@Autowired
	UserTypeDAO userTypeDAO;

	@Autowired
	AnswerService answerService;

	@Test
	public void contextLoads() {
		UserType userType = new UserType();
		userType = userTypeDAO.findByIdUserType(1);
		System.out.print(userType);
	}

	@Test
	public void getAnswer(){
		Answer answer = answerService.getAnswerByIdAnswer(1);
	System.out.print(answerService.getAnswerByIdAnswer(1));
	}

}
