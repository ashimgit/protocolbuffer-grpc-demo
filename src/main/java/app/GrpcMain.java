package app;

import java.io.IOException;

import com.service.UserService;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcMain {

	public static void main(String[] args) throws InterruptedException, IOException {
		Server server=ServerBuilder.forPort(12345).addService(new UserService()).build();
		
		server.start();
		System.out.println("Server started at port ="+server.getPort());
		
		server.awaitTermination();
		System.out.println("Server Stopped at port ="+server.getPort());
		
	}

}
