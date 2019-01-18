CREATE TABLE IF NOT EXISTS users (
  u_id INT NOT NULL,
  u_name VARCHAR(18) NOT NULL UNIQUE,
  u_passwd  VARCHAR(20) check (len(u_passwd) between 8 and 20),
  PRIMARY KEY (u_id)
);

CREATE TABLE IF NOT EXISTS forms (
  f_id INT NOT NULL,
  f_uid INT NOT NULL,
  f_name VARCHAR(255) NOT NULL,
  f_date TIMESTAMP NOT NULL,
  FOREIGN KEY(f_uid) REFERENCES users(u_id),
  PRIMARY KEY (f_id)
);

CREATE TABLE IF NOT EXISTS questions (
  q_id INT NOT NULL check (q_id>0),
  q_fid INT NOT NULL,
  q_question VARCHAR(8190) NOT NULL,
  q_type INT NOT NULL check (q_type between 0 and 9),
  FOREIGN KEY(q_fid) REFERENCES forms(f_id),
  PRIMARY KEY(q_id,q_fid)
);

CREATE TABLE IF NOT EXISTS choices (
  c_id INT NOT NULL check (c_id>0),
  c_qid INT NOT NULL,
  c_fid INT NOT NULL,
  c_choice VARCHAR(8190) NOT NULL,
  FOREIGN KEY(c_qid) REFERENCES questions(q_id),
  FOREIGN KEY(c_fid) REFERENCES forms(f_id),
  PRIMARY KEY(c_id,c_qid,c_fid)
);

CREATE TABLE IF NOT EXISTS respondents(
  r_id INT NOT NULL,
  r_fid INT NOT NULL,
  r_respondent VARCHAR(255) NOT NULL,
  r_date TIMESTAMP NOT NULL,
  FOREIGN KEY(r_fid) REFERENCES forms(f_id),
  PRIMARY KEY(r_id,r_fid)
);

CREATE TABLE IF NOT EXISTS answers (
  a_qid INT NOT NULL,
  a_fid INT NOT NULL,
  a_rid INT NOT NULL,
  a_answer VARCHAR(8190) NOT NULL,
  FOREIGN KEY(a_qid) REFERENCES questions(q_id),
  FOREIGN KEY(a_rid,a_fid) REFERENCES respondents(r_id,r_fid),
  PRIMARY KEY(a_qid,a_rid,a_fid)
);
