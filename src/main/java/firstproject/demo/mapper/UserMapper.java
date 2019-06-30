package firstproject.demo.mapper;


import firstproject.demo.entity.User;
import firstproject.demo.transport.UserTransport;

public class UserMapper {
    public static UserTransport toTransport(User user) {
        if (user == null) {
            return null;
        }

        UserTransport userTransport = new UserTransport();
        userTransport.setFullName(user.getFullName());
        userTransport.setUsername(user.getUsername());
        userTransport.setCreditCard(user.getCreditCard());
        userTransport.setPayment(user.getPayment());
        userTransport.setPassword(user.getPassword());

        return userTransport;
    }

    public static User toEntity(UserTransport userTransport) {
        if (userTransport == null) {
            return null;
        }

        User user = new User();
        user.setFullName(userTransport.getFullName());
        user.setUsername(userTransport.getUsername());
        user.setPassword(userTransport.getPassword());
        user.setCreditCard(userTransport.getCreditCard());
        user.setPayment(userTransport.getPayment());
        return user;
    }
}
