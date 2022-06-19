package spring01.pojo;

public class User {
    private String name;
    private String wifename;

    public void setName(String name) {
        this.name = name;
    }

    public void setWifename(String wifename) {
        this.wifename = wifename;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", wifename='" + wifename + '\'' +
                '}';
    }


    public User() {
    }

    public User(String name, String wifename) {
        this.name = name;
        this.wifename = wifename;
    }

    public void add(){
        System.out.println("add...");
    }
}
