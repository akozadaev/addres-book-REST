/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.entity;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Data {
    public String dataOrg;
    public String dataIp;
    public List<DataPerson> dataPerson;

    public String getDataOrg() {
        return dataOrg;
    }

    public String getDataIp() {
        return dataIp;
    }

    public List<DataPerson> getDataPerson() {
        return dataPerson;
    }

    @Override
    public String toString() {
        return "Data{" +
                "dataOrg='" + dataOrg + '\'' +
                ", dataIp='" + dataIp + '\'' +
                ", dataPerson=" + dataPerson +
                '}';
    }
}
