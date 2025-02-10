package org.acme.adapters;

import org.acme.integration.UserInfo;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/user")
public class UserInfoProducer {

	@Channel("userinfo")
	Emitter<UserInfo> emitter;

	@POST
	public Response generateUserInfo() {
		System.out.println("Sending user info to Kafka");
		UserInfo userInfo = UserInfo.newBuilder().setUsername("John McLane").build();
		emitter.send(userInfo);
		return Response.accepted().build();
	}

}
