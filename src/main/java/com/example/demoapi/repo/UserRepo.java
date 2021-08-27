package com.example.demoapi.repo;

import com.example.demoapi.model.Hobby;
import com.example.demoapi.model.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepo {

    private final List<User> users = List.of(
            new User(1,
                    "Guitar",
                    new BigDecimal("10.00"),
                    List.of(
                            new Hobby("Watching Youtube", false),
                            new Hobby("Playing Games", false)
                    ),
                    List.of("Ramen", "Sushi", "Pizza", "Bubble Tea"),
                    "{\"field1\": \"test1\"}"),
            new User(2,
                    "Man",
                    new BigDecimal("15.50"),
                    List.of(
                            new Hobby("Running", true),
                            new Hobby("Playing Games", false)
                    ),
                    List.of("Salad"),
                    "{\"field1\": null}"),
            new User(3,
                    "Bright",
                    new BigDecimal("12.34"),
                    List.of(),
                    List.of(),
                    "{}"),
            new User(4,
                    null,
                    null,
                    null,
                    null,
                    null)
    );

    public Optional<User> findById(int id) {
        return users.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }
}
