package com.ioc_05;

public class DefaultServiceLocator {
    private static ClientServiceImp clientServiceImp = new ClientServiceImp();

    public ClientServiceImp clientServiceImp() {
        return clientServiceImp;
    }
}
