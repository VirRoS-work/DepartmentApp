INSERT INTO employees(first_name, last_name, father_name, empl_gender, birthday, contact_phone, email,
  date_work_start, date_work_end, "position", salary, department_head, department_id)
VALUES
  ('Федор', 'Романов', 'Иванович', 'man', '1992-05-18', '+7(123)-456-78-90', 'romanov@gmail.com', '2018-05-18',
    NULL , 'Руководитель отдела', 50000, TRUE, (SELECT id FROM departments WHERE name = 'head_department')),
  ('Иван', 'Бонкарев', 'Сергеевич', 'man', '1992-01-14', '+7(123)-456-55-44', 'bonkarev@gmail.com', '2018-05-18',
    '2019-02-02', 'Бухгалтер', 40000, FALSE, (SELECT id FROM departments WHERE name = 'head_department')),
  ('Ирина', 'Ванлова', 'Владимировна', 'woman', '1999-11-02', '+7(123)-456-55-55', 'vanlova@gmail.com', '2018-05-18',
    NULL, 'Менеджер', 30000, FALSE, (SELECT id FROM departments WHERE name = 'head_department')),
  ('Егор', 'Варников', NULL, 'man', '1997-05-17', '+7(121)-555-55-55', 'varnikov@gmail.com', '2019-05-10',
    NULL, 'Руководитель отдела', 60000, TRUE, (SELECT id FROM departments WHERE name = 'department_1'));