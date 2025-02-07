-- DB customerapi
-- Owner: posgres

-- Table: public.customer

-- DROP TABLE public.customer;

CREATE TABLE public.customer
(
    id bigint NOT NULL,
    name character varying(200) COLLATE pg_catalog."default",
    email character varying(200) COLLATE pg_catalog."default",
    phone character varying(30) COLLATE pg_catalog."default",
    CONSTRAINT customer_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;

CREATE SEQUENCE customer_seq START WITH 1 INCREMENT BY 1;    

ALTER TABLE customer ALTER COLUMN id SET DEFAULT nextval('customer_seq');
    
    