package com;

public class ClientService {
    private static ClientService clientService = new ClientService();

    private ClientService() {};
    public static ClientService clientService(){
        return clientService;
    }
}
