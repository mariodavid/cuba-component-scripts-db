-- begin DDCSD_SCRIPT
create table DDCSD_SCRIPT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CATEGORY_ID varchar(36),
    CODE varchar(255) not null,
    DESCRIPTION longvarchar,
    CONTENT longvarchar not null,
    --
    primary key (ID)
)^
-- end DDCSD_SCRIPT
-- begin DDCSD_SCRIPT_CATEGORY
create table DDCSD_SCRIPT_CATEGORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CODE varchar(255) not null,
    --
    primary key (ID)
)^
-- end DDCSD_SCRIPT_CATEGORY
-- begin SYS_SCHEDULED_TASK
alter table SYS_SCHEDULED_TASK add column DB_SCRIPT_ID varchar(36) ^
alter table SYS_SCHEDULED_TASK add column DTYPE varchar(100) ^
update SYS_SCHEDULED_TASK set DTYPE = 'ddcsd$DbScriptScheduledTask' where DTYPE is null ^
-- end SYS_SCHEDULED_TASK
