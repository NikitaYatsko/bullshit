create table posts(
    id bigserial primary key,
    title varchar(255) not null ,
    content text not null ,
    created timestamp not null default current_timestamp,
    likes int not null default 0,
    unique (title)
);

insert into posts (title, content, created, likes) values
    (
        'first post',
        'This is content of the first post',
        current_timestamp,
        6
    ),
    (
        'second post',
        'This is content of the second post',
        current_timestamp,
        3
    )
