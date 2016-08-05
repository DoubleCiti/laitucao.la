package com.doubleciti.laitucao.api;

import com.doubleciti.laitucao.model.PostModel;
import com.doubleciti.laitucao.service.PostService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin
@Controller(value = "Posts API")
@RequestMapping(value = "/v1")
public class PostsApiController implements PostsApi {
    private PostService postService;

    @Autowired
    public PostsApiController(PostService postService) {
        this.postService = postService;
    }

    public ResponseEntity<List<PostModel>> postsGet() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    public ResponseEntity<Object> postsIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    public ResponseEntity<Void> postsIdPut(@ApiParam(value = "",required=true ) @PathVariable("id") Long id) {
        // do some magic!
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postsPost() {
        // do some magic!
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
