package com.mohdev.jlib.buff;

import com.mohdev.jcore.FunctionalBuf;
import com.mohdev.jcore.JBuffer;
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

public class JBoardOperation {
    // TODO -- attrs


    JClipBoard clip; // [copyable, copyable, etc...]
    JBuffer currentBuff;

    public JBoardOperation(JBuffer currentBuff) {
        clip = new JClipBoard();
        this.currentBuff = currentBuff;
    }

    // FIXME: what an implementation;
    public boolean cpy(JPosition position) {

        var begline = currentBuff.getat(position.begline);
        assert begline != null;
        var strbuf = new StringBuilder();
        if (currentBuff.walk(begline, position.endline, new FunctionalBuf() {
            public void access(JBuffer.BufBucket bucket) {
                strbuf.append(bucket.line().txt()).append(" ");
            }
        })
        ) {
            System.out.println("Failed");
            return true;
        }


        clip.push(strbuf.toString());
        return false;
    }
    public boolean cut() {

        return false;
    }
    public boolean paste(JPosition in) {

        return true;
    }

}
