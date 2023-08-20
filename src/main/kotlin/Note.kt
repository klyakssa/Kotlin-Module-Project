import java.util.*

class Note<T : ArchiveObject> {
    var archive: T? = null

    fun putArchive(a: ArchiveObject) {
        archive = a as T?
    }

    fun start(editor: EditorClass){
        while (true){
            println("Список заметок: z")
            println("0. Создать заметку c")
            println("1. Это моя уже созданная заметка v")
            println("2. Выход e ")

            val user = Scanner(System.`in`).nextLine()


            if (user.toIntOrNull() == null ){
                println("Вводить можно только цифры")
            }else {
                when (user.toIntOrNull()) {
                    0 -> {
                        println("Введите название заметки:")
                        val user = Scanner(System.`in`).nextLine()
                        archive?.let { editor.addNote(user, it) }
                    }
                    1 -> {
                        archive?.let { editor.viewNotes(it) }

                        val user = Scanner(System.`in`).nextLine()

                        archive?.let {
                            editor.choiceNote(user, it)?.let {
                                println("Содержимое заметки ${it.nameNote}:")
                                println(it.data)
                            }
                        }
                    }
                    2 -> return
                    else -> println("Нет такой команды")
                }
            }
        }
    }

}