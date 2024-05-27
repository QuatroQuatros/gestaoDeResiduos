package br.com.quatroquatros.gestaoDeResiduos.dto;

public record BaseResponseDto<T>(
        String message,
        T data
){

    public BaseResponseDto(String message) {
        this(message, null);
    }

}
