package com.example.vaadin.demo.controller.view;

import com.example.vaadin.demo.repository.UserRepository;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@Route("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserListView extends VerticalLayout {

    UserRepository repository;

    @PostConstruct
    public void render() {
        val label = new NativeLabel("Total users in the storage: " + repository.count());
        val userIterator = repository.findAll()
                .iterator();

        add(label);

        while (userIterator.hasNext()) {
            val user = userIterator.next();
            val text = "User id: " + user.getId();
            val userAccButton = new Button(text, e -> getUI().orElseThrow(RuntimeException::new)
                    .getPage()
                    .open("/user/" + user.getId()));
//                    .setLocation();
            add(userAccButton);
        }
    }

}
