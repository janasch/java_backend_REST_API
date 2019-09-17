--
-- Database schema
--
CREATE TABLE messages (
    id BIGSERIAL PRIMARY KEY,
    msg character varying(100) NOT NULL,
    msg_ts timestamp with time zone NOT NULL,
    palendrome int
);
