package com.example.GitHubRepo.service;

import com.example.GitHubRepo.client.GitHubApiClient;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {

  @Autowired
  private GitHubApiClient gitHubApiClient;

  public String getTopRepositories(String date, Integer count, String language) {
    if (date == null || date.isEmpty()) {
      date = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    if (count == null) {
      count = 10;  // defaulting to 10 if not provided
    }

    String query = "?q=created:" + date;

    if (language != null && !language.isEmpty()) {
      query += "+language:" + language;
    }

    query += "&sort=stars&order=desc&per_page=" + count;

    return gitHubApiClient.fetchRepositories(query);
  }

}
