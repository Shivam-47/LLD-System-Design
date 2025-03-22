package org.example.ResourceDao;

public class ResourceDaoProxy implements ResourceDao {
    private ResourceDao resourceDaoImpl;
    private String proxyMode;

    public ResourceDaoProxy(ResourceDao resourceDao, String proxyMode) {
        this.resourceDaoImpl = resourceDao;
        this.proxyMode = proxyMode;
    }

    @Override
    public void CreateResource() {
        if (proxyMode == "CREATE") {
            this.resourceDaoImpl.CreateResource();
        } else {
            System.out.println("CREATE BLOCKED");
        }
    }

    @Override
    public void GetResource() {
        if (proxyMode == "READ") {
            this.resourceDaoImpl.GetResource();
        } else {
            System.out.println("READ BLOCKED");
        }
    }
}
