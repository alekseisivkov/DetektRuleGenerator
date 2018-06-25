package sivkov.alex.com.generator

import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.RuleSet
import io.gitlab.arturbosch.detekt.api.RuleSetProvider
import sivkov.alex.com.generator.rules.ComplicatedIfElseStatement

class CustomRuleProvider : RuleSetProvider {

    override val ruleSetId: String = "custom"

    override fun instance(config: Config) = RuleSet(ruleSetId, listOf(ComplicatedIfElseStatement(config)))
}
