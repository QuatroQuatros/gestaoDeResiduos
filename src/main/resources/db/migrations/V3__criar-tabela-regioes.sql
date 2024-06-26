CREATE SEQUENCE REGIOES_SEQ;

CREATE TABLE REGIOES(
                        ID INTEGER DEFAULT REGIOES_SEQ.NEXTVAL NOT NULL,
                        ID_ESTADO INTEGER NOT NULL,
                        NOME VARCHAR2(50) UNIQUE NOT NULL,
                        CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        PRIMARY KEY(ID),
                        CONSTRAINT FK_REGIOES FOREIGN KEY (ID_ESTADO) REFERENCES ESTADOS (ID)
);