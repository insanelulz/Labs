package org.atkachenko.learnjava;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("C:/users/atkachenko/Downloads/input.txt"));
        String[] strings = new String[10];
        int i = 0;

        while (sc.hasNext()) {
            strings[i] = sc.nextLine();
            strings[i] = StringHelper.trimComments(strings[i]);
            i++;
        }

        for (String string: strings) {
            System.out.println(string);
        }

    }
}
