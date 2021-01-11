/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class GetPropirties {
    public static Properties get(){
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "application.properties";
        Properties appProps = new Properties();
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace(); //TODO LOGGER
        }
        return appProps;
    }

}
