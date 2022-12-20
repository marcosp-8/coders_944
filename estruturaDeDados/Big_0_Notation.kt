package estruturaDeDados

/*Em Kotlin, trata-se de nível de complexidade de código com o conceito de
  "Big O Notation".
  O(1) - Ideal e de baixa complexidade;
  O(N) - Não ideal, de complexidade relativa ao tamanho da variável;
  O(2N) - Pior das hipóteses, onde a complexidade é dobrada em relação ao tamanho da variável*/


data class Node<T>(
    var value: T,
    var next: Node<T>?
)

data class LinkedList2<T>(
    var head: Node<T>? = null
) {
    fun add(value: T) {
        val newNode = Node(value = value, null)

        if (head == null) {
            head = newNode
            return
        } else {
            var current = head
            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode
        }
    }

    fun remove(item: T): Node<T>? {
        var current = head
        var previus = head

        if (current == null) {
            println("Lista vazia")
            return null
        }

        while(current?.value != item) {
            previus = current
            current = current?.next
        }

        if(current?.value == item) {
            previus?.next = current?.next

            return current
        }

        println("Item não encontrado :/")

        return null
    }

    fun show() {
        var current = head
        if (current == null) {
            println("Lista vazia")
            return
        }

        while(current != null) {
            println(current.value)
            current = current.next
        }
    }

    fun isEmpty(): Boolean {
        return head == null
    }
}

fun main() {
    val list = LinkedList2<String>()

    println(list.isEmpty())

    list.add("primeiro valor")
    list.show()

    list.add("segundo valor")
    list.show()

    list.add("terceiro valor")
    list.show()

    var teste = list.remove("valor")
    list.show()

    println(teste)

}