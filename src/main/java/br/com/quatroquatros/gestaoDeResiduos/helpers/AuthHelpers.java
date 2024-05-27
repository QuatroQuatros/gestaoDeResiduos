package br.com.quatroquatros.gestaoDeResiduos.helpers;

import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthHelpers {

    public Long recuperarIdUsuario(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof UserDetails){
            Usuario usuario = (Usuario) authentication.getPrincipal();
            return usuario.getUsuarioId();
        }
        return null;
    }
}
