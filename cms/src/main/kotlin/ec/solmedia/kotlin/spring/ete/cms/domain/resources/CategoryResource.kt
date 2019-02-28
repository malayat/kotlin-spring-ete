package ec.solmedia.kotlin.spring.ete.cms.domain.resources

import ec.solmedia.kotlin.spring.ete.cms.domain.models.Category
import ec.solmedia.kotlin.spring.ete.cms.domain.services.CategoryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/category")
@Api(tags = ["category"], description = "Category API")
class CategoryResource(private val categoryService: CategoryService) {

    @GetMapping("/{id}")
    @ApiOperation(value = "Find category", notes = "Find the Category by ID")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "Category found"),
            ApiResponse(code = 404, message = "Category not found")
        ]
    )
    fun findOne(@PathVariable id: String): ResponseEntity<Category> = ResponseEntity.ok(categoryService.findOne(id))

    @GetMapping
    @ApiOperation(value = "List categories", notes = "List all categories")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "Categories found"),
            ApiResponse(code = 404, message = "Categories not found")
        ]
    )
    fun findAll(): ResponseEntity<List<Category>> = ResponseEntity.ok(categoryService.findAll().toList())

    @PostMapping
    @ApiOperation(value = "Create category", notes = "It permits to create a new category")
    @ApiResponses(
        value = [
            ApiResponse(code = 201, message = "Category created successfully"),
            ApiResponse(code = 400, message = "Invalid request")
        ]
    )
    fun newCategory(category: Category): ResponseEntity<Category> =
        ResponseEntity(categoryService.create(category), HttpStatus.CREATED)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remove category", notes = "It permits to remove a category")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "Category removed successfully"),
            ApiResponse(code = 404, message = "Category not found")
        ]
    )
    fun removeCategory(@PathVariable id: String) = categoryService.delete(id)


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update category", notes = "It permits to update a category")
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "Category update successfully"),
            ApiResponse(code = 404, message = "Category not found"),
            ApiResponse(code = 400, message = "Invalid request")
        ]
    )
    fun updateCategory(@PathVariable id: String, category: Category) =
        ResponseEntity(categoryService.update(id, category), HttpStatus.OK)
}