package com.fsh.jcartstoreback.es.repo;

import com.fsh.jcartstoreback.es.doc.ProductDoc;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-28 11:40
 */
public interface ProductRepo extends ElasticsearchRepository<ProductDoc,Integer> {

    List<ProductDoc> findByProductNameLikeOrProductAbstractLike(String productName,String productAbstract);
}
