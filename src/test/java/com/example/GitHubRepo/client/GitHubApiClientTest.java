package com.example.GitHubRepo.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static com.example.GitHubRepo.client.GitHubApiClient.GITHUB_REPO_SEARCH_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GitHubApiClientTest {

  @Mock
  private RestTemplate restTemplate;

  @InjectMocks
  private GitHubApiClient client;

  @Test
  public void testFetchRepositories() {
    // Setup mock response
    String query = "q=created:2019-01-10&sort=stars&order=desc";
    when(restTemplate.getForObject(anyString(), eq(String.class)))
        .thenReturn("{\"items\": []}");

    String actualResponse = client.fetchRepositories(query);

    // Verify that restTemplate's getForObject was called once
    verify(restTemplate, times(1))
        .getForObject(GITHUB_REPO_SEARCH_URL + query, String.class);
  }
}
