
-- Drop table

-- DROP TABLE public.state;

CREATE TABLE public.state (
	id bpchar(2) NOT NULL,
	CONSTRAINT state_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.person;

CREATE TABLE public.person (
	id int4 NOT NULL GENERATED BY DEFAULT AS IDENTITY,
	firstname varchar(50) NULL,
	lastname varchar(50) NOT NULL,
	state bpchar(2) NULL,
	username varchar(8) NULL,
	CONSTRAINT person_pkey PRIMARY KEY (id),
	CONSTRAINT fk_person_state FOREIGN KEY (state) REFERENCES state(id)
);
