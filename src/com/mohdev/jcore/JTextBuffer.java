package com.mohdev.jcore;

// user will be provided a new file option then name
public class JTextBuffer {
    private JBuffer content;
    String name;

    // A buffer and its content can never die?
    public JTextBuffer(String name) {
        content = new JBuffer();
        this.name = name;
    }
    /* is modified, is inserting, all sort of messages you can ask a prog page/text editor buffer  */


    public boolean save() {
        return false;
    }


    public boolean append(String txt) {
        return content.insert(txt);
    }
    ;

    public void dump() {
        content.dump();
    }
    public boolean delete() {
        return false;
    }
    // etc;

    public JBuffer engine() { return content; }

}
