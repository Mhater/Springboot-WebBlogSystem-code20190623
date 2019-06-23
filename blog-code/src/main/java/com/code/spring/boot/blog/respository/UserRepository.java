package com.code.spring.boot.blog.respository;

import java.util.List;

import com.code.spring.boot.blog.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description:TODO
 * @version 1.0
 * @since JDK1.7
 * @author zxc asdq
 * @copyright (c) 2019 yaomy Co'Ltd Inc. All rights reserved.
 * @date 2019年6月20日 下午1:11:53
 */

public interface UserRepository extends CrudRepository<User,Long> {

}
