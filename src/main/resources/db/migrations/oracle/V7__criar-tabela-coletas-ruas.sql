CREATE SEQUENCE COLETAS_RUAS_SEQ;

CREATE TABLE COLETAS_RUAS (
                                 ID INTEGER DEFAULT COLETAS_RUAS_SEQ.NEXTVAL NOT NULL,
                                 ID_USUARIO_SOLICITANTE INTEGER NOT NULL,
                                 ID_RUA INTEGER NOT NULL,
                                 ID_TIPO_COLETA INTEGER NOT NULL,
                                 DATA_AGENDAMENTO DATE NOT NULL,
                                 DATA_COLETA DATE,
                                 STATUS INTEGER DEFAULT 0,
                                 CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY(ID),
                                 CONSTRAINT FK_COLETAS_RUAS_1 FOREIGN KEY (ID_USUARIO_SOLICITANTE) REFERENCES USUARIOS (ID),
                                 CONSTRAINT FK_COLETAS_RUAS_2 FOREIGN KEY (ID_RUA) REFERENCES RUAS (ID),
                                 CONSTRAINT FK_COLETAS_RUAS_3 FOREIGN KEY (ID_TIPO_COLETA) REFERENCES TIPOS_COLETAS (ID)
);
