package ec.solmedia.kotlin.spring.ete.cms.domain.resources

import ec.solmedia.kotlin.spring.ete.cms.domain.models.News
import ec.solmedia.kotlin.spring.ete.cms.domain.models.Review
import ec.solmedia.kotlin.spring.ete.cms.domain.models.Role
import ec.solmedia.kotlin.spring.ete.cms.domain.models.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/news")
class NewsResource {

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String) =
        ResponseEntity.ok(
            News(
                "1", "A", "Content",
                User("1", "", "", Role.AUTHOR),
                emptySet(),
                mutableSetOf(),
                emptySet(),
                emptySet()
            )
        )

    @GetMapping
    fun findAll() = ResponseEntity.ok(emptyList<News>())

    @PostMapping
    fun newNews(news: News) =
        ResponseEntity(
            News(
                news.id,
                news.title,
                news.content,
                news.author,
                news.mandatoryReviewers,
                news.reviewers,
                news.categories,
                news.tags
            ), HttpStatus.CREATED
        )

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeNews(@PathVariable id: String) {
    }

    @PutMapping("/{id}")
    fun updateNews(@PathVariable id: String, news: News) =
        ResponseEntity(
            News(
                news.id,
                news.title,
                news.content,
                news.author,
                news.mandatoryReviewers,
                news.reviewers,
                news.categories,
                news.tags
            ), HttpStatus.OK
        )

    @GetMapping("/{id}/review/{userId}")
    fun review(@PathVariable id: String, @PathVariable userId: String) =
        ResponseEntity.ok(Review("userId", "status"))


    @GetMapping("/revised")
    fun revised() = ResponseEntity.ok(emptyList<News>())

}