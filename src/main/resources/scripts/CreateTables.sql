CREATE TYPE gender AS ENUM ('man', 'woman');

CREATE TABLE departments(
  id serial PRIMARY KEY,
  name text UNIQUE NOT NULL,
  creation_date date NOT NULL,
  parent_id integer REFERENCES departments(id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE employees(
  id serial PRIMARY KEY,
  first_name text NOT NULL CHECK(first_name ~ '^[а-яА-Я-]+$'),
  last_name text NOT NULL CHECK(last_name ~ '^[а-яА-Я-]+$'),
  father_name text CHECK(father_name ~ '^[а-яА-Я-]+$'),
  empl_gender gender NOT NULL,
  birthday date NOT NULL CHECK(birthday < now()),
  contact_phone text NOT NULL CHECK(contact_phone ~ '^[-0-9+()]+$'),
  email text NOT NULL CHECK(email ~ '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'),
  date_work_start date NOT NULL CHECK(date_work_start > birthday),
  date_work_end date CHECK(date_work_end > date_work_start),
  position text NOT NULL,
  salary integer NOT NULL CHECK(salary > 0),
  department_head boolean NOT NULL DEFAULT false,
  department_id integer REFERENCES departments(id) ON DELETE RESTRICT ON UPDATE CASCADE
);