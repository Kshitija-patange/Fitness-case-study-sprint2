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
 * Admin Login Controller
 */

@RestController
@RequestMapping("/fitness/login")
@Api(value = "Admin")
public class AdminLoginController {
	@Autowired 
	private LoginService loginService;

	/*
	 * http://localhost:8082/springfox/fitness/login/adminlogin/
	 */
	@PostMapping("/adminlogin/") 
	@ApiOperation(value = "SignIn")
	public ResponseEntity<?> signIn( @RequestBody Login admin) {
		String str = loginService.signIn(admin);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	/*
	 *  http://localhost:8082/springfox/fitness/login/adminlogout/
	 */
	@PostMapping("/adminlogout/") 
	@ApiOperation(value = "SignOut")
	public ResponseEntity<?> signOut( @RequestBody LogOutPayload admin) {
		String str = loginService.signOut(admin);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@PostMapping("/adminreset/")
	@ApiOperation(value = "Reset Password")
	public ResponseEntity<?> changePassword( @RequestBody Login admin, String new_password) {
		String str =loginService.changePassword(admin, new_password);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}	
}
