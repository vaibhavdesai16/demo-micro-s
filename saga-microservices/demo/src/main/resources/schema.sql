CREATE TABLE if not exists public.product (
	name varchar NULL,
	description varchar NULL,
	created_on date NULL,
	product_id serial NOT NULL,
	CONSTRAINT product_pk PRIMARY KEY (product_id)
);