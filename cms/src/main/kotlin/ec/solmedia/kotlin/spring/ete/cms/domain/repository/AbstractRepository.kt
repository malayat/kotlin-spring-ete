package ec.solmedia.kotlin.spring.ete.cms.domain.repository

abstract class AbstractRepository<T>(protected val mockSet: MutableSet<T>) {

    fun delete(entity: T) = mockSet.remove(entity)

    fun findAll(): MutableSet<T> = mockSet

    fun save(entity: T): T {
        mockSet.add(entity)
        return entity
    }

    abstract fun update(id: String, entity: T)

    /**
     * Returns the first element matching the given predicate, or null if no such element was found
     */
    fun searchOne(id: String): T? = mockSet.find { id == it }

    /**
     * Throws: NoSuchElementException - if no such element is found.
     */
    abstract fun findOne(id: String): T
}