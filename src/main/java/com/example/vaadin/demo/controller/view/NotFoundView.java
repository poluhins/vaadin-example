package com.example.vaadin.demo.controller.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.NativeLabel;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import lombok.val;

@Route("/404")
public class NotFoundView extends VerticalLayout {

    public NotFoundView() {
        val nothingLabel = new NativeLabel("404: THAT MEANS NOTHING HERE");
        add(nothingLabel);

        val goBackButton = new Button("Go back to users list", e -> getUI().orElseThrow(RuntimeException::new)
                .getPage()
                .getHistory()
                .back());

        add(goBackButton);
    }

}
