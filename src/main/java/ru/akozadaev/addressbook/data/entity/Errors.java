/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.entity;

public class Errors {
    String status;
    String title;
    String detail;

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "Errors{" +
                "status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
