CREATE TABLE setting
(
    id         BIGINT            NOT NULL AUTO_INCREMENT,
    name       VARCHAR(100)      NOT NULL,
    value   VARCHAR(100)      NOT NULL,
    primary key (id)
);
ALTER TABLE setting ADD CONSTRAINT uc_setting_name UNIQUE (name);

CREATE TABLE revinfo (
                         rev INTEGER AUTO_INCREMENT,
                         revtstmp BIGINT,
                         PRIMARY KEY (rev)
);


CREATE TABLE setting_aud (
                             id bigint NOT NULL,
                             name VARCHAR(50),
                             value VARCHAR(50),
                             rev INTEGER NOT NULL,
                             revtype tinyint NOT NULL,
                             PRIMARY KEY (id, rev)
);

