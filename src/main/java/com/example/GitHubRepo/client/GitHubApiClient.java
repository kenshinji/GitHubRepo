package com.example.GitHubRepo.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GitHubApiClient {

  private static final String GITHUB_API_URL = "https://api.github.com/search/repositories";

  public String fetchRepositories(String query) {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.getForObject(GITHUB_API_URL + query, String.class);
  }
}
