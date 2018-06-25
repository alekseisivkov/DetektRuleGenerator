package sivkov.alex.com.generator.rules

import io.gitlab.arturbosch.detekt.test.assertThat
import io.gitlab.arturbosch.detekt.test.lint
import org.junit.Test

class ComplicatedIfElseStatementTest {
    private val rule = ComplicatedIfElseStatement()
    private val path = Case.ComplicatedIfElseStatement.path()

    @Test
    fun testIfElseComplicated() {
        assertThat(rule.lint(path)).hasSize(3)
    }
}