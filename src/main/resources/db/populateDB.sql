DELETE FROM calls;
DELETE FROM operators;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO operators (cname, fullname) VALUES
  ('operator1', 'Ivan Nikolaevich Ivanov'),
  ('operator2', 'Anna Ivanovna Petrova');

INSERT INTO calls (REGISTERED, PHONE_NUM, DIRECTION, CUSTOMER, COMMENT, OPERATOR_ID)
VALUES ('2015-05-30 10:00:00', '+7945566675','IN' , 'Pushkina Ntalia Leonidovna', 'Ask work time', 100000),
       ('2015-05-30 13:00:00', '+7945566675', 'OUT', 'Iova Tatyana Petrovna', 'Ask Address', 100000),
       ('2015-05-30 20:00:00', '+7945536675', 'OUT', 'Test Name First', 'Test Note First', 100000),
       ('2015-05-31 0:00:00', '+7945566785', 'IN', 'Test Name Second', 'Test Note Second', 100000),
       ('2015-05-31 10:00:00', '+7945562375','OUT', 'Test Name Third', 'Test Note Third', 100000),
       ('2015-05-31 13:00:00', '+7945566609', 'IN', 'Test Name  Fourth', 'Test Name asked', 100001),
       ('2015-05-31 20:00:00', '+7945566623', 'IN', 'Test Name Fifth', 'Test Name pleased', 100000),
       ('2015-06-01 14:00:00', '+7945545675', 'OUT', 'Test Name Second', 'Test Name cried', 100001),
       ('2015-06-01 21:00:00', '+7945577675', 'OUT', 'Test Name First', 'Test Name called', 100001);

