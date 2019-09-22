--
-- Database schema
--
CREATE TABLE message (
    id BIGSERIAL PRIMARY KEY,
    msg_content character varying(100) NOT NULL,
    msg_timestamp timestamp with time zone NOT NULL,
    msg_palindromeLength int
);
