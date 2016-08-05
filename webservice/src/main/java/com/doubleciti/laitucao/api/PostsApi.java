package com.doubleciti.laitucao.api;

import com.doubleciti.laitucao.model.PostModel;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Api(value = "posts", description = "the posts API")
public interface PostsApi {

    @ApiOperation(value = "List all posts", notes = "List all posts. ", response = PostModel.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "An array of products", response = PostModel.class),
        @ApiResponse(code = 200, message = "Unexpected error", response = PostModel.class) })
    @RequestMapping(value = "/posts",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<PostModel>> postsGet();


    @ApiOperation(value = "Get one post", notes = "", response = Object.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed to get a post", response = Object.class) })
    @RequestMapping(value = "/posts/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> postsIdGet(@ApiParam(value = "",required=true ) @PathVariable("id") Long id);


    @ApiOperation(value = "Update a post", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "updated", response = Void.class) })
    @RequestMapping(value = "/posts/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> postsIdPut(@ApiParam(value = "",required=true ) @PathVariable("id") Long id);


    @ApiOperation(value = "Create a post", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created", response = Void.class) })
    @RequestMapping(value = "/posts",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postsPost();

}
