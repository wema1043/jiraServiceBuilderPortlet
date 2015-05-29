create table jira_Field (
	fieldId LONG not null primary key,
	createdDate DATE null,
	resolutionDate DATE null,
	summary VARCHAR(75) null,
	updated DATE null,
	creatorId LONG,
	assigneeId LONG,
	statusId LONG
);

create table jira_Issue (
	issueId LONG not null primary key,
	id_ VARCHAR(75) null,
	key_ VARCHAR(75) null,
	self VARCHAR(75) null,
	fieldId LONG
);

create table jira_JiraUser (
	creatorId VARCHAR(75) not null primary key,
	displayname VARCHAR(75) null
);

create table jira_Status (
	statusId LONG not null primary key,
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