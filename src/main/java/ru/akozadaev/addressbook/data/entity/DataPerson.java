/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.entity;

import org.springframework.stereotype.Component;

@Component
public class DataPerson {
    public String personLastName;
    public String personFirstName;
    public String personSecondName;
    public String orgName;
    public String orgDepartment;
    public String orgDivision;
    public String personPost;
    public String phoneCity;
    public String phoneInternal;
    public String eMail;
    public String name;
    public String orgDepDataFull;

    public String getOrgDepDataFull() {
        StringBuilder sb = new StringBuilder();
        sb.append(orgDivision + ", ");
        sb.append(orgDepartment);

        return sb.toString();
    }

    public String getName() {
        StringBuilder sb = new StringBuilder();
        sb.append(personLastName + " ");
        sb.append(personFirstName + " ");
        sb.append(personSecondName);
        return sb.toString();
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public String getPersonSecondName() {
        return personSecondName;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getOrgDepartment() {
        return orgDepartment;
    }

    public String getOrgDivision() {
        return orgDivision;
    }

    public String getPersonPost() {
        return personPost;
    }

    public String getPhoneCity() {
        return phoneCity;
    }

    public String getPhoneInternal() {
        return phoneInternal;
    }

    public String geteMail() {
        return eMail;
    }

    @Override
    public String toString() {
        return "DataPerson{" +
                "personLastName='" + personLastName + '\'' +
                ", personFirstName='" + personFirstName + '\'' +
                ", personSecondName='" + personSecondName + '\'' +
                ", orgName='" + orgName + '\'' +
                ", orgDepartment='" + orgDepartment + '\'' +
                ", orgDivision='" + orgDivision + '\'' +
                ", personPost='" + personPost + '\'' +
                ", phoneCity='" + phoneCity + '\'' +
                ", phoneInternal='" + phoneInternal + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }

}
