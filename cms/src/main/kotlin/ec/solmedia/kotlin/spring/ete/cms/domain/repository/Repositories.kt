package ec.solmedia.kotlin.spring.ete.cms.domain.repository

import ec.solmedia.kotlin.spring.ete.cms.domain.models.Category
import ec.solmedia.kotlin.spring.ete.cms.domain.models.User
import org.springframework.stereotype.Service

@Service
class CategoryRepository : AbstractRepository<Category>(getMockCategories()) {

    override fun update(id: String, entity: Category) {
        delete(findOne(id))
        save(entity)
    }

    override fun findOne(id: String) = mockSet.first { it.id == id }
}

@Service
class UserRepository : AbstractRepository<User>(getMockUsers()) {

    override fun update(id: String, entity: User) {
        delete(findOne(id))
        save(entity)
    }

    override fun findOne(id: String): User = mockSet.first { id == it.id }
}