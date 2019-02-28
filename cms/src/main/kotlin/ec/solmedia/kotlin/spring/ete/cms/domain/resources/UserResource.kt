package ec.solmedia.kotlin.spring.ete.cms.domain.resources

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ec.solmedia.kotlin.spring.ete.cms.domain.models.Role
import ec.solmedia.kotlin.spring.ete.cms.domain.models.User

@RestController
@RequestMapping("/api/user")
class UserResource {

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: String) =
        ResponseEntity.ok(
            User(
                "1L",
                "A",
                "B",
                Role.AUTHOR
            )
        )


    @GetMapping
    fun findAll() = ResponseEntity.ok(emptyList<User>())

    @PostMapping
    fun newUser(user: User) =
        ResponseEntity(
            User(
                user.id,
                user.identity,
                user.name,
                user.role
            ), HttpStatus.CREATED)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removeUser(@PathVariable id: String) {
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: String, user: User) =
        ResponseEntity(
            User(
                user.id,
                user.identity,
                user.name,
                user.role
            ), HttpStatus.OK)

}