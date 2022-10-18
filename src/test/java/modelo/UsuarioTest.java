package modelo;

import builder.UsuarioBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void estaEmDebito() {
        Usuario usuario = UsuarioBuilder
                .umUsuario()
                .construi();
        assertFalse(usuario.isEmDebito());
    }

}