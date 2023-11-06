
create database vslpdv;

create table clientes (
	id serial primary key,
  nome varchar(255) not null,
  email varchar(255) unique not null,
  cpf varchar(11) not null,
  cep varchar(8) not null
);
