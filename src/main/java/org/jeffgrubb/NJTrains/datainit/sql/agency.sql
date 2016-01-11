CREATE TABLE agency (
    agency_id varchar(3) not null primary key,
    agency_name text not null,
    agency_url text not null,
    agency_timezone text not null,
    agency_lang text not null,
    agency_phone text
);