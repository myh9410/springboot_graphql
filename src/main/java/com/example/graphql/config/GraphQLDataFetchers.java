package com.example.graphql.config;

import com.google.common.collect.ImmutableMap;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of(
                    "id", "book-1",
                    "name", "book1",
                    "pageCount", "1",
                    "authorId", "author-1"),
            ImmutableMap.of(
                    "id", "book-2",
                    "name", "book2",
                    "pageCount", "2",
                    "authorId", "author-2"),
            ImmutableMap.of(
                    "id", "book-3",
                    "name", "book3",
                    "pageCount", "3",
                    "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of(
                    "id", "author-1",
                    "firstName", "author1_f_name",
                    "lastName", "author1_l_name"),
            ImmutableMap.of(
                    "id", "author-2",
                    "firstName", "author2_f_name",
                    "lastName", "author2_l_name"),
            ImmutableMap.of(
                    "id", "author-3",
                    "firstName", "author3_f_name",
                    "lastName", "author3_l_name")
    );

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);

        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");

            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }

}
