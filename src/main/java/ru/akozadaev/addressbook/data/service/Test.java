/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.service;
import com.google.gson.*;
import ru.akozadaev.addressbook.data.entity.DataPerson;
import ru.akozadaev.addressbook.data.entity.Errors;
import ru.akozadaev.addressbook.data.entity.Person;


public class Test {
    public static void main(String[] args) {
        JsonParser clientAPI = new JsonParser();
//        String res = clientAPI.getJson("192.168.0.21", "сто");
        String res = GetPropirties.get().getProperty("res");
        String err =  GetPropirties.get().getProperty("err");//"{\"result\": \"error\",\"data\": null,\"errors\": [{\"status\": 555,\"title\": \"Ошибка базы данных\",\"detail\": \"Не удалось определить принадлежность к организации\"}]}";

        System.out.println(res);
        System.out.println(err);
        Gson g = new Gson();
        Person pers = g.fromJson(res, Person.class);
//        Person pers = g.fromJson(err, Person.class);
        if (pers.result.toLowerCase().equals("ok")) {
            for (DataPerson person : pers.data.dataPerson) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println();
            for (Errors error : pers.errors) {
                System.out.println(error.getTitle());
                System.out.println(error.getDetail());
            }

        }

        System.out.println(pers.result);

    }
}
