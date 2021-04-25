DROP TABLE tasks IF EXISTS;

CREATE TABLE tasks (
  id         INTEGER IDENTITY PRIMARY KEY,
  task_name VARCHAR(64) NOT NULL,
  time_spent VARCHAR(64),
  task_group VARCHAR(64) NOT NULL,
  assignee VARCHAR(64) NOT NULL,
  finished BOOLEAN NOT NULL
);