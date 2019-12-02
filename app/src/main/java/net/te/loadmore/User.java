package net.te.loadmore;

/**
 * author : sfy
 * time   : 2019/12/2
 * desc   :
 */
public class User {
    private String id;
    private String name;
    private int type;

    public int getType() {
        return type;
    }

    public User(String id, String name, int type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
