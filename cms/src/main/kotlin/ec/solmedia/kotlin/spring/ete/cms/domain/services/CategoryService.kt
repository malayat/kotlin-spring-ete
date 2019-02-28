package ec.solmedia.kotlin.spring.ete.cms.domain.services

import org.springframework.stereotype.Service
import ec.solmedia.kotlin.spring.ete.cms.domain.models.Category
import ec.solmedia.kotlin.spring.ete.cms.domain.repository.CategoryRepository

/**
 * We received the CategoryRepository on a constructor, this class will be provided by the Spring container
 * because @Service annotation instruct the container to produce this, but in Spring 5 it is not necessary
 * to use @Autowired anymore in the constructor. It works because we had the only one constructor in that
 * class and Spring will detect it.
 */
@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun create(category: Category) = categoryRepository.save(category)

    fun update(id: String, category: Category) = categoryRepository.update(id, category)

    fun delete(id: String) = categoryRepository.delete(categoryRepository.findOne(id))

    fun findAll() = categoryRepository.findAll()

    fun findOne(id: String) = categoryRepository.findOne(id)
}