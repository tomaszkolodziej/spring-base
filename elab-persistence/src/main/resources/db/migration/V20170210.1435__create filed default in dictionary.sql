alter table dictionary add column default_item_id bigint default null references dictionary_item (id) on update cascade on delete restrict;
