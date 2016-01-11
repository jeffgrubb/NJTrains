CREATE TABLE routes (
    route_id bigint not null primary key,
    agency_id varchar(3),
    route_short_name text,
    route_long_name text not null,
    route_type int not null,
    route_url text,
    route_color text
);