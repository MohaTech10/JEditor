package com.mohdev.jlib.buff;

import com.mohdev.jcore.JPosition;

class Selection {
    private String selected;  // SelectedText;

    int begin, end;  // TODO: improve api

    public Selection(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public String text() {
        return selected;
    }

}

class ClipStack {
    String[] storage; // stack
    int max;
    int sp = 0;  // empty;
    public ClipStack() {
        this(10);
    }
    public ClipStack(int size) {
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


}
public class JClipBoard {
    // TODO -- attrs


    // The storage;
    ClipStack clip; // [copyable, copyable, etc...]
    // questions can be currentSize of the clipStorage;
    // other stuff as well;
    // We;ll temporarily keep track of the copied text;

    public boolean cpy(JPosition position) {

        return false;
    }
    public boolean cut() {

        return false;
    }
    public boolean paste(JPosition in) {

        return true;
    }

}
