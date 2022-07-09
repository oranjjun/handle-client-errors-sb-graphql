package com.example.demo;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class SimpleGraphQLErrorResolver extends DataFetcherExceptionResolverAdapter {
  @Override
  public GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof GraphQLError) {
      GraphQLError error = (GraphQLError) ex;
      return GraphqlErrorBuilder.newError(env)
          .message(error.getMessage())
          .errorType(error.getErrorType())
          .build();
    }
    return null;
  }
}
