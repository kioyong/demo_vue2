package com.yong.demo.repository;

import com.yong.demo.model.Todo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @acthor yong.a.liang
 * @date 2017/11/14
 */
@Repository
public interface TodoRepository extends ReactiveMongoRepository<Todo,String> {
}
