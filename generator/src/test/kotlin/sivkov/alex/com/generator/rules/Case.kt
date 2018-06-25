package sivkov.alex.com.generator.rules

import io.gitlab.arturbosch.detekt.rules.style.KtFileContent
import io.gitlab.arturbosch.detekt.test.compileForTest
import io.gitlab.arturbosch.detekt.test.resource
import java.nio.file.Path
import java.nio.file.Paths

enum class Case(val file: String) {
    ComplicatedIfElseStatement("/cases/ComplicatedIfElseStatement.kt"),
    TooManyFunctions("/cases/TooManyFunctions.kt");

    fun path(): Path = Paths.get(resource(file))

    fun getKtFileContent(): KtFileContent {
        val file = compileForTest(path())
        val lines = file.text.splitToSequence("\n")
        return KtFileContent(file, lines)
    }
}