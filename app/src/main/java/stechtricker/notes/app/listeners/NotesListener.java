package stechtricker.notes.app.listeners;

import stechtricker.notes.app.entities.Note;

public interface NotesListener {
    void onNoteClicked(Note note, int position);
}
