package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("Jony", "Bravo", "jony@.gmail.com",
//              new Car("Toyota", 111)));
//
//      userService.add(new User("Brad", "Pitt", "brad@gmail.com",
//              new Car("UAZ-Patriot", 123)));
//
//      userService.add(new User("Anton", "Gorodeckiy", "nightdoz@gmail.com",
//              new Car("ZIL", 221)));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }


      User userTemp = userService.usersCar("ZIL", 221);
      System.out.println(userTemp.getId());
      System.out.println(userTemp.getFirstName());
      System.out.println(userTemp.getLastName());
      System.out.println(userTemp.getEmail());

      context.close();
   }
}
