package com.ioc_05;

public class ClientService {
    private static ClientService clientService = new ClientService();

    private ClientService() {};
    public static ClientService clientService(){
        return clientService;
    }
}
