create table BB_Author (
	uuid_ VARCHAR(75) null,
	authorId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null
);

create table BB_Book (
	uuid_ VARCHAR(75) null,
	bookId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	cost INTEGER,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	authorId LONG
);

create table BB_Borrower (
	uuid_ VARCHAR(75) null,
	borrowerId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	address VARCHAR(75) null,
	city VARCHAR(75) null,
	email VARCHAR(75) null,
	PhoneNo VARCHAR(75) null
);

create table BB_Loan (
	uuid_ VARCHAR(75) null,
	loanId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dateStart DATE null,
	dateFinish DATE null,
	borrowerId LONG,
	bookId LONG
);