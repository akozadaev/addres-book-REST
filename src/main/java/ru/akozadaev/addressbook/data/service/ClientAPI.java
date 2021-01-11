/*
 * Copyright (c) 2021.
 * Alexey Kozadaev
 * akozadaev@inbox.ru
 */

package ru.akozadaev.addressbook.data.service;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientAPI {
    public String getData(String ipClient, String searchText) throws IOException {
        HttpResponse response = clientBasicLoginRequest(GetPropirties.get().getProperty("userName"), GetPropirties.get().getProperty("password"),ipClient,searchText);
        InputStreamReader reader = new InputStreamReader(response.getEntity().getContent());
        BufferedReader br = new BufferedReader(reader);

        StringBuilder sb = new StringBuilder();
        String line = "";
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    private HttpResponse clientBasicLoginRequest(String login, String password, String ip, String request) throws IOException {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials
                = new UsernamePasswordCredentials(login, password);
        provider.setCredentials(AuthScope.ANY, credentials);

        HttpClient client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(provider)
                .build();

        HttpResponse response = client.execute(
                new HttpGet(
                        String.format("http://sbt/book/hs/phone/v1/getperson?ipClient=%s&serchText=%s",ip,request)
                )
        );
        return response;
    }
}