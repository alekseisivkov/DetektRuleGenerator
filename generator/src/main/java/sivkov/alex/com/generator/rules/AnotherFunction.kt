package sivkov.alex.com.generator.rules

import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtIfExpression

class AnotherFunction : Rule() {
    override val issue: Issue = Issue(
            javaClass.simpleName,
            Severity.Defect,
            "Custom test rule",
            Debt.FIVE_MINS
    )


    override fun visitIfExpression(expression: KtIfExpression) {
        super.visitIfExpression(expression)
        val builder = StringBuilder()
                .append("condition = ${expression.condition}\n")
                .append("leftParenthesis = ${expression.leftParenthesis}\n")
                .append("rightParenthesis = ${expression.rightParenthesis}\n")
                .append("name = ${expression.name}\n")
                .append("expressions = $expression")
        println("OLOLO. Visit if expression condition $builder")
    }
}