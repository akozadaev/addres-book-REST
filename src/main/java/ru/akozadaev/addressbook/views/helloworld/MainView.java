package ru.akozadaev.addressbook.views.helloworld;

import com.google.gson.Gson;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.annotation.Autowired;
import ru.akozadaev.addressbook.data.entity.DataPerson;
import ru.akozadaev.addressbook.data.entity.Errors;
import ru.akozadaev.addressbook.data.entity.Person;
import ru.akozadaev.addressbook.data.service.*;
import ru.akozadaev.addressbook.views.main.StartView;

@Route(value = "hello", layout = StartView.class)
@PageTitle("Адресная книга")
@CssImport("./styles/views/main/main-view.css")
@RouteAlias(value = "", layout = StartView.class)
public class MainView extends HorizontalLayout {

    private TextField txtFieldFind;
    private Button btnFind;
    private HorizontalLayout layout;
    private HorizontalLayout layoutGrid;
    @Autowired
    Person person;
    DataPerson persData;


    public MainView() {
        setId("main-view");
        setSizeFull();


        layout = new HorizontalLayout();
        layout.setSizeUndefined();
        layoutGrid = new HorizontalLayout();
        layoutGrid.setSizeUndefined();
        txtFieldFind = new TextField();
        txtFieldFind.setAutofocus(true);
        txtFieldFind.setPlaceholder("Строка для поиска");
        txtFieldFind.setClearButtonVisible(true);
        txtFieldFind.setWidthFull();
        txtFieldFind.setMaxWidth("900px");
        btnFind = new Button("Найти   ");
        btnFind.setWidth("50px");
        add(txtFieldFind, btnFind);

        add(layout);
        setVerticalComponentAlignment(Alignment.END, txtFieldFind, btnFind);
        btnFind.addClickListener(e -> {
            layoutGrid.removeAll();
            JsonParser clientAPI = new JsonParser();
            String tmpStr ;

            switch (txtFieldFind.getValue()) {
                case  ("res"):
                    tmpStr = GetPropirties.get().getProperty("res");
                    break;
                case ("err"):
                    tmpStr = GetPropirties.get().getProperty("err");;
                    break;

                default:
                    tmpStr = clientAPI.getJson(GetMyIP.getIP(), txtFieldFind.getValue());
                    break;
            }
            Gson g = new Gson();
            person = g.fromJson(tmpStr, Person.class);
            persData = g.fromJson(tmpStr, DataPerson.class);
            if (person.result.toLowerCase().equals("ok")) {
                Grid<DataPerson> grid = new Grid<>(DataPerson.class);
                grid.setColumns("name", "orgName", "orgDepDataFull", "personPost", "phoneCity", "phoneInternal", "eMail");
                grid.setHeight("100%");
                grid.getColumnByKey("name").setHeader("ФИО");
                grid.getColumnByKey("orgName").setHeader("Организация");
                grid.getColumnByKey("orgDepDataFull").setHeader("Подразделение");
                grid.getColumnByKey("personPost").setHeader("Должность");
                grid.getColumnByKey("phoneCity").setHeader("Тел. городской");
                grid.getColumnByKey("phoneInternal").setHeader("Тел. внутренний");


                grid.getColumnByKey("name").setAutoWidth(true);
                grid.getColumnByKey("orgName").setAutoWidth(true);
                grid.getColumnByKey("orgDepDataFull").setAutoWidth(true);
                grid.getColumnByKey("personPost").setAutoWidth(true);
                grid.getColumnByKey("phoneInternal").setAutoWidth(true);
                grid.getColumnByKey("phoneCity").setAutoWidth(true);

                layoutGrid.add(grid);
                add(layoutGrid);
                grid.setItems(person.data.dataPerson);
                grid.setSizeUndefined();
            } else
            {
                StringBuilder builder = new StringBuilder();
                for (Errors error : person.errors) {
                    builder.append(error.getTitle() + "\n");
                    builder.append(error.getDetail());
                }
                Dialog dialog = new Dialog();
                Button button = new Button("Закрыть");
                for (Errors error : person.errors) {
                    dialog.add(error.getTitle() + ".\n");
                    dialog.add(error.getDetail());
                }
                button.addClickListener(event -> {
                    dialog.close();
                });
                dialog.add(button);
                dialog.setWidth("400px");
                dialog.setHeight("150px");
                dialog.open();
            }
        });
    }

}
