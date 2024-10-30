package br.com.jtigik.domain;

import static br.com.jtigik.domain.builder.UsuarioBuilder.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import br.com.jtigik.domain.exceptions.ValidationException;

@DisplayName("Domíno: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido() {
        Usuario usuario = umUsuario().agora();

        Assertions.assertAll("Usuário",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Usuário válido", usuario.getNome()),
                () -> assertEquals("user@mail.com", usuario.getEmail()),
                () -> assertEquals("123456", usuario.getSenha())
        );

    }

    @ParameterizedTest(name = "[{index}] - {4}")
    @CsvFileSource(files = "src\\test\\resources\\CamposObrigatoriosUsuario.csv", nullValues = "NULL", numLinesToSkip = 1)
    public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String mensagem) {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, ()
                -> umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).agora());
        assertEquals(mensagem, ex.getMessage());
    }

}
