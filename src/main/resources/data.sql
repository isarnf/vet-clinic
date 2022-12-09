insert into veterinarios (id, nome, cpf, crmv, email, senha) values (1, 'Isabela', '123.456.789-00', 'CRMV01', 'isa@gmail.com', '123');
insert into veterinarios (id, nome, cpf, crmv, email, senha) values (2, 'Lucas', '987.654.321-00', 'CRMV02', 'lucas@gmail.com', '456');

insert into animais (id, nome, especie, data_nascimento, sexo, peso, raca) values (1, 'Rex', 'Canis lupus familiaris', parsedatetime('03-05-2018','dd-MM-yyyy'), 'macho', 8.5, 'Vira-lata');
insert into animais (id, nome, especie, data_nascimento, sexo, peso, raca) values (2, 'Nina', 'Felis catus', parsedatetime('29-12-2021','dd-MM-yyyy'), 'fêmea', 4.2, 'Persa');

insert into clientes (id, cpf, nome, telefone, email) values (1, '111.111.111-11', 'Marília dos Santos', '(16) 99921-1111', 'marilia@gmail.com');
insert into clientes (id, cpf, nome, telefone, email) values (2, '222.222.222-22', 'Roberto Carvalho', '(16) 99972-2222', 'rc@gmail.com');

-- insert into consultas (id, animal_id, veterinario_id, data_horario, status) values ('consulta01', 1, 1, '2022-06-05T10:20:40.431Z', 'ABERTO');
-- insert into consultas (id, animal_id, veterinario_id, data_horario, status) values ('consulta02', 2, 2, '2022-08-24T14:35:00.526Z', 'ABERTO');

    