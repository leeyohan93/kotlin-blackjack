package study

class Resume(
    val name: String,
    val company: String? = null,
    val skills: List<Skill> = emptyList(),
    val languages: List<Language> = emptyList(),
)

fun introduce(block: ResumeBuilder.() -> Unit): Resume {
    return ResumeBuilder().apply(block).build()
}

class ResumeBuilder {
    private lateinit var name: String
    private var company: String? = null
    private var skills: List<Skill> = emptyList()
    private var languages: List<Language> = emptyList()

    fun name(value: String) {
        name = value
    }

    fun company(value: String) {
        company = value
    }

    fun skills(block: SkillBuilder.() -> Unit) {
        skills = SkillBuilder().apply(block).build()
    }

    fun languages(block: LanguageBuilder.() -> Unit) {
        languages = LanguageBuilder().apply(block).build()
    }

    fun build(): Resume {
        return Resume(
            name = name,
            company = company,
            skills = skills,
            languages = languages
        )
    }
}
