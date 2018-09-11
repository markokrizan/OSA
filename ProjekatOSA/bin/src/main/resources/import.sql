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
VALUES('Neka vest', 'Neka vest(FOTO)(VIDEO)', 'http://europeanscoutfoundation.com/wp-content/uploads/2018/02/newspaper-1.jpg', '2018-04-30', 10, 12, 0.0, 0.0, 1);

INSERT INTO comments(title, description, comment_date, likes, dislikes, post_id, user_id)
VALUES('Neki komentar', 'Tekst nekog komentara', '2018-04-30', 2, 3, 1, 1);

INSERT INTO tags(name)
VALUES('svet');

INSERT INTO tags(name)
VALUES('srbija');

INSERT INTO posts_tags(post_id, tag_id)
VALUES(1, 1);

INSERT INTO posts_tags(post_id, tag_id)
VALUES(1, 2);


