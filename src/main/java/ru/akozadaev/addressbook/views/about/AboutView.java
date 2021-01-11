package ru.akozadaev.addressbook.views.about;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import ru.akozadaev.addressbook.data.service.GetMyIP;
import ru.akozadaev.addressbook.views.main.StartView;

@Route(value = "about", layout = StartView.class)
@PageTitle("About")
public class AboutView extends Div {

    public AboutView() {
        setId("about-view");
        add(new Label("Мой IP: " + GetMyIP.getIP()));
        add(new Text("IP-адрес используется для идентификации Вашей организаци\n"));
    }

}
