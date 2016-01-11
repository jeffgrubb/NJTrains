CREATE TABLE shapes (
    shape_pk serial not null primary key,
    shape_id bigint not null,
    shape_sequence bigint not null,
    shape_pt_lat real not null,
    shape_pt_lon real not null,
    shape_dist_traveled real not null
);