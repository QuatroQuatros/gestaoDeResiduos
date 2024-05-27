package br.com.quatroquatros.gestaoDeResiduos.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class ForeignKeyNotExistsException extends DataIntegrityViolationException {

    public ForeignKeyNotExistsException(String msg) {
        super(msg);
    }

    public ForeignKeyNotExistsException(String msg, Throwable cause) {
        super(msg, cause);
    }


}
