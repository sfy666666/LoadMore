package net.te.loadmore;

import java.util.ArrayList;
import java.util.List;

/**
 * author : sfy
 * time   : 2019/12/2
 * desc   :
 */
public  class DataServer {
    public  static List<User> getSampleData(int dataLength){
        List<User> users= new ArrayList<>();

        for (int i = 1; i < dataLength+1; i++) {
            users.add(new User(""+i,"新增数据"+i,1));
        }
//        users.add(new User("1","c"));
//        users.add(new User("2","c++"));
//        users.add(new User("3","c#"));
//        users.add(new User("4","java"));
//        users.add(new User("5","php"));
//        users.add(new User("6","kotlin"));
//        users.add(new User("7","dart"));
//        users.add(new User("8","dart1"));
//        users.add(new User("9","dart2"));
//        users.add(new User("10","dart3"));
//        users.add(new User("11","dart4"));
//        users.add(new User("12","dart5"));
//        users.add(new User("13","dart6"));
//        users.add(new User("14","dart7"));
//        users.add(new User("15","dart8"));
        return  users;
    }
    public  static List<User> getNewSampleData(int dataLength){
        List<User> users= new ArrayList<>();
        for (int i = 1; i < dataLength+1; i++) {
            users.add(new User(""+i,"刷新数据"+i,1));
        }
//        users.add(new User("1","c"));
//        users.add(new User("2","c++"));
//        users.add(new User("3","c#"));
//        users.add(new User("4","java"));
//        users.add(new User("5","php"));
//        users.add(new User("6","kotlin"));
//        users.add(new User("7","dart"));
//        users.add(new User("8","android"));
//        users.add(new User("9","ios"));
        return  users;
    }

}
