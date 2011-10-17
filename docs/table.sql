
create table comment (
  id               text not null primary key,
  target           text not null default '',
  name             text not null default '',
  comment          text not null,
  password         text,
  remote_host      text not null default '',
  tag              text not null default '',
  url              text not null default '',
  make_date        timestamp not null default now()
);
create index comment_target_idx on comment(target);

