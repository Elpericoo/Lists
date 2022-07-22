package com.elpericoo.lists.storage

import com.elpericoo.lists.entities.Note

interface INotesRepository {
    fun createNotes(id: String, copyExample: Boolean)
    fun readNotes():List<String>
    fun readNotesById(id: String):List<Note>
    fun updateNotes(notes: List<Note>)
    fun deleteNotes(id: String)


}