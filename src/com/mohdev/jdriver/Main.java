package com.mohdev.jdriver;

import com.mohdev.jcore.JTextBuffer;

import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("......Welcome to JEditor......");

        System.out.println();
        System.out.println("Options[: 1- new file |  2-  open file |  3-  close");


        var input = new Scanner(System.in);
        var opt = input.next();
        switch (opt) {
            case "1":
                // an option was made to : new file, and a new given
                setbuf();
                break;
            default:
                break;
        }
    }

    public static void setbuf() {
        System.out.println("Please provide file name...");
        // TODO: Extract it -- See used in Driver.main, Driver.setbuf
        var stdin = new Scanner(System.in);

        var newbuf = new JTextBuffer(stdin.nextLine());

        while (stdin.hasNextLine()) {
            var curin = stdin.nextLine();
            if (curin.equals("qp")) break;

            newbuf.append(curin);
        }
        newbuf.dump();
    }
}
