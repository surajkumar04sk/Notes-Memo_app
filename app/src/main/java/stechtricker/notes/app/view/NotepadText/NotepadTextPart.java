package stechtricker.notes.app.view.NotepadText;

public class NotepadTextPart {
    private int start;
    private int end;

    public NotepadTextPart(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean isValid() {
        return start < end;
    }
}
