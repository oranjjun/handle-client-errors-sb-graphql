package com.example.demo;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class Query {

  @QueryMapping
  public List<String> allBook() {
    throw new CustomException("simulate bad request", ErrorType.BAD_REQUEST);
  }
}
