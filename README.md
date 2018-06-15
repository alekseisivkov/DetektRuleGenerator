# Detekt rule generator
Here's a simple application, which helps to generate necessary jar file with custom rules.

# How-to:
1. Pull the project
1. Locate task `:generator:createRules`
1. Run it
1. `rules.jar` file will be at `DetektRuleGenerator\generator\rules\`
1. Copy `rules.jar` into your project
1. Add reference `rules.jar` into your gradle `detekt` task. (Add -p or --plugins and pass path as an argument).

```groovy
def params = ['-p', %PATH_TO_RULES_JAR%]
```
