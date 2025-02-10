package org.acme.adapters;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HelloKafkaConsumer {

    @Incoming("hello")
    public void consume(String message) {
        // process your price.
    	System.out.println("Consuming from hello topic: " + message);
    }

}
