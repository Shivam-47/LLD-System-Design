package org.example;

import org.example.ResourceDao.ResourceDao;
import org.example.ResourceDao.ResourceDaoImpl;
import org.example.ResourceDao.ResourceDaoProxy;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to proxy pattern!");

        ResourceDao resourceDao = new ResourceDaoImpl();

        //read
        ResourceDao readOnlyProxy = new ResourceDaoProxy(resourceDao, "READ");
        readOnlyProxy.GetResource();
        readOnlyProxy.CreateResource();

        //write
        ResourceDao writeOnlyProxy = new ResourceDaoProxy(resourceDao, "WRITE");
        writeOnlyProxy.CreateResource();
        writeOnlyProxy.GetResource();
    }
}