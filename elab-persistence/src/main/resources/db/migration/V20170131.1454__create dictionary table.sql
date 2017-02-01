create sequence dictionary_id_seq;
create sequence dictionary_item_id_seq;

create table dictionary (
  id bigint primary key,
  code text,
  name text,
  description text,
  active boolean,
  constraint uq_dictionary_code unique (code)
);

create table dictionary_item (
  id bigint primary key,
  dictionary_id bigint,
  name text,
  active boolean,
  constraint uq_dictionary_item_name unique (name)
);

insert into dictionary(id, code, name, description, active)
values(1, 'KRAJE', 'Kraje', 'Lista krajów', true);

insert into dictionary_item(id, dictionary_id, name, active)
values(1, 1, 'Polska', true);

insert into dictionary_item(id, dictionary_id, name, active)
values(2, 1, 'Niemcy', true);
