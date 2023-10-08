package com.example.GitHubRepo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubApiClient {

  public static final String GITHUB_REPO_SEARCH_URL = "https://api.github.com/search/repositories";
  private final RestTemplate restTemplate;

  public GitHubApiClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String fetchRepositories(String query) {
    // Existing code using restTemplate
    return restTemplate.getForObject(GITHUB_REPO_SEARCH_URL + query, String.class);
  }
}

