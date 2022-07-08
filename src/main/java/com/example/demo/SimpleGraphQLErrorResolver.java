package com.example.demo;

import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

@Component
public class SimpleGraphQLErrorResolver extends DataFetcherExceptionResolverAdapter {
  @Override
  public GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
    if (ex instanceof GraphQLError) {
      return (GraphQLError) ex;
    }
    return null;
  }
}
