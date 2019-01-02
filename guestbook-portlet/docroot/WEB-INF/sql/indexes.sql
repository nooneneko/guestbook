create index IX_F93383D6 on GB_Entry (groupId, guestBookId);
create index IX_94738CBC on GB_Entry (groupId, guestBookId, status);
create index IX_3BD8D300 on GB_Entry (uuid_);
create index IX_B5EF5128 on GB_Entry (uuid_, companyId);
create unique index IX_C1EA01AA on GB_Entry (uuid_, groupId);

create index IX_57276527 on GB_GuestBook (groupId);
create index IX_5E9D8D0D on GB_GuestBook (groupId, status);
create index IX_DB521571 on GB_GuestBook (uuid_);
create index IX_12E2CE17 on GB_GuestBook (uuid_, companyId);
create unique index IX_3E25EE59 on GB_GuestBook (uuid_, groupId);