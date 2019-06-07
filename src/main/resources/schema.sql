DROP TABLE IF EXISTS identification_document;
DROP TABLE IF EXISTS education_document;
DROP TABLE IF EXISTS students;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE students
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  register_id       VARCHAR                           NOT NULL,
  first_name        VARCHAR                           NOT NULL,
  last_name         VARCHAR                           NOT NULL,
  middle_name       VARCHAR                           NOT NULL,
  email             VARCHAR                           NOT NULL,
  tel_number        VARCHAR                           NOT NULL,
  tel_mobile_number VARCHAR                           NOT NULL,
  language          VARCHAR                           NOT NULL,
  registered        TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_register_id_last_name_idx ON students (register_id, last_name);

CREATE TABLE identification_document
(
  id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  document_id          INTEGER   NOT NULL,
  document_series      VARCHAR   NOT NULL,
  document_number      VARCHAR   NOT NULL,
  date_give_document   TIMESTAMP NOT NULL,
  whom_give_document   VARCHAR   NOT NULL,
  document_path_disk   VARCHAR   NOT NULL,
  location_birth       VARCHAR   NOT NULL,
  date_birth           TIMESTAMP NOT NULL,
  nationality          VARCHAR   NOT NULL,
  number_division      INTEGER   NOT NULL,
  address_registration VARCHAR   NOT NULL,
  residential_address  VARCHAR   NOT NULL,
  FOREIGN KEY (document_id) REFERENCES students (id) ON DELETE CASCADE
);

CREATE TABLE education_document
(
  id                  INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  document_id         INTEGER   NOT NULL,
  document_series     VARCHAR   NOT NULL,
  document_number     VARCHAR   NOT NULL,
  date_give_document  TIMESTAMP NOT NULL,
  whom_give_document  VARCHAR   NOT NULL,
  document_path_disk  VARCHAR   NOT NULL,
  registration_number INTEGER   NOT NULL,
  FOREIGN KEY (document_id) REFERENCES students (id) ON DELETE CASCADE
)

-- CREATE TABLE parents
-- (

-- );

-- CREATE TABLE group
-- (
--
-- );

