INSERT INTO departments(name, creation_date, parent_id)
VALUES ('head_department', '2019-05-09', null);

INSERT INTO departments(name, creation_date, parent_id)
VALUES
  ('department_1', '2019-05-09', (SELECT id FROM departments WHERE name = 'head_department')),
  ('department_2', '2019-05-09', (SELECT id FROM departments WHERE name = 'head_department'));

INSERT INTO departments(name, creation_date, parent_id)
VALUES
  ('department_3', '2019-05-09', (SELECT id FROM departments WHERE name = 'department_2'));