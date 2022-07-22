package com.elpericoo.lists.storage

import android.content.Context
import com.elpericoo.lists.config.ConfigService
import com.elpericoo.lists.entities.Note
import com.elpericoo.lists.storage.firebase.NotesRepositoryFirebase
import com.elpericoo.lists.storage.local.NotesRepositoryLocal

class ListService constructor(val context: Context) {

    lateinit var notes:List<Note>
    lateinit var notesRepository: INotesRepository
    private lateinit var configService: ConfigService

    init {
        var defaultId: String?
        configService = ConfigService(context)
        when (configService.getSelectedStorage()) {
            StorageTypes.FIREBASE -> {
                notesRepository = NotesRepositoryFirebase(context)
                defaultId = configService.getDefaultFirebaseNode()
            }
            StorageTypes.LOCAL ->{
                notesRepository = NotesRepositoryLocal(context)
                defaultId = configService.getDefaultFileName()
        }
       notes = notesRepository.readNotesById(defaultId!!)
    }


    }
}