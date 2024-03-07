create table aut_autorizacao (
  aut_id serial primary key,
  aut_nome varchar(20) not null
);

create table uau_usuario_autorizacao (
  usr_id int not null,
  aut_id int not null,
  primary key (usr_id, aut_id),
  foreign key (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_anotacao (
  ant_id serial primary key,
  ant_texto varchar(256) not null,
  ant_data_hora timestamp not null,
  ant_usr_id int,
  foreign key (ant_usr_id) references usr_usuario(usr_id)
);