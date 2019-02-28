package ec.solmedia.kotlin.spring.ete.cms.domain.services

import org.springframework.stereotype.Service
import ec.solmedia.kotlin.spring.ete.cms.domain.models.User
import ec.solmedia.kotlin.spring.ete.cms.domain.repository.UserRepository

/**
 * /**
 * We received the UserRepository on a constructor, this class will be provided by the Spring container
 * because @Service annotation instruct the container to produce this, but in Spring 5 it is not necessary
 * to use @Autowired anymore in the constructor. It works because we had the only one constructor in that
 * class and Spring will detect it.
*/
 */
@Service
class UserService(private val userRepository: UserRepository) {

    fun create(user: User) = userRepository.save(user)

    fun update(user: User) = userRepository.save(user)

    fun delete(id: String) = userRepository.delete(userRepository.findOne(id))

    fun findAll() = userRepository.findAll()

    fun findOne(id: String) = userRepository.findOne(id)
}