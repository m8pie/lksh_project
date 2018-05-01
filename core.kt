import java.util.*
val scan = Scanner(System.`in`)

var database:MutableMap<String, String> = mutableMapOf()

fun essketit(command: String){
    when(command){
        "HELP" -> help()
        "ADD" -> addtodb()
        "FINDKEY" -> findbykey()
        "FINDVAL" -> findbyval()
        "DELKEY" -> delbykey()
        "DELVAL" -> delbyval()
        "SEEBASE" -> printthebase()
    }
}

fun printthebase(){
    for((i, e) in database){
        println("Ключ: $i; Значение: $e")
    }
    println("Готово")
}

fun delbyval(){
    val value = scan.next()
    while(database.containsValue(value)){
        for((i, e) in database){
            if(e == value){
                database.remove(i)
                break
            }
        }
    }
    println("Готово")
}

fun delbykey(){
    val key = scan.next()
    database.remove(key)
    println("Готово")
}

fun findbyval(){
    val value = scan.next()
    var minutebase:MutableMap<Int, String> = mutableMapOf()
    var flag = 0
    if(database.containsValue(value)){
        flag = 1
        println("Найденные значения с этим значением:")
        for((i, e) in database) {
            if (e == value) {
                println("Ключ: $i; Значение: $e")
            }else if(e.contains(value)){
                minutebase[minutebase.size] = ("Ключ: $i; Значение: $e")
            }
        }
    }
    if(minutebase.isNotEmpty()){
        flag = 1
        println("Найденные пары по фрагменту значения:")
        for((i, e) in minutebase){
            println(e)
        }
    }
    if(flag == 0){
        println("Таковых не нашлось...")
    }
}

fun findbykey(){
    val key = scan.next()
    var minutebase:MutableMap<Int, String> = mutableMapOf()
    var flag = 0
    if(database.containsKey(key)){
        flag = 1
        println("Найденные значения с этим ключом:")
        for((i, e) in database) {
            if (i == key) {
                println("Ключ: $i; Значение: $e")
            }else if(i.contains(key)){
                minutebase[minutebase.size] = ("Ключ: $i; Значение: $e")
            }
        }
    }
    if(minutebase.isNotEmpty()){
        flag = 1
        println("Найденные пары по фрагменту ключа:")
        for((i, e) in minutebase){
            println(e)
        }
    }
    if(flag == 0){
        println("Таковых не нашлось...")
    }
}

fun addtodb(){
    val key = scan.next()
    if(database.containsKey(key)){
        println("Ключ уже существует, вы уверены, что хотите обновить его значение?\n(Yes/No\n)")
        val answer = scan.next()
        if(answer != "Yes"){
            println("Возвращаюсь в основное меню...")
            help()
            return
        }
    }
    val value = scan.next()
    database[key] = value
    println("Готово")
}

fun help(){
    println("*******************\n" +
            "Добро пожаловать\n" +
            "1. Чтобы добавить пару используйте:\n" +
            "ADD <ключ> <значение> \n" +
            "2. Чтобы удалить пару используйте:\n" +
            "a) DELKEY <ключ> (для удаления по ключу)\n" +
            "б) DELVAL <значение> (для удаления по значению, удаляет все подходящие пары)\n" +
            "3. Чтобы найти пары по фрагменту используйте:\n" +
            "а) FINDKEY <ключ> (для поиска по фрагменту ключа)\n" +
            "б) FINDVAL <значение> (для поиска по фрагменту значения)\n" +
            "5. Чтобы вывести на экран все имеющиеся пары используйте:\n" +
            "SEEBASE\n" +
            "6. Чтобы обратиться к этой инструкции вновь используйте:\n" +
            "HELP\n" +
            "7. Чтобы выйти из программы используйте:\n" +
            "EXIT\n" +
            "Примечание: все угловые скобки необходимо опустить, если они не являются частью ключа и/или значения\n" +
            "*******************")
}

fun main(args: Array<String>){
    help()
    while(true){
        val a = scan.next()
        if(a == "EXIT"){
            break
        }else{
            essketit(a)
        }
    }
}
