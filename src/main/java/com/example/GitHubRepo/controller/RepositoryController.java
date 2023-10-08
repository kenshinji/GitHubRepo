package com.example.GitHubRepo.controller;

import com.example.GitHubRepo.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepositoryController {

  @Autowired
  private RepositoryService repositoryService;

  @GetMapping("/top-repositories")
  public String getTopRepositories(
      @RequestParam(required = false) String date,
      @RequestParam(required = false) Integer count,
      @RequestParam(required = false) String language
  ) {
    return repositoryService.getTopRepositories(date, count, language);
  }
}
