
import java.util.Scanner

fun main(args: Array<String>) {
    val editor = EditorClass(ArrayList())
    while (true) {
        println("Список архивов: a")
        println("0. Создать архив c")
        println("1. Это мой уже созданный архив v")
        println("2. Выход e ")


        val user = Scanner(System.`in`).nextLine()

        if (user.toIntOrNull() == null ){
            println("Вводить можно только цифры")
        }else{
        when (user.toIntOrNull()) {
            0 -> {
                println("Введите название архива")
                val user = Scanner(System.`in`).nextLine()
                editor.addArchive(user)
            }
            1 ->{
                editor.viewArchives()
                if(editor.isEmpty() != true){

                val user = Scanner(System.`in`).nextLine()
                val note: Note<ArchiveObject> = Note()
                editor.choiceArchive(user)?.let {
                    note.putArchive(it)
                    note.start(editor)
                }
                }else{
                    println("Массив пуст")
                }
            }
            2 -> return
            else -> println("Нет такой команды")
        }
        }
    }
}

