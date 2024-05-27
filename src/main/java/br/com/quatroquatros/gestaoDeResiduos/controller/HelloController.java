package br.com.quatroquatros.gestaoDeResiduos.controller;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teste")
public class HelloController {

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Object> hello(){
        return new BaseResponseDto<>("batata2");
    }
}
