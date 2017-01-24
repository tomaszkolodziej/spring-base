create table profile (
  id bigserial primary key,
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

insert into profile(create_date, create_by, login, password, name, email, active)
values(now(), 1, 'serwis', 'serwis', 'serwis', 'tomasz.kolodziej@poczta.pl', true);
