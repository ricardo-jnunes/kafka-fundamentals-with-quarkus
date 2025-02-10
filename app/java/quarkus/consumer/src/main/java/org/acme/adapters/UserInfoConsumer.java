package org.acme.adapters;

import org.acme.integration.UserInfo;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.reactive.RestStreamElementType;

import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/consumed-users")
public class UserInfoConsumer {

	@Channel("users-from-kafka")
	Multi<UserInfo> userInfos;

	@GET
	@Produces(MediaType.SERVER_SENT_EVENTS)
	@RestStreamElementType(MediaType.TEXT_PLAIN)
	public Multi<String> stream() {
		return userInfos.map(user -> String.format("'%s' from %s", user.getUsername(), user.getAge()));
	}

}
