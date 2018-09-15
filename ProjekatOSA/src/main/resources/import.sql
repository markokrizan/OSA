INSERT INTO users(name, username, password, photo)
VALUES('Petar Petrovic', 'pekip@gmail.com', 'p123', 'https://eliaslealblog.files.wordpress.com/2014/03/user-200.png'); 

INSERT INTO users(name, username, password, photo)
VALUES('Sava Savanovic', 'savas@gmail.com', 's456', 'https://eliaslealblog.files.wordpress.com/2014/03/user-200.png'); 

INSERT INTO roles(role)
VALUES('ADMINISTRATOR');

INSERT INTO roles(role)
VALUES('OBJAVLJIVAC');

INSERT INTO roles(role)
VALUES('KOMENTATOR');


INSERT INTO user_role(user_id, role_id)
VALUES(1, 1);

INSERT INTO user_role(user_id, role_id)
VALUES(2, 2);


INSERT INTO posts (title, description, photo, post_date, likes, dislikes, longitude, latitude, user_id)
VALUES('RODITELJI KUPANJEM U FONTANI PROSLAVILI POČETAK NOVE ŠKOLSKE GODINE', 'BEOGRAD, 1. septembar 2017, (Njuz) – Više desetina roditelja kupalo se danas u fontani na Trgu Nikole Pašića, čime su proslavili kraj letnjeg raspusta i početak nove školske godine.

Kako saznaje Njuz, najviše je bilo roditelja đaka od prvog do četvrtog razreda Osnovnih škola, koji su skakali u fontanu, prskali se i uzvikivali “Gotovo je!”, “Škola!” i “A sad adio”.', 'https://www.njuz.net/wp-content/uploads/2017/09/fontana.jpg', '2018-04-30', 10, 12, 0.0, 0.0, 1);

INSERT INTO posts (title, description, photo, post_date, likes, dislikes, longitude, latitude, user_id)
VALUES('VUČIĆ: MORAĆEMO DA UVOZIMO PENZIONERE', 'BEOGRAD, 15. avgust 2018, (Njuz) – Predsednik Srbije Aleksandar Vučić najavio je danas da će Srbija zbog svoje ekonomske politike uskoro morati da uvozi penzionere svih profila.

U obraćanju novinarima Vučić je istakao da Srbiji zbog privrednog razvoja u bliskoj budućnosti preti nestašica penzionera, kako onih koji su ispunili uslov za starosnu penziju, tako i onih koji su u penziju otišli na osnovu godina staža.', 'https://www.njuz.net/wp-content/uploads/2018/08/penzioner.jpg', '2018-04-30', 10, 12, 0.0, 0.0, 1);

INSERT INTO posts (title, description, photo, post_date, likes, dislikes, longitude, latitude, user_id)
VALUES('SVI GRAĐANI SRBIJE UZ DINA KARTICU DOBIĆE I BESPLATNU ČLANSKU KARTICU SNS', 'BEOGRAD, 23. avgust 2018, (Njuz) – Narodna banka Srbije poslala je dopis svim bankama koje trenutno posluju u Srbiji da svakom građaninu, uz Dina karticu, izdaju i besplatnu člansku karticu Srpske napredne stranke.

Kako napominju iz NBS, posedovanje ovih kartica je obavezno za sve.', 'https://www.njuz.net/wp-content/uploads/2018/08/sns-clanska.jpg', '2018-04-30', 10, 12, 0.0, 0.0, 1);



INSERT INTO comments(title, description, comment_date, likes, dislikes, post_id, user_id)
VALUES('Zasluzili smo', 'Jedva smo cekali', '2018-04-30', 2, 3, 1, 1);

INSERT INTO tags(name)
VALUES('svet');

INSERT INTO tags(name)
VALUES('srbija');

INSERT INTO tags(name)
VALUES('politika');

INSERT INTO posts_tags(post_id, tag_id)
VALUES(1, 2);

INSERT INTO posts_tags(post_id, tag_id)
VALUES(2, 3);

INSERT INTO posts_tags(post_id, tag_id)
VALUES(3, 3);


