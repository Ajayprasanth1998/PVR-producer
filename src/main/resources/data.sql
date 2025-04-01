

INSERT INTO cinema (name, location) VALUES ('Lakshmi', 'Arcot');
INSERT INTO cinema (name, location) VALUES ('Alankar', 'Vellore');
INSERT INTO cinema (name, location) VALUES ('Winus', 'Vellore');

insert into movie(title,genre,duration,rating,cinema_id) values ('KUDUMBASTHAN', 'COMEDY', '2h 28m', '8.3', 1);
insert into movie(title,genre,duration,rating,cinema_id) values ('AMARAN', 'ROMANTIC', '2h 45m', '8.8', 1);
insert into movie(title,genre,duration,rating,cinema_id) values ('MANGATHA', 'ACTION', '2h 52m', '9.6', 2);
insert into movie(title,genre,duration,rating,cinema_id) values ('GHILLI', 'ACTION', '2h 57m', '8.6', 2);
insert into movie(title,genre,duration,rating,cinema_id) values ('DRAGON', 'COMEDY', '2h 46m', '8.9', 3);

INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (1, '10:00 AM');
INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (1, '2:00 PM');
INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (1, '6:00 PM');

INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (2, '11:00 AM');
INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (2, '3:00 PM');
INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (2, '7:00 PM');

INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (3, '12:00 AM');
INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (3, '4:00 PM');

INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (4, '12:00 AM');

INSERT INTO movie_showtime (movie_movie_id, showtime) VALUES (5, '10:00 AM');




INSERT INTO clint (user_name, password) VALUES ('Ajay', 'Ajay123');
INSERT INTO clint (user_name, password) VALUES ('Kiruba', 'kiruba123');
INSERT INTO clint (user_name, password) VALUES ('jaffer', 'jaffer123');


INSERT INTO booking (movie_id, cinema_id, clint_id) VALUES (1, 1, 1);
INSERT INTO booking (movie_id, cinema_id, clint_id) VALUES (2, 2, 2);
