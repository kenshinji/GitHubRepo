package com.example.GitHubRepo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryServiceTest {

  @Autowired
  private RepositoryService repositoryService;

  @Test
  public void testGetTopRepositories() {
    // You can use assertions here to verify your service logic
    String response = repositoryService.getTopRepositories("2023-10-07", 10, "Java");
    System.out.println(response);
  }
}
