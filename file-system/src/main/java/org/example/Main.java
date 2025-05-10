package org.example;

import org.example.FileSystem.Folder;
import org.example.FileSystem.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to FileSystem");

        Folder mainFolder = new Folder("main");
        Folder dev1 = new Folder("dev1");
        mainFolder.addFileSystem(dev1);
        mainFolder.addFileSystem(new File("1.txt"));
        mainFolder.addFileSystem(new File("2.txt"));
        dev1.addFileSystem(new File("3.txt"));

        mainFolder.addFileSystem(new Folder("dev2"));
        mainFolder.addFileSystem(new File("3.txt"));
        mainFolder.addFileSystem(new File("4.txt"));
        mainFolder.addFileSystem(new File("5.txt"));

        mainFolder.addFileSystem(new Folder("dev3"));

        mainFolder.ls();
    }
}