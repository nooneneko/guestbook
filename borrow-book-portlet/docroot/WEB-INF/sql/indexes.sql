create index IX_3ACFADA on BB_Author (groupId);
create index IX_83977BE4 on BB_Author (uuid_);
create index IX_3A2EF1C4 on BB_Author (uuid_, companyId);
create unique index IX_13911946 on BB_Author (uuid_, groupId);

create index IX_59FAEEFC on BB_Book (groupId);
create index IX_E23D8976 on BB_Book (groupId, authorId);
create index IX_5FB81086 on BB_Book (uuid_);
create index IX_1C1483E2 on BB_Book (uuid_, companyId);
create unique index IX_E7509AE4 on BB_Book (uuid_, groupId);

create index IX_6D6F2E63 on BB_Borrower (groupId);
create index IX_2632FDAD on BB_Borrower (uuid_);
create index IX_783A85B on BB_Borrower (uuid_, companyId);
create unique index IX_FF00899D on BB_Borrower (uuid_, groupId);

create index IX_E877AA95 on BB_Loan (groupId);
create index IX_F01E2DED on BB_Loan (groupId, bookId);
create index IX_AD1A97BE on BB_Loan (groupId, bookId, borrowerId);
create index IX_E5165866 on BB_Loan (groupId, borrowerId);
create index IX_6930DE5F on BB_Loan (uuid_);
create index IX_BE9EC469 on BB_Loan (uuid_, companyId);
create unique index IX_E6AF512B on BB_Loan (uuid_, groupId);