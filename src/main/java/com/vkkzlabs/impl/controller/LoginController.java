package com.vkkzlabs.impl.controller;

import com.vkkzlabs.api.entity.MyUser;
import com.vkkzlabs.api.entity.MyUserCredentials;
import com.vkkzlabs.api.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

/**Возвращает юзверя по его логину.
 * **/

@Controller
public class LoginController {
    @Autowired
    private UserCredentialsService userCredentialsService;

    /**
     * по запросу /GetUser и полю логина юзера возвращает объект пользователь
     */

    @RequestMapping(value = "GetUser", method = RequestMethod.POST)
    public ResponseEntity<MyUser> getUserByLogin(@RequestBody MyUserCredentials userCredentials, UriComponentsBuilder ucBuilder) {

        MyUser myUser = userCredentialsService.getUserByLogin(userCredentials.getUserLogin()).getMyUser();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");
        responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        if (myUser != null) {
            return new ResponseEntity<MyUser>(myUser,responseHeaders , HttpStatus.OK);
        } return new ResponseEntity<MyUser>(responseHeaders, HttpStatus.NOT_FOUND);
    }
}
