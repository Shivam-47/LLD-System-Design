package org.example.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem{

    String name;
    List<FileSystem> childObjects;

    public Folder(String name){
        this.name = name;
        this.childObjects = new ArrayList<FileSystem>();
    }

    public void addFileSystem(FileSystem file){
        this.childObjects.add(file);
    }

    @Override
    public void ls() {
        String prefix = name + "\\";

        if(this.childObjects.size() == 0){
            System.out.println(prefix);
            return;
        }

        for(FileSystem fs: this.childObjects){
            System.out.printf(prefix);
            fs.ls();
        }
    }
}
