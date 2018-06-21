@Suppress("unused", "UNUSED_VARIABLE")
class ComplicatedIfElseStatement {

    private val switch = Math.random() <= 0.5

    fun main() {
        val complicatedIfElse = if (switch) "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor" else "Give up"

        val complicatedIfElse2 = if (switch) {
            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor"
        } else "Give up"

        val complicatedIfElse3 = if (switch) "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor" else {
            "Give up"
        }

        val goodIfElse = if (switch) "Yay" else "Okay too"
    }
}