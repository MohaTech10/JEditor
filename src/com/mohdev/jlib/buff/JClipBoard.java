package com.mohdev.jlib.buff;

public class JClipBoard {
    String[] storage; // stack
    int max;
    int sp = 0;  // empty;

    public JClipBoard() {
        this(10);
    }

    public JClipBoard(int size) {
        storage = new String[size];
        max = size;
    }

    public boolean push(String copyable) {
        if (sp > max) {
            System.out.println("Full");
            return true;
        }

        storage[sp++] = copyable;
        return false;

    }

    public String pop() {
        if (empty()) return null;

        return storage[sp--];

    }

    public boolean empty() {
        return sp == 0;
    }

    public void print() {
        var s = sp;
        while (s-- > 0) System.out.println(storage[s]);
    }
}
