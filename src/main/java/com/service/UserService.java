package com.service;

import com.proto.users.UserGrpc.UserImplBase;
import com.proto.users.UserOuterClass.LoginRequest;
import com.proto.users.UserOuterClass.LoginResponse;

import io.grpc.stub.StreamObserver;

public class UserService extends UserImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
		String uname=request.getUsername();
		String passwd=request.getPassword();
		
		LoginResponse.Builder loginRespBuilder=LoginResponse.newBuilder();
		loginRespBuilder.setCode("200").setMessage("Great ! You are logged in.").build();
	
		responseObserver.onNext(loginRespBuilder.build()); //attach the builder for response
		responseObserver.onCompleted(); //close the call
	}

}
