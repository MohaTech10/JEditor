package com.mohdev.jdriver;

import com.mohdev.jcore.JBuffer;
import com.mohdev.jcore.JPosition;
import com.mohdev.jcore.JTextBuffer;
import com.mohdev.jlib.buff.JBoardOperation;

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
                editup(newbuf.engine());
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
    public static void editup(JBuffer cbuf) {
        var clipper = new JBoardOperation(cbuf);  // FIXME
        System.out.println("OPTION: 1- [cpy(from, to)],   2- [paste(in)],  3- [cut(from, to)]");
        var stdin = new Scanner(System.in);   // fixme
        var option = stdin.nextLine();
        if (option.equals("1")) {
            System.out.println("USAGE: pass in arg in brackets, eg, [1: 3].     start from 1");
            var position = stdin.nextLine();  // we should parse it;
            clipper.cpy(new JPosition(1, 7));
        }


    }
}
