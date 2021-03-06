create table jira_Field (
	fieldId LONG not null primary key,
	issueId VARCHAR(75) null,
	createdDate DATE null,
	resolutionDate DATE null,
	summary VARCHAR(1000) null,
	updated DATE null,
	timespent LONG,
	timeestimate LONG,
	timeoriginalestimate LONG,
	aggregatetimespent LONG,
	aggregatetimeoriginalestimate LONG,
	aggregatetimeestimate LONG,
	description VARCHAR(1000) null,
	storypoints LONG,
	creatorId VARCHAR(75) null,
	assigneeId VARCHAR(75) null,
	statusId LONG
);

create table jira_Issue (
	issueId VARCHAR(75) not null primary key,
	projectId VARCHAR(75) null,
	key_ VARCHAR(75) null,
	self VARCHAR(75) null
);

create table jira_IssuePriority (
	priorityId LONG not null primary key,
	priorityName VARCHAR(75) null
);

create table jira_IssueType (
	issueTypeId LONG not null primary key,
	typeName VARCHAR(75) null
);

create table jira_JiraUser (
	creatorId VARCHAR(75) not null,
	displayname VARCHAR(75) null,
	groupId VARCHAR(75) not null,
	primary key (creatorId, groupId)
);

create table jira_Project (
	projectId VARCHAR(75) not null primary key,
	key_ VARCHAR(75) null,
	name VARCHAR(75) null
);

create table jira_Status (
	statusId VARCHAR(75) not null primary key,
	name VARCHAR(75) null
);

create table jira_Student (
	studentId LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	studentAge INTEGER,
	studentGender INTEGER,
	studentAddress VARCHAR(75) null
);