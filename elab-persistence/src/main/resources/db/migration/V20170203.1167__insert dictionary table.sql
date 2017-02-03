insert into dictionary(id, code, name, description, active)
values(2, 'WOJEWÓDZTWA', 'Województwa', 'Lista województw', true);

insert into dictionary_item(id, dictionary_id, name, active)
values(3, 2, 'Podkarpackie', true);

insert into dictionary_item(id, dictionary_id, name, active)
values(4, 2, 'Mazowieckie', true);
