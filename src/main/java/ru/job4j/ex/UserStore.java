package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User user = null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].getUsername() == login) {
                user = users[i];
            }
        } if (user == null) {
            throw new UserNotFoundException("User not found exception");
       }
        return user;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if((user.isValid() == false) || (user.getUsername().length() < 3)) {
            throw new UserInvalidException("User invalid exception");
        }
        return true;
    }

    public static void main(String[] args)  {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        }catch (UserInvalidException ei) {
            ei.printStackTrace();
        }catch (UserNotFoundException en) {
            en.printStackTrace();
        }

    }
}
