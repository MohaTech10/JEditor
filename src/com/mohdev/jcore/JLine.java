package com.mohdev.jcore;

// a line, and a row; these are concept aren't they?
// A character? mybe; but you can't navigate that write?
// A simple wrapper;
public class JLine {
    String aline;   // We can navigate using that but we;ll see

    public JLine(String aline) {
        this.aline = aline;
    }

    public boolean at(int column, char /*&*/charRef) {
        if (column > len() || column < 0) {
            // just hold there;
            return true;
        }


        // We could store it, send it back, and more
        charRef = aline.charAt(column);
//        System.out.println();
        return true;


    }

    public int len() {
        return aline.length();
    }
//    private boolean insertline() { }

}
