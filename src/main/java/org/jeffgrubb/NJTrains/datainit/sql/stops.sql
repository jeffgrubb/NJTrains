CREATE TABLE stops (
    stop_id bigint not null primary key,
    stop_code bigint not null,
    stop_name text not null,
    stop_desc text,
    stop_lat real not null,
    stop_lon real not null,
    zone_id bigint not null
);