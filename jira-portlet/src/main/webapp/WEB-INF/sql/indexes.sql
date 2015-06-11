create index IX_6F1D4F4D on jira_Field (assigneeId);
create index IX_52019455 on jira_Field (issueId);
create index IX_A82A6830 on jira_Field (statusId);
create index IX_90BD37D4 on jira_Field (statusId, issueId);

create index IX_3DB73B16 on jira_Issue (issueId);
create index IX_305C3956 on jira_Issue (projectId);

create index IX_CA68C5CD on jira_JiraUser (displayname);

create index IX_B82DF482 on jira_Project (key_);

create index IX_769D05C8 on jira_Status (name);

create index IX_18095CBC on jira_Student (studentGender);