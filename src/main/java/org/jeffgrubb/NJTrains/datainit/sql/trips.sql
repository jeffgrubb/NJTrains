CREATE TABLE trips (
    trip_id bigint not null primary key,
    route_id bigint not null,
    service_id bigint not null,
    trip_headsign text not null,
    direction_id bigint not null,
    block_id text not null,
    shape_id bigint not null
);