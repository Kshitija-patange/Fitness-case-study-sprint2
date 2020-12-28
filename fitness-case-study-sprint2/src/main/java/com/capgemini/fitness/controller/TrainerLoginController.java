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
 * Trainer Login Controller
 */

@RestController
@RequestMapping("/fitness/login")
@Api(value = "Trainer")
public class TrainerLoginController {
	@Autowired 
	private LoginService loginService;

	/*
	 * http://localhost:8082/springfox/fitness/login/trainerlogin/
	 */
	@PostMapping("/trainerlogin/") 
	@ApiOperation(value = "SignIn")
	public ResponseEntity<?> signIn( @RequestBody Login trainer) {
		String str = loginService.signIn(trainer);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	/*
	 * http://localhost:8082/springfox/fitness/login/trainerlogout/
	 */
	@PostMapping("/trainerlogout/") 
	@ApiOperation(value = "SignOut")
	public ResponseEntity<?> signOut( @RequestBody LogOutPayload trainer) {
		String str = loginService.signOut(trainer);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}

	@PostMapping("/trainerreset/")
	@ApiOperation(value = "Reset Password")
	public ResponseEntity<?> changePassword( @RequestBody Login trainer, String new_password) {
		String str =loginService.changePassword(trainer, new_password);
		BaseResponse baseResponse = new BaseResponse();
		baseResponse.setStatusCode(1);
		baseResponse.setResponse(str);
		return new ResponseEntity<>(baseResponse, HttpStatus.OK);
	}
}
