DELETE
FROM identification_document;
DELETE
FROM education_document;
DELETE
FROM students;
ALTER SEQUENCE hibernate_sequence RESTART WITH 100000;

INSERT INTO students (register_id, first_name, last_name, middle_name, email, tel_number, tel_mobile_number, language)
VALUES ('19-40-0001', 'Петя', 'Петров', 'Петрович', 'petrov@gmail.com', '+7(401)200-70-60', '+7(900)800-70-60',
        'Английский'),
       ('19-40-0002', 'Иван', 'Иванов', 'Иванович', 'ivanov@gmail.com', '+7(401)900-80-70', '+7(900)500-40-30',
        'Немецкий');

INSERT INTO identification_document (student_id, document_name, document_series, document_number, date_give_document,
                                     whom_give_document, document_path_disk, location_birth, date_birth, nationality,
                                     number_division, address_registration, residential_address)
VALUES (100000, 'Паспорт', '2715', '568923', '2000-01-15', 'Отделом УФМС Такогото района Такойто обл.',
        'd:\BaseDocument\identification_document\19-40-0001.pdf',
        'город Москва', '1980-01-15', 'Русский', 123456, 'г. Москва ул.Такаято 52-65', 'г. Москва ул.Такаято 52-65'),
       (100001, 'Св-во о рождении', '2415', '854965', '2018-01-15', 'Отделом УФМС Такогото района Такойто обл.',
        'd:\BaseDocument\identification_document\19-40-0002.pdf',
        'город Москва', '2000-01-15', 'Русский', 128956, 'г. Москва ул.Такаято 98-59', 'г. Москва ул.Такаято 98-59');

INSERT INTO education_document (student_id, document_name, document_series, document_number, date_give_document,
                                whom_give_document, document_path_disk, registration_number)
VALUES (100000, 'Диплом', '25648', '2569845', '2010-02-10', 'ГОУСПО Такой то',
        'd:\BaseDocument\education_document\19-40-0001.pdf', ''),
       (100001, 'Аттестат', '', '589659845', '2015-02-10', 'Школа Такая то',
        'd:\BaseDocument\education_document\19-40-0002.pdf', '659');