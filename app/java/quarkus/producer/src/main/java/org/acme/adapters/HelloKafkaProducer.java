package org.acme.adapters;

import io.smallrye.mutiny.Multi;
import java.util.Random;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import jakarta.enterprise.context.ApplicationScoped;
import java.time.Duration;

@ApplicationScoped
public class HelloKafkaProducer {

    private final Random random = new Random();

    @Outgoing("hello-out")
    public Multi<String> generate() {
        // Build an infinite stream of random strings
        // It emits a hello string every second
    	System.out.println("Starting produce messages");
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
            .map(x -> "Hello " + random.nextInt());
    }
}
