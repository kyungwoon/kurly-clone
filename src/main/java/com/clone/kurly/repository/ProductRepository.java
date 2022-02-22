package com.clone.kurly.repository;

import com.clone.kurly.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findTop8ByOrderByNoDesc();
    List<Product> findTop8ByOrderByDiscountPercentDesc();
    List<Product> findAllByIsKurlyOnly(boolean isKurlyOnly);
    List<Product> findAllByCategoryNo(int categoryNo);
    Product findByPid(Long pid);
}


//    @Query("select  e" +
//            "from Product " +
//            "where t.article.articleId = :articleId")
//    List<Product> findRandomBanner();
    /*
    @Query("select  t.tag " +
            "from ArticleTag t " +
            "where t.article.articleId = :articleId")
    List<Tag> findTagByArticleId(@Param("articleId") Long articleId);
     */
