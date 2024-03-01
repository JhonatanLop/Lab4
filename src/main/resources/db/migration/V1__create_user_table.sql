CREATE TABLE IF NOT EXISTS usr_usuario(
    usr_id int primary key,
    usr_name varchar(20),
    usr_password varchar(100)
);

create sequence usr_usuario_id_seq START 1 increment 1;
alter table usr_usuario alter column usr_id set default nextval('usr_usuario_id_seq');