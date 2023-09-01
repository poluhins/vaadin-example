package com.example.vaadin.demo.controller.view;

import com.example.vaadin.demo.repository.UserRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.val;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Component
@Route("/user")
@Scope(SCOPE_PROTOTYPE)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserView extends VerticalLayout implements HasUrlParameter<Integer> {

    UserRepository repository;

    @Override
    public void setParameter(BeforeEvent beforeEvent, Integer id) {
        val userAcc = repository.findById(id)
                .orElse(null);
        if (userAcc == null) {
            getUI().orElseThrow(RuntimeException::new)
                    .getPage()
                    .setLocation("/404");
            return;
        }

        val idLabel = new NativeLabel("Id: " + userAcc.getId());
        val nameLabel = new NativeLabel("Name: " + userAcc.getName());
        val lastNameLabel = new NativeLabel("Last Name: " + userAcc.getLastName());
        val userHasAvatarLabel = new NativeLabel("Avatar: " + userAcc.getAvatarLink().isEmpty());

        add(idLabel, nameLabel, lastNameLabel, userHasAvatarLabel);

        val goBackButton = new Button("Go back to users list", e -> getUI().orElseThrow(RuntimeException::new)
                .getPage()
                .getHistory()
                .back());

        add(goBackButton);
    }
}
