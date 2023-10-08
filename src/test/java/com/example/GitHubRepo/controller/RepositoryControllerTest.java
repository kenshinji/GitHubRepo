package com.example.GitHubRepo.controller;

import com.example.GitHubRepo.service.RepositoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RepositoryControllerTest {

  @Mock
  private RepositoryService repositoryService;

  @InjectMocks
  private RepositoryController repositoryController;

  @Test
  public void testGetTopRepositories() {
    // Setup mock response
    String date = "2023-01-01";
    int count = 10;
    String language = "Java";
    String expectedResponse = "{\n" +
        "   \"total_count\":5963,\n" +
        "   \"incomplete_results\":false,\n" +
        "   \"items\":[\n" +
        "      {\n" +
        "         \"id\":701644783,\n" +
        "         \"node_id\":\"R_kgDOKdI_7w\",\n" +
        "         \"name\":\"Andrade-S-DES\",\n" +
        "         \"full_name\":\"SealParadise/Andrade-S-DES\",\n" +
        "         \"private\":false,\n" +
        "         \"owner\":{\n" +
        "            \"login\":\"SealParadise\",\n" +
        "            \"id\":55354243,\n" +
        "            \"node_id\":\"MDQ6VXNlcjU1MzU0MjQz\",\n" +
        "            \"avatar_url\":\"https://avatars.githubusercontent.com/u/55354243?v=4\",\n" +
        "            \"gravatar_id\":\"\",\n" +
        "            \"url\":\"https://api.github.com/users/SealParadise\",\n" +
        "            \"html_url\":\"https://github.com/SealParadise\",\n" +
        "            \"followers_url\":\"https://api.github.com/users/SealParadise/followers\",\n" +
        "            \"following_url\":\"https://api.github.com/users/SealParadise/following{/other_user}\",\n" +
        "            \"gists_url\":\"https://api.github.com/users/SealParadise/gists{/gist_id}\",\n" +
        "            \"starred_url\":\"https://api.github.com/users/SealParadise/starred{/owner}{/repo}\",\n" +
        "            \"subscriptions_url\":\"https://api.github.com/users/SealParadise/subscriptions\",\n" +
        "            \"organizations_url\":\"https://api.github.com/users/SealParadise/orgs\",\n" +
        "            \"repos_url\":\"https://api.github.com/users/SealParadise/repos\",\n" +
        "            \"events_url\":\"https://api.github.com/users/SealParadise/events{/privacy}\",\n" +
        "            \"received_events_url\":\"https://api.github.com/users/SealParadise/received_events\",\n" +
        "            \"type\":\"User\",\n" +
        "            \"site_admin\":false\n" +
        "         },\n" +
        "         \"html_url\":\"https://github.com/SealParadise/Andrade-S-DES\",\n" +
        "         \"description\":\"This program is developed based on the S-DES algorithm discussed in the 5th lecture of the \\\"Introduction to Information Security\\\" course, with the aim of helping students grasp the core principles of encryption algorithms so that they can understand the importance of information security and how to protect data.\",\n" +
        "         \"fork\":false,\n" +
        "         \"url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES\",\n" +
        "         \"forks_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/forks\",\n" +
        "         \"keys_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/keys{/key_id}\",\n" +
        "         \"collaborators_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/collaborators{/collaborator}\",\n" +
        "         \"teams_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/teams\",\n" +
        "         \"hooks_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/hooks\",\n" +
        "         \"issue_events_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/issues/events{/number}\",\n" +
        "         \"events_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/events\",\n" +
        "         \"assignees_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/assignees{/user}\",\n" +
        "         \"branches_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/branches{/branch}\",\n" +
        "         \"tags_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/tags\",\n" +
        "         \"blobs_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/git/blobs{/sha}\",\n" +
        "         \"git_tags_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/git/tags{/sha}\",\n" +
        "         \"git_refs_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/git/refs{/sha}\",\n" +
        "         \"trees_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/git/trees{/sha}\",\n" +
        "         \"statuses_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/statuses/{sha}\",\n" +
        "         \"languages_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/languages\",\n" +
        "         \"stargazers_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/stargazers\",\n" +
        "         \"contributors_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/contributors\",\n" +
        "         \"subscribers_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/subscribers\",\n" +
        "         \"subscription_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/subscription\",\n" +
        "         \"commits_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/commits{/sha}\",\n" +
        "         \"git_commits_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/git/commits{/sha}\",\n" +
        "         \"comments_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/comments{/number}\",\n" +
        "         \"issue_comment_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/issues/comments{/number}\",\n" +
        "         \"contents_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/contents/{+path}\",\n" +
        "         \"compare_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/compare/{base}...{head}\",\n" +
        "         \"merges_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/merges\",\n" +
        "         \"archive_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/{archive_format}{/ref}\",\n" +
        "         \"downloads_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/downloads\",\n" +
        "         \"issues_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/issues{/number}\",\n" +
        "         \"pulls_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/pulls{/number}\",\n" +
        "         \"milestones_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/milestones{/number}\",\n" +
        "         \"notifications_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/notifications{?since,all,participating}\",\n" +
        "         \"labels_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/labels{/name}\",\n" +
        "         \"releases_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/releases{/id}\",\n" +
        "         \"deployments_url\":\"https://api.github.com/repos/SealParadise/Andrade-S-DES/deployments\",\n" +
        "         \"created_at\":\"2023-10-07T06:32:19Z\",\n" +
        "         \"updated_at\":\"2023-10-07T14:17:33Z\",\n" +
        "         \"pushed_at\":\"2023-10-07T15:00:38Z\",\n" +
        "         \"git_url\":\"git://github.com/SealParadise/Andrade-S-DES.git\",\n" +
        "         \"ssh_url\":\"git@github.com:SealParadise/Andrade-S-DES.git\",\n" +
        "         \"clone_url\":\"https://github.com/SealParadise/Andrade-S-DES.git\",\n" +
        "         \"svn_url\":\"https://github.com/SealParadise/Andrade-S-DES\",\n" +
        "         \"homepage\":\"\",\n" +
        "         \"size\":3174,\n" +
        "         \"stargazers_count\":15,\n" +
        "         \"watchers_count\":15,\n" +
        "         \"language\":\"Java\",\n" +
        "         \"has_issues\":true,\n" +
        "         \"has_projects\":true,\n" +
        "         \"has_downloads\":true,\n" +
        "         \"has_wiki\":true,\n" +
        "         \"has_pages\":false,\n" +
        "         \"has_discussions\":false,\n" +
        "         \"forks_count\":0,\n" +
        "         \"mirror_url\":null,\n" +
        "         \"archived\":false,\n" +
        "         \"disabled\":false,\n" +
        "         \"open_issues_count\":0,\n" +
        "         \"license\":{\n" +
        "            \"key\":\"gpl-3.0\",\n" +
        "            \"name\":\"GNU General Public License v3.0\",\n" +
        "            \"spdx_id\":\"GPL-3.0\",\n" +
        "            \"url\":\"https://api.github.com/licenses/gpl-3.0\",\n" +
        "            \"node_id\":\"MDc6TGljZW5zZTk=\"\n" +
        "         },\n" +
        "         \"allow_forking\":true,\n" +
        "         \"is_template\":false,\n" +
        "         \"web_commit_signoff_required\":false,\n" +
        "         \"topics\":[\n" +
        "            \n" +
        "         ],\n" +
        "         \"visibility\":\"public\",\n" +
        "         \"forks\":0,\n" +
        "         \"open_issues\":0,\n" +
        "         \"watchers\":15,\n" +
        "         \"default_branch\":\"main\",\n" +
        "         \"score\":1.0\n" +
        "      }\n" +
        "   ]\n" +
        "}";
    when(repositoryService.getTopRepositories(anyString(), anyInt(), anyString()))
        .thenReturn(expectedResponse);

    repositoryController.getTopRepositories(date, count, language);

    // Verify that RepositoryService's method was called once
    verify(repositoryService, times(1)).getTopRepositories(date, count, language);
  }
}
