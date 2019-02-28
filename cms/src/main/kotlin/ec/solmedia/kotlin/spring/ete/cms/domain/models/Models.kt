package ec.solmedia.kotlin.spring.ete.cms.domain.models

data class News(
    val id: String,
    val title: String,
    val content: String,
    val author: User,
    val mandatoryReviewers: Set<User>,
    val reviewers: MutableSet<Review>,
    val categories: Set<Category>,
    val tags: Set<Tag>
) {
    fun review(userId: String, status: String): Review {
        val review = Review(userId, status)
        this.reviewers.add(review)

        return review
    }

    fun revised(): Boolean =
        mandatoryReviewers.all { reviewer ->
            reviewers.any {
                it.userId == reviewer.id && "approved" == it.status
            }
        }
}

data class User(
    val id: String,
    val identity: String, val name: String, val role: Role
)

data class Review(val userId: String, val status: String)

data class Category(
    val id: String,
    val name: String
)

data class Tag(val value: String)
