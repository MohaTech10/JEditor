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
            if (curin.equals("j:q")) {
                cleanup();
                break;
            } else if (curin.equals("j:e")) {
                editup();
                break;
            }
            newbuf.append(curin);
        }
        newbuf.dump();
    }

    public static void cleanup() {
        // clean up, then show back the main window;
        // TODO: IMPLEMENT ME
    }

    // editing: cpy, paste, cut, mv, etc..
    public static void editup() {
        System.out.println("OPTION: 1- [cpy(from, to)],   2- [paste(in)],  3- [cut(from, to)]");




    }
}
