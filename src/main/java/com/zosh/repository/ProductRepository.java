package com.zosh.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zosh.modal.Product;
import com.zosh.user.domain.ProductSubCategory;


public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p From Product p Where LOWER(p.category.name)=:category")
	public List<Product> findByCategory(@Param("category") String category);
	
	@Query("SELECT p From Product p where LOWER(p.title) Like %:query% OR LOWER(p.description) Like %:query% OR LOWER(p.brand) LIKE %:query% OR LOWER(p.category.name) LIKE %:query%")
	public List<Product> searchProduct(@Param("query")String query);
	
//	@Query("SELECT p FROM Product p " +
//		       "WHERE (:category IS NULL OR p.category.name = :category)"+
//		       "AND (:colors IS NULL OR p.color IN (:colors))"
//	)
//	List<Product> filterProducts(
//		                            @Param("category") String category,
//		                            @Param("colors") List<String> colors
//		                             );
	
//	@Query("SELECT p FROM Product p " +
//            "WHERE (:category IS NULL OR p.category.name = :category) " +
//            "AND (p.color IN (:colors))" + 
//			"AND EXISTS (SELECT s FROM p.size s WHERE s.name IN :sizes AND s.quantity >= 1)")
//	List<Product> filterProducts(@Param("category") String category,
//                          @Param("colors") List<String> colors,
//                          @Param("sizes") List<String> sizes);
	
	@Query("SELECT p FROM Product p " +
	        "WHERE (:category IS NULL OR p.category.name = :category) " +
//	        "AND EXISTS (" +
//	        "   SELECT s FROM p.sizes s " +
//	        "   WHERE s.name IN :sizes AND s.quantity >= 1 " +
//	        ") "+
	        "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice)) " +
		    "AND (:minDiscount IS NULL OR p.discountPersent >= :minDiscount) " +
		    "ORDER BY " +
		    "CASE WHEN :sort = 'price_low' THEN p.discountedPrice END ASC, " +
		    "CASE WHEN :sort = 'price_high' THEN p.discountedPrice END DESC")
	Page<Product> filterProducts(
	        @Param("category") String category,
//	        @Param("sizes") List<String> sizes,
			@Param("minPrice") Integer minPrice,
			@Param("maxPrice") Integer maxPrice,
			@Param("minDiscount") Integer minDiscount,
			@Param("sort") String sort,
			Pageable pageable
			);
}
	
//	@Query("SELECT p FROM Product p " +
//		       "WHERE  (:colors IS NULL OR p.color IN (:colors)) " +
//		       "AND (:category IS NULL OR p.category.name = :category) "+
//		       "AND (:sizes IS NULL OR EXISTS (SELECT s FROM p.size s WHERE s.name IN (:sizes))) "+
//		       "AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice)) " +
//		       "AND (:minDiscount IS NULL OR p.discountPersent >= :minDiscount) " +
//		       "ORDER BY " +
//		       "CASE WHEN :sort = 'price_low' THEN p.price END ASC, " +
//		       "CASE WHEN :sort = 'price_high' THEN p.price END DESC")
//		List<Product> filterProducts(@Param("colors") List<String> colors,
//		                             @Param("sizes") List<String> sizes,
//		                             @Param("minPrice") Integer minPrice,
//		                             @Param("maxPrice") Integer maxPrice,
//		                             @Param("minDiscount") Integer minDiscount,
//		                             @Param("category") String category,
//		                             @Param("sort") String sort
//		                             );
//
//}
