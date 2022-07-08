package com.example.demo;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.graphql.execution.ErrorType;

import java.util.List;

public class CustomException extends RuntimeException implements GraphQLError {
  private final ErrorType errorType;

  public CustomException(String message, ErrorType errorType) {
    super(message);
    this.errorType = errorType;
  }

  @Override
  public ErrorClassification getErrorType() {
    return errorType;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }
}
