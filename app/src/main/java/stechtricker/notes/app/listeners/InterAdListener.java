package stechtricker.notes.app.listeners;

import stechtricker.notes.app.entities.Note;

public interface InterAdListener {
    void onClick(int position, Note note, String type);
}
