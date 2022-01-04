 package com.mohdev.jcore;

public class JPosition {
    // FIXME: For now a position just from line to line. later should be in details


    int begline, endline;

    public JPosition(int begline, int endline) {
        this.begline = begline;
        this.endline = endline;
    }
}