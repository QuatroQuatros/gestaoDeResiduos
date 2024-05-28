package br.com.quatroquatros.gestaoDeResiduos.model.valueObject;

public enum ColetaDiaStatus {

    AGENDADO(0),
    EM_ANDAMENTO(1),
    CONCLUIDO(2),
    CANCELADO(3);

    private final int status;


    ColetaDiaStatus(int status){
        this.status = status;
    }

    public int getStatus(){
        return status;
    }
}
