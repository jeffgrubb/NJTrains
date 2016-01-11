CREATE TABLE stop_times (
    stop_time_id serial not null primary key,
    trip_id bigint not null,
    arrival_time time not null,
    departure_time time not null,
    stop_id bigint not null,
    stop_sequence bigint not null,
    pickup_type bigint not null,
    drop_off_type bigint not null,
    shape_distance_traveled real not null
);