package ru.mirea.t21_22;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User interfacing = new User();
        ItemStore localStore = new LocalStore();
        ItemStore serverStore = new ServerStore();
        Scanner scanner = new Scanner(System.in);
        int change = 0;
        while (change != 3) {
            System.out.print(interfacing.onJsonFileChange().toString());
            change = scanner.nextInt();
            switch (change) {
                case 1:
                    while (change != 6) {
                        System.out.print(interfacing.onLocalFileChange().toString());
                        change = getChange(interfacing, localStore, scanner, localStore.get(change));
                    }
                    change = 0;
                    break;
                case 2:
                    while (change != 6) {
                        System.out.print(interfacing.onServerChange().toString());
                        change = getChange(interfacing, serverStore, scanner, localStore.get(change));
                    }
                    change = 0;
                    break;
                case 3:
                    System.out.println(interfacing.onExiting().toString());
                    break;
                default:
                    System.out.println(interfacing.onErrorMessage().toString());
                    break;
            }
        }
    }

    private static int getChange(User user, ItemStore localStore, Scanner scanner, Item item) {
        int change;
        String line;
        change = scanner.nextInt();
        switch (change) {
            case 1:
                System.out.print(user.onGettingAllItems());
                System.out.println("" + localStore.getAll());
                break;
            case 2:
                System.out.print(user.onGettingOneItem());
                change = scanner.nextInt();
                Item chk = localStore.get(change);
                if (chk == null) {
                    System.out.println(user.onNotFounded().toString());
                } else {
                    System.out.println(localStore.get(change));

                }

                break;
            case 3:
                System.out.println(user.onAddItem());
                scanner.nextLine();
                line = scanner.nextLine();
                System.out.println("" +
                        (localStore.addItem(new Item(Integer.parseInt(line.split(" ")[0]),
                                line.split(" ")[1],
                                line.split(" ")[2]))
                                ? user.onAddingSucceed().toString()
                                : user.onAddError().toString()));
                break;
            case 4:
                System.out.println(user.onEditingItem());
                scanner.nextLine();
                line = scanner.nextLine();
                System.out.println("" +
                        (localStore.editItem(
                                Integer.parseInt(line.split(" ")[0]),
                                new Item(Integer.parseInt(line.split(" ")[1]),
                                        line.split(" ")[2],
                                        line.split(" ")[3]))
                                ? user.onEditingSucceed().toString()
                                : user.onEditingError().toString()));
                break;
            case 5:
                System.out.println(user.onDeletingFile());
                change = scanner.nextInt();
                System.out.println("" +
                        (localStore.deleteItem(change)
                                ? user.onDeleteSucceed().toString()
                                : user.onDeleteingError().toString()));
                break;
            case 6:
                System.out.println(user.onExiting().toString());
                break;
            default:
                System.out.println(user.onErrorMessage().toString());
                break;
        }
        return change;
    }
}
