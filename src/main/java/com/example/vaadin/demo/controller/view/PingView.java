package com.example.vaadin.demo.controller.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import lombok.val;
import org.springframework.stereotype.Component;

@Route("/ping")
@Component
public class PingView extends VerticalLayout {

    @PostConstruct
    public void render() {
        val pingButton = new Button("Ping", e -> showNotify());
        add(pingButton);
    }

    private void showNotify() {
        Notification.show("Pong!");
    }

}
