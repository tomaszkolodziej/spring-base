create sequence profile_id_seq;

create table profile (
  id bigint primary key,
  create_date timestamp,
  create_by int,
  update_date timestamp,
  update_by int,
  login text unique,
  password text,
  name text,
  first_name text,
  last_name text,
  email text unique,
  active boolean
);

insert into profile(id, create_date, create_by, login, password, name, email, active)
values(1, now(), 1, 'serwis', 'serwis', 'serwis', 'tomasz.kolodziej@poczta.pl', true);
