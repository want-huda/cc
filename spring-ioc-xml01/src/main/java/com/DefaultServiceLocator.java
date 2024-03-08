package com;

public class DefaultServiceLocator {
    private static ClientServiceImp clientServiceImp = new ClientServiceImp();

    public ClientServiceImp clientServiceImp() {
        return clientServiceImp;
    }
}
