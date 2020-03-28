package com.fsh.jcartadministrationback.es.repo;

import com.fsh.jcartadministrationback.es.doc.ProductDoc;
import com.fsh.jcartadministrationback.po.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-03-28 11:40
 */
public interface ProductRepo extends ElasticsearchRepository<ProductDoc,Integer> {

}
