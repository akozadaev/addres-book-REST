/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public final class GetMyIP {
    public static String getIP(){
        String ip = null;
        try {
        URL whatismyip = new URL("https://checkip.amazonaws.com");
        BufferedReader in = null;

            in = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));


        ip = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ip;
    }
}
