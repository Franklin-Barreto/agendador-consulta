    create table endereco (
       id integer generated by default as identity,
        cidade varchar(255),
        numero varchar(255),
        rua varchar(255),
        primary key (id)
    )
