package com.mohdev.jdriver;

import com.mohdev.jcore.JBuffer;
import com.mohdev.jcore.JPosition;
import com.mohdev.jcore.JTextBuffer;
import com.mohdev.jlib.buff.JBoardOperation;

import java.util.Scanner;

public class Main {

    private enum OPTION {
        cpy, paste, cut, NONE;
    }
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

        System.out.println("--------- Start Editing ----------");
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
        var opt = OPTION.NONE;
        var stdin = new Scanner(System.in);   // fixme
        var option = stdin.nextLine();
        if (option.equals("1")) {
            opt = OPTION.cpy;
            System.out.println("USAGE: pass in arg in brackets, eg, [1: 3].     start from 1");
            var postxt = stdin.nextLine();  // we should parse it;
            var cpypos = parsecpy(postxt);
            clipper.cpy(cpypos);
        }
    }

    private static boolean must(char tkn, char match) {

        if (tkn != match) return true;

        return false;
    }

    // TODO: Later, either use lexer, or flag-based parsing
    private static JPosition parsecpy(String unparsed) {
        var i = 0;
        if (must(unparsed.charAt(i++), '[')) {
            System.err.println("Error: Expected `[`. Got " + unparsed.charAt(0) + " instead");
            return null;  // a mark for invalidity;
        }

        var beginbuffer = new StringBuilder();
        while (Character.isDigit(unparsed.charAt(i))) {
            beginbuffer.append(unparsed.charAt(i));
            i++;
        }

        if (i == 1) {
            System.err.println("Expect start position after `[`");
            return null;
        }
        // var semicolonPos = i; then if i == semiColon + 1   means we have an error;
        if (must(unparsed.charAt(i++), ':')) {
            System.err.println("Error: Expected `:`. Got " + unparsed.charAt(i) + " instead");
            return null;
        }

        var j = i;
        var endbuffer = new StringBuilder();
        while (Character.isDigit(unparsed.charAt(j))) {
            endbuffer.append(unparsed.charAt(j));
            j++;
        }
        if (j == i) {
            System.err.println("Expect end position after `:`");
        }

        if (must(unparsed.charAt(j), ']')) {  // j will always point to last thing after the number so last number digit +1 and i will always point to :+1 position
            System.err.println("Error: Expected `:`. Got " + unparsed.charAt(i) + " instead");
            return null;
        }

        var bpos = Integer.parseInt(beginbuffer.toString());
        var epos = Integer.parseInt(endbuffer.toString());
        return new JPosition(bpos, epos) ;
    }


}
