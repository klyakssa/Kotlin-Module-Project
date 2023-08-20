import java.util.*
import kotlin.collections.ArrayList

class EditorClass(var archiveObject: ArrayList<ArchiveObject?>?) {

    fun addArchive(archiveName: String){
        val a = ArchiveObject(archiveName, arrayListOf<NoteObject>())
        archiveObject!!.add(a)
    }


    fun choiceArchive(index: String): ArchiveObject? {
        if (archiveObject?.getOrNull(index.toInt()) != null) {
            return archiveObject?.get(index.toInt())
        } else {
            println("Нет такого архива")
            return null
        }
    }

    fun viewArchives(){
        archiveObject!!.forEach{
            println("${archiveObject!!.indexOf(it)}. ${it!!.nameArchive}")
        }
    }

    fun isEmpty(): Boolean? {
        return archiveObject?.isEmpty()
    }

    fun addNote(nameNote: String,archiveObject: ArchiveObject){
        println("Введите содержание заметки:")
        val user = Scanner(System.`in`).nextLine()
        archiveObject.notes.add(NoteObject(nameNote,user))
    }

    fun viewNotes(archiveObject: ArchiveObject){
        archiveObject!!.notes.forEach{
            println("${archiveObject!!.notes.indexOf(it)}. ${it!!.nameNote}")
        }
    }

    fun choiceNote(index: String, archiveObject: ArchiveObject): NoteObject? {
        if (archiveObject?.notes?.getOrNull(index.toInt()) != null) {
            return archiveObject?.notes!!.get(index.toInt())
        } else {
            println("Нет такой заметки")
            return null
        }
    }
}
