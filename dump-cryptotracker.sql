--
-- PostgreSQL database dump
--

-- Dumped from database version 17.1
-- Dumped by pg_dump version 17.1

-- Started on 2024-11-17 19:40:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4845 (class 1262 OID 16388)
-- Name: cryptotracker; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE cryptotracker WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';


ALTER DATABASE cryptotracker OWNER TO postgres;

\connect cryptotracker

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 4 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: pg_database_owner
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO pg_database_owner;

--
-- TOC entry 4846 (class 0 OID 0)
-- Dependencies: 4
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: pg_database_owner
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 217 (class 1259 OID 16394)
-- Name: holdings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.holdings (
    symbol character varying NOT NULL,
    amount double precision NOT NULL,
    cryptouser character varying NOT NULL,
    date date NOT NULL
);


ALTER TABLE public.holdings OWNER TO postgres;

--
-- TOC entry 4839 (class 0 OID 16394)
-- Dependencies: 217
-- Data for Name: holdings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.holdings (symbol, amount, cryptouser, date) FROM stdin;
btc	0.031077	louis	2024-11-17
mana	19	louis	2024-11-17
near	12.85	louis	2024-11-17
btc	0.031077	louis	2024-11-17
mana	19	louis	2024-11-17
near	12.85	louis	2024-11-17
btc	0.031077	louis	2024-11-17
mana	19	louis	2024-11-17
near	12.85	louis	2024-11-17
\.


-- Completed on 2024-11-17 19:40:35

--
-- PostgreSQL database dump complete
--

