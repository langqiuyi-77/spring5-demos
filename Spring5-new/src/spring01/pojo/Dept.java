package spring01.pojo;

public class Dept {
    private String dname;
    public void setDname(String dname) {
        this.dname = dname;
    }

//    public String getDname() {
////        return dname;
////    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
