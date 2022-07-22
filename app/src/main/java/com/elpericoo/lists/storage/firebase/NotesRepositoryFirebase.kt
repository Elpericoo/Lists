package com.elpericoo.lists.storage.firebase

import com.elpericoo.lists.entities.Note
import com.elpericoo.lists.storage.INotesRepository

class NotesRepositoryFirebase: INotesRepository {
    override fun createNotes(id: String, copyExample: Boolean) {
        TODO("Not yet implemented")
    }

    override fun readNotes(): List<String> {
        TODO("Not yet implemented")
    }

    override fun readNotesById(id: String): List<Note> {
        TODO("Not yet implemented")
    }

    override fun updateNotes(notes: List<Note>) {
        TODO("Not yet implemented")
    }

    override fun deleteNotes(id: String) {
        TODO("Not yet implemented")
    }
}