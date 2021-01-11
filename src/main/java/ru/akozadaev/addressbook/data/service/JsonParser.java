/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.service;

import java.io.IOException;

public class JsonParser {
    public String getJson(String ipClient, String searchText){
        ClientAPI client = new ClientAPI();
        String data = null;
        try {
            data = client.getData(ipClient, searchText);
        } catch (IOException e) {
            e.printStackTrace(); //TODO LOGGER
        }

        return data;
    }


}
