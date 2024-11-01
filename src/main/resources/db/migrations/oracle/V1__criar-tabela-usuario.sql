CREATE SEQUENCE USUARIOS_SEQ;

CREATE TABLE USUARIOS(
                             ID INTEGER DEFAULT USUARIOS_SEQ.NEXTVAL NOT NULL,
                             NOME VARCHAR2(100) NOT NULL,
                             EMAIL VARCHAR2(100) UNIQUE NOT NULL,
                             SENHA VARCHAR2(100) NOT NULL,
                             ROLE VARCHAR2(50) DEFAULT 'USER',
                             CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             PRIMARY KEY(ID)
);