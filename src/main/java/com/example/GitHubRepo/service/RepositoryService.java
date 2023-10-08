package com.example.GitHubRepo.service;

import com.example.GitHubRepo.client.GitHubApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {

  @Autowired
  private GitHubApiClient gitHubApiClient;

  public String getTopRepositories(String date, int count, String language) {
    String query = "?q=created:" + date + (language != null ? "+language:" + language : "") + "&sort=stars&order=desc&per_page=" + count;
    return gitHubApiClient.fetchRepositories(query);
  }
}
