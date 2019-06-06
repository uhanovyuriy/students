DROP TABLE IF EXISTS students;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE students
(
  id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  register_id          INTEGER                           NOT NULL,
  first_name           VARCHAR                           NOT NULL,
  last_name            VARCHAR                           NOT NULL,
  middle_name          VARCHAR                           NOT NULL,
  email                VARCHAR                           NOT NULL,
  location_birth       VARCHAR                           NOT NULL,
  date_birth           TIMESTAMP           DEFAULT now() NOT NULL,
  nationality          VARCHAR                           NOT NULL,
  document             VARCHAR                           NOT NULL,
  document_number      VARCHAR                           NOT NULL,
  date_give_document   TIMESTAMP           DEFAULT now() NOT NULL,
  whom_give_document   VARCHAR                           NOT NULL,
  address_registration VARCHAR                           NOT NULL,
  address_actual       VARCHAR                           NOT NULL,
  tel_number           VARCHAR                           NOT NULL,
  tel_mobile_number    VARCHAR                           NOT NULL,
  registered           TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON students (email);

-- CREATE TABLE parents
-- (

-- );

-- CREATE TABLE group
-- (
--
-- );

