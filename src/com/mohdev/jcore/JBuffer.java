package com.mohdev.jcore;

// You can give a BUFFER_MAX, OR DEFAULT_SIZE for
public class JBuffer {

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

    private static class BufBucket {
        JLine line; BufBucket nxt;

        public BufBucket(JLine line) {
            this.line = line;
            nxt = null;
        }
    }

    BufBucket head;   // {line}->{line}->...
    // JEditor: 12:4   means go to line 12 column 4th  notice charAt


    // A simple contiguous new line
    public boolean insert(String newline) {
        var nline = new JLine(newline);
        var node = new BufBucket(nline);
        if (head == null) {
            head = node;
            return true;
        }
        node.nxt = head;
        head = node;
        return true;
    }
    public boolean insert(int at, String newline) {
        return false;
    }

}

