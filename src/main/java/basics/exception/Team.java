package basics.exception;

import basics.User;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final List<User> users;

    private Team (List<User> users){
        this.users = new ArrayList<>(users);
    }
    public static Team of(List<User> users){
        if(users == null) throw new NullPointerException("Users list cannot be null");
        return new Team(users);
    }
    public List<User> getAll(){
        return List.copyOf(users);
    }
}
