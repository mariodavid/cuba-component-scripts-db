-- begin DDCSD_SCRIPT
alter table DDCSD_SCRIPT add constraint FK_DDCSD_SCRIPT_ON_CATEGORY foreign key (CATEGORY_ID) references DDCSD_SCRIPT_CATEGORY(ID)^
create index IDX_DDCSD_SCRIPT_ON_CATEGORY on DDCSD_SCRIPT (CATEGORY_ID)^
-- end DDCSD_SCRIPT
-- begin SYS_SCHEDULED_TASK
alter table SYS_SCHEDULED_TASK add constraint FK_SYS_SCHEDULED_TASK_ON_DB_SCRIPT foreign key (DB_SCRIPT_ID) references DDCSD_SCRIPT(ID)^
create index IDX_SYS_SCHEDULED_TASK_ON_DB_SCRIPT on SYS_SCHEDULED_TASK (DB_SCRIPT_ID)^
-- end SYS_SCHEDULED_TASK