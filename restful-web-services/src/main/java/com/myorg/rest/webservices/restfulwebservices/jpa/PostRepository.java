package com.myorg.rest.webservices.restfulwebservices.jpa;

import com.myorg.rest.webservices.restfulwebservices.post.Post;
import com.myorg.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
