-- rolesテーブル (role_idは自動連番なので指定しない)
INSERT INTO roles (role_name) VALUES
  ('ROLE_GENERAL'),
  ('ROLE_ADMIN');

-- usersテーブル (user_idは指定しない。role_idは1と2が自動で割り振られる前提)
INSERT INTO users (user_name, password, role_id) VALUES
  ('侍 太郎', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 1),
  ('侍 花子', '$2a$10$2JNjTwZBwo7fprL2X4sv.OEKqxnVtsVQvuXDkI8xVGix.U3W5B7CO', 2),
  ('侍 義勝', 'password', 1),
  ('侍 幸美', 'password', 1),
  ('侍 雅', 'password', 1);