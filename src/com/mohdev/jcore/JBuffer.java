package com.mohdev.jcore;

public class JBuffer {


    public static class BufBucket {
        JLine line; BufBucket nxt;

        public BufBucket(JLine line) {
            this.line = line;
            nxt = null;
        }

        public JLine line() { return line; }
    }

    BufBucket head;   // {line}->{line}->...
    BufBucket tail;
    // JEditor: 12:4   means go to line 12 column 4th  notice charAt
    int size;

    // A simple contiguous new line
    public boolean insert(String newline) {
        var nline = new JLine(newline);
        var node = new BufBucket(nline);
        if (head == null) {
            head = tail = node;
            size++;
            return true;
        }
        tail.nxt = node;
        tail = node;
        size++;
        return true;
    }

                //#
    //  line -> line2 -> line3 -> line4
    // line2- 4
    //


    // pos is always 1
    public BufBucket getat(int pos) {
        if (pos > size || pos < 0) return null;

        var current = head;
        for (int i = 1; i < pos; i++)
            current = current.nxt;
        return current;
    }

    public boolean walk(BufBucket from, int step, FunctionalBuf callback) {
        // step should be bound check; 20
        if (step > size || step < 0) { return true; }
        var current = from;
        while (step-- > 0 && current != null) {
            callback.access(current);
            current = current.nxt;
        }

        // TODO: if step != -1 means we didn't go all the steps, raise an out of bounds steps;, Two ways, offset, or known-line number
        return false;
    }
    public void dump() {
        var current = head;
        var lines = 0;
        while (current != null) {
            System.out.println("LINES ARE :" + current.line.aline);
            current = current.nxt;
            lines ++;
        }
        System.out.println("NUMBER OF LINES STORED IS: " + lines);
    }

}

