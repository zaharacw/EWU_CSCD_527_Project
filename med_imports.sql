LOAD DATA INFILE 'social_network_data/med/enums/gender.csv' IGNORE 
INTO TABLE social_network_med.GENDER 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/enums/sates.csv' IGNORE 
INTO TABLE social_network_med.STATES 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/enums/topics.csv' IGNORE 
INTO TABLE social_network_med.TOPICS 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/enums/content.csv' IGNORE 
INTO TABLE social_network_med.CONTENT 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/people.csv' IGNORE 
INTO TABLE social_network_med.PEOPLE 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/friends.csv' IGNORE 
INTO TABLE social_network_med.FRIENDS 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/groups.csv' IGNORE 
INTO TABLE social_network_med.GROUPS 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/members.csv' IGNORE 
INTO TABLE social_network_med.MEMBERS 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/posts.csv' IGNORE 
INTO TABLE social_network_med.POSTS 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;

LOAD DATA INFILE 'social_network_data/med/likes.csv' IGNORE 
INTO TABLE social_network_med.LIKES 
FIELDS TERMINATED BY ',' 
IGNORE 1 LINES;
