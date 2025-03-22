package org.example.ResourceDao;

public class ResourceDaoImpl implements ResourceDao {
    @Override
    public void CreateResource() {
        System.out.println("Created Resource");
    }

    @Override
    public void GetResource() {
        System.out.println("Updated Resource");
    }
}
