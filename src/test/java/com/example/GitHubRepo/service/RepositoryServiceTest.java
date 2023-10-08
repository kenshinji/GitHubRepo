package com.example.GitHubRepo.service;

import com.example.GitHubRepo.client.GitHubApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RepositoryServiceTest {

  @Mock
  private GitHubApiClient gitHubApiClient;

  @InjectMocks
  private RepositoryService repositoryService;

  @BeforeEach
  public void setUp() {
    // Mocking a default response for the API client
    when(gitHubApiClient.fetchRepositories(anyString())).thenReturn("{\"items\": []}");
  }

  @Test
  public void testDefaultDateAndTop() {
    repositoryService.getTopRepositories(null, null, "Java");

    String expectedDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    verify(gitHubApiClient, times(1))
        .fetchRepositories("?q=created:" + expectedDate + "+language:Java&sort=stars&order=desc&per_page=10");
  }

  @Test
  public void testProvidedDateAndDefaultTop() {
    repositoryService.getTopRepositories("2023-10-01", null, "Java");

    verify(gitHubApiClient, times(1))
        .fetchRepositories("?q=created:2023-10-01+language:Java&sort=stars&order=desc&per_page=10");
  }

  @Test
  public void testDefaultDateAndProvidedTop() {
    repositoryService.getTopRepositories(null, 50, "Java");

    String expectedDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    verify(gitHubApiClient, times(1))
        .fetchRepositories("?q=created:" + expectedDate + "+language:Java&sort=stars&order=desc&per_page=50");
  }

  @Test
  public void testAllParametersProvided() {
    repositoryService.getTopRepositories("2023-10-01", 50, "Java");

    verify(gitHubApiClient, times(1))
        .fetchRepositories("?q=created:2023-10-01+language:Java&sort=stars&order=desc&per_page=50");
  }
}
