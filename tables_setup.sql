CREATE TABLE IF NOT EXISTS CONTENT (
	id TINYINT NOT NULL,
	name VARCHAR(5) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS TOPICS (
	id TINYINT NOT NULL,
	name VARCHAR(10) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS GENDER (
	id TINYINT NOT NULL,
	abv CHAR(1) NOT NULL,
	name VARCHAR(6) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS STATES (
	id TINYINT NOT NULL,
	name VARCHAR(15) NOT NULL,
	abv CHAR(2) NOT NULL, 
	PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS PEOPLE (
	id INT NOT NULL,
	first_name VARCHAR(15) NOT NULL,
	last_name VARCHAR(15) NOT NULL,
	state_id TINYINT NOT NULL,
	birthday DATE NOT NULL,
	age TINYINT NOT NULL,
	gender_id TINYINT NOT NULL,
	account_created_date DATE NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (state_id) REFERENCES STATES(id),
	FOREIGN KEY (gender_id) REFERENCES GENDER(id)
);

CREATE TABLE IF NOT EXISTS FRIENDS (
	id1 INT NOT NULL,
	id2 INT NOT NULL, 
	friended_on DATE NOT NULL,
	PRIMARY KEY (id1, id2),
	FOREIGN KEY (id1) REFERENCES PEOPLE(id),
	FOREIGN KEY (id2) REFERENCES PEOPLE(id)
);


CREATE TABLE IF NOT EXISTS GROUPS (
	id INT NOT NULL,
	created_on DATE NOT NULL,
	creator_id INT NOT NULL,
	topic_id TINYINT NOT NULL, 
	PRIMARY KEY (id),
	FOREIGN KEY (creator_id) REFERENCES PEOPLE(id),
	FOREIGN KEY (topic_id) REFERENCES TOPICS(id)
);

CREATE TABLE IF NOT EXISTS POSTS (
	id INT NOT NULL,
	created_on DATE NOT NULL,
	creator_id INT NOT NULL,
	content_id TINYINT NOT NULL, 
	PRIMARY KEY (id),
	FOREIGN KEY (creator_id) REFERENCES PEOPLE(id),
	FOREIGN KEY (content_id) REFERENCES CONTENT(id)
);

CREATE TABLE IF NOT EXISTS MEMBERS (
	person_id INT NOT NULL,
	group_id INT NOT NULL,
	PRIMARY KEY (person_id, group_id),
	FOREIGN KEY (person_id) REFERENCES PEOPLE(id),
	FOREIGN KEY (group_id) REFERENCES GROUPS(id)
);

CREATE TABLE IF NOT EXISTS LIKES (
	person_id INT NOT NULL,
	post_id INT NOT NULL,
	PRIMARY KEY (person_id, post_id),
	FOREIGN KEY (person_id) REFERENCES PEOPLE(id),
	FOREIGN KEY (post_id) REFERENCES POSTS(id)
);

