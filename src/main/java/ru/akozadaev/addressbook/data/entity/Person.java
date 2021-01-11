/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.entity;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Person {
    public String result;
    public Data data;
    public List<Errors> errors;

    public String getResult() {
        return result;
    }

    public Data getData() {
        return data;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "Pers{" +
                "result='" + result + '\'' +
                ", data=" + data +
                ", errors=" + errors +
                '}';
    }
}

