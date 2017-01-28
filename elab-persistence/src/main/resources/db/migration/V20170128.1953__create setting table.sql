create sequence setting_id_seq;

create table setting (
  id bigint primary key,
  owner_id bigint not null,
  code text,
  name text,
  description text,
  value_type text,
  value text,
  constraint uq_setting_code unique (code),
  constraint fk_setting_owner_id foreign key (owner_id) references profile on delete cascade
);

insert into setting(id, owner_id, code, name, description, value_type, value)
values(1, 1, 'ODBIERANIE_WIADOMOSCI_EMAIL', 'Odbieranie wiadomości e-mail',
  'Określ, czy chcesz otrzymywać wiadomości e-mail z serwisu.',
  'BOOLEAN', 'true');
