package com.myorg.rest.webservices.restfulwebservices.user;

import com.myorg.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.myorg.rest.webservices.restfulwebservices.jpa.UserRepository;
import com.myorg.rest.webservices.restfulwebservices.post.Post;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
public class UserJpaResource {
    private static final Logger logger = LoggerFactory.getLogger(UserJpaResource.class);
    private UserDAOService service;
    private UserRepository repository;
    private PostRepository postRepository;

    public UserJpaResource( UserRepository repository, PostRepository postRepository){
//        this.service = userDAOService;
        this.repository = repository;
        this.postRepository = postRepository;

    }
    @GetMapping("/jpa/users")
    public List<User> retriveAllUser(){
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retriveOneUser(@PathVariable int id){

        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id : " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUser());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//        logger.info("Received request body: " + user.toString());
        User savedUser = repository.save(user);
         URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteOneUser(@PathVariable int id){

       repository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrivePostsForUser(@PathVariable int id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id : " + id);
        }
        return user.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostsForUser(@PathVariable int id, @Valid @RequestBody Post post){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id : " + id);
        }
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();


        return ResponseEntity.created(location).build();
    }
}
