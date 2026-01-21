package collections;

import basics.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        User userA = User.of(UUID.randomUUID(), "philips", "pippi.98@email.it");
        User userB = User.of(UUID.randomUUID(), "alessandro", "alex.33@email.it");
        User userC = User.of(UUID.randomUUID(), "andrea", "dry77@email.it");

        SafeList<User> userSafeList = SafeList.of(List.of(userA, userB));
        userSafeList.add(userC);
        System.out.println(userSafeList.getAll().toString());

        System.out.println("-------------------------------------------------------" +
                "-------------------------------------------------------------");

        List<Integer> listInt = new ArrayList<>();
        List<Double> listDouble = new ArrayList<>();
        List<Number> listNum = new ArrayList<>();

        NumberUtils.addToIntList(listNum, 2);
        NumberUtils.addToIntList(listNum, 2);
        NumberUtils.addToIntList(listNum, 2);
        System.out.println(NumberUtils.sum(listNum));

        System.out.println(NumberUtils.sum(listDouble));

        NumberUtils.addToIntList(listInt, 4);
        NumberUtils.addToIntList(listInt, 2);
        NumberUtils.addToIntList(listInt, 7);
        System.out.println(NumberUtils.sum(listInt));

        System.out.println("-------------------------------------------------------" +
                        "-------------------------------------------------------------");


        List<String> strings = List.of(
                "10",
                "5",
                "-3",
                "abc",
                "42",
                "0",
                "7x",
                "18"
        );

        List<Integer> integers = strings.stream()
                .map(s -> {
                    try{
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                })
                .filter(numb -> numb > 0)
                .toList();

        integers.forEach(s -> System.out.println(s));

        System.out.println("-------------------------------------------------------" +
                "-------------------------------------------------------------");
        // sopra ci sono gli user a b c
        User userD = User.of(UUID.randomUUID(), "giacomo", "jack@email.it");
        User userE = User.of(UUID.randomUUID(), "francesco", "fra.inter@email.it");
        User userF = User.of(UUID.randomUUID(), "simone", "simo.simo@email.it");

        List<User> users = List.of(userA, userB, userC, userD, userE, userF);

        List<User> filteredUsers = users.stream()
                .filter(s -> s.getName().contains("a"))
                .toList();

        filteredUsers.forEach(s -> System.out.println(s.toString()));
    }
}
