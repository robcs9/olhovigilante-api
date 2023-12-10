package br.edu.ifpe.olhovigilanteapi.api.usuario;

import java.util.Arrays;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.edu.ifpe.olhovigilanteapi.modelo.acesso.Membro;
import br.edu.ifpe.olhovigilanteapi.modelo.usuario.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    private String nome;

    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    private String cpf;

    //Email deve ser único
    @NotBlank(message = "O E-mail é de preenchimento obrigatório")
    @Email
    private String email;

    @NotBlank(message = "A senha é de preenchimento obrigatório")
    @Size(min = 6, max = 16, message = "A senha deve conter de 8 a 16 caracteres")
    @Pattern(
        regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$",
        message="A senha dever conter letras maiúscula(s), minúscula(s), número(s) e caracter(es) especiai(s)"
    )
    private String password;
    
    //private String senha;

    private String bairro;

    private String cidade;

    private String avatar;

    //private String role;

    private Integer reputacao;

    private Boolean verificado;

    private Integer contadorSeguidores;

    private Integer contadorSeguindo;

    public Usuario build() {

        return Usuario.builder()
                .membro(buildMembro())
                .nome(nome)
                .cpf(cpf)
                .email(email)
                //.senha(senha)
                .bairro(bairro)
                .cidade(cidade)
                .avatar(avatar)
                //.role(role)
                .reputacao(reputacao)
                .verificado(verificado)
                .contadorSeguidores(contadorSeguidores)
                .contadorSeguindo(contadorSeguindo)
                .build();
    }

    public Membro buildMembro() {
	
        return Membro.builder()
            .username(email)
            .password(password)
            .roles(Arrays.asList(Membro.ROLE_USUARIO))
            .build();
        }
    
}
