DROP TABLE IF EXISTS call_directions;
DROP TABLE IF EXISTS calls;
DROP TABLE IF EXISTS operators;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE operators
(
  id                INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  cname             VARCHAR(255)            NOT NULL UNIQUE,
  fullname          VARCHAR(255)            NOT NULL

);
CREATE UNIQUE INDEX operators_unique_fullname_idx
  ON operators (cname, fullname);

CREATE TABLE calls
(
  id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  registered      TIMESTAMP DEFAULT now() NOT NULL,
  phone_num       VARCHAR(255) NOT NULL,
  direction       VARCHAR(255) NOT NULL,
  customer        VARCHAR(255) NOT NULL,
  comment         VARCHAR(255) NOT NULL,
  operator_id     INTEGER      NOT NULL,
  FOREIGN KEY (operator_id) REFERENCES operators (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX calls_unique_operator_registered_idx
  ON calls (operator_id, registered);

