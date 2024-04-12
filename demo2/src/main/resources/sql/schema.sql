create table if not exists songs(
  song_id int auto_increment primary key,
  song_title varchar(255),
  song_lyrics text,
  song_created_at datetime default now()
);

create table if not exists users(
  user_id int auto_increment primary key,
  user_name varchar(255),
  user_password varchar(255),
  user_nickname varchar(255)
);

create table if not exists playlists(
  playlist_id int auto_increment primary key,
  playlist_title varchar(255),
  user_id int,
  foreign key (user_id) references users(user_id)
);

create table if not exists song_playlist(
  song_playlist_id int primary key auto_increment,
  playlist_id int,
  song_id int,
  foreign key (song_id) references songs(song_id),
  foreign key (playlist_id) references playlists(playlist_id)
);

-- create index idx_playlist_id on song_playlist(playlist_id);
-- create index idx_song_id on song_playlist(song_id);

create table if not exists comments(
 comment_id int primary key auto_increment,
 comment_content varchar(1024),
 user_id int,
 playlist_id int,
 comment_created_at datetime default now(),
 foreign key (user_id) references users(user_id),
 foreign key (playlist_id) references playlists(playlist_id)
);