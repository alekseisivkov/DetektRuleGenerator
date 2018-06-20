package sivkov.alex.com.generator.rules

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtIfExpression

class ComplicatedIfElseStatement(config: Config) : Rule(config) {
    private val sizeLimit: Int = valueOrDefault("sizeLimit", 100)

    override val issue = Issue(javaClass.simpleName, Severity.Style,
            "If else block is too complicated. Braces should be added for better readability",
            Debt.FIVE_MINS)

    override fun visitIfExpression(expression: KtIfExpression) {
        val complicated = isComplicated(expression)
        if (isNotBlockExpression(expression) || isNotBlockOrIfExpression(expression) && complicated) {
            report(CodeSmell(issue, Entity.from(expression),
                    message = "If-Else statement is too long. Braces should add more readability"))
        }
        super.visitIfExpression(expression)
    }

    private fun isComplicated(expression: KtIfExpression) = expression.textLength > sizeLimit

    private fun isNotBlockExpression(expression: KtIfExpression) = expression.then !is KtBlockExpression

    private fun isNotBlockOrIfExpression(expression: KtIfExpression) =
            expression.`else` != null &&
                    expression.`else` !is KtIfExpression &&
                    expression.`else` !is KtBlockExpression
}
