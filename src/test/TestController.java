package test;

import common.easyui.DataGrid;
import exe.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by shibin on 2016/12/30.
 */
public class TestController {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserController userController = (UserController)applicationContext.getBean("userController");
        DataGrid dataGrid = userController.getUserById(1);
        System.out.println(dataGrid.getRows().get(0));

    }
    /*public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = (UserController)applicationContext.getBean("userController");

        DataGrid dataGrid = userController.findAllUser();
        List<User> list = dataGrid.getRows();
        for(User user : list){
            if(user != null)
                System.out.println("用户名称："+user.getUserName());
        }
    }*/
}
