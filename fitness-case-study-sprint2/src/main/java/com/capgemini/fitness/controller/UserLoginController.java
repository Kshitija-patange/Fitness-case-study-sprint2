package com.capgemini.fitness.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.fitness.entity.LogOutPayload;
import com.capgemini.fitness.entity.Login;
import com.capgemini.fitness.exception.BaseResponse;
import com.capgemini.fitness.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * User Login Controller
 */
@RestController
@RequestMapping("/fitness/login")
@Api(value = "User")
public class UserLoginController {
	@Autowired 
	private LoginService loginService;

	/*
	 * http://localhost:8082/springfox/fitness/login/userlogin/
	 */
	@PostMapping("/userlogin/") 
	@ApiOperation(value = "SignIn")
	public ResponseEntity<?> signIn( @RequestBody Login user) {
		String str = loginService.signIn(user);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	/*
	 *    http://localhost:8082/springfox/fitness/login/userlogout/
	 */
	@PostMapping("/userlogout/") 
	@ApiOperation(value = "SignOut")
	public ResponseEntity<?> signOut( @RequestBody LogOutPayload user) {
		String str = loginService.signOut(user);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@PostMapping("/userreset/")
	@ApiOperation(value = "Reset Password")
	public ResponseEntity<?> changePassword( @RequestBody Login user, String new_password) {
		String str =loginService.changePassword(user, new_password);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

}