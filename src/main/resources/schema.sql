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
  address_actual    VARCHAR                           NOT NULL,
  tel_number        VARCHAR,
  tel_mobile_number VARCHAR,
  language          VARCHAR,
  registered        TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON students (email);

CREATE TABLE identification_document
(
  id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  document_id          INTEGER                           NOT NULL,
  document_series      VARCHAR                           NOT NULL,
  document_number      VARCHAR                           NOT NULL,
  date_give_document   TIMESTAMP           DEFAULT now() NOT NULL,
  whom_give_document   VARCHAR                           NOT NULL,
  document_path_disk   VARCHAR,
  location_birth       VARCHAR                           NOT NULL,
  date_birth           TIMESTAMP           DEFAULT now() NOT NULL,
  nationality          VARCHAR                           NOT NULL,
  number_division      INTEGER,
  address_registration VARCHAR                           NOT NULL,
  FOREIGN KEY (document_id) REFERENCES students (id) ON DELETE CASCADE
);

CREATE TABLE education_document
(
  id                  INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  document_id         INTEGER                           NOT NULL,
  document_series     VARCHAR,
  document_number     VARCHAR                           NOT NULL,
  date_give_document  TIMESTAMP           DEFAULT now() NOT NULL,
  whom_give_document  VARCHAR                           NOT NULL,
  document_path_disk  VARCHAR,
  registration_number INTEGER,
  FOREIGN KEY (document_id) REFERENCES students (id) ON DELETE CASCADE
)

-- CREATE TABLE parents
-- (

-- );

-- CREATE TABLE group
-- (
--
-- );

