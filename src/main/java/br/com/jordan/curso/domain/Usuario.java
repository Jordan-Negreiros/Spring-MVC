package br.com.jordan.curso.domain;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @Column(nullable = false, length = 50)
    @NotBlank
    @Size(min = 3, max = 50, message = "Campo requerido entre {min} e {max} caracteres.")
    private String sobrenome;

    @Column(name = "tipo_sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoSexo sexo;

    @Column(name = "data_nascimento", nullable = false)
    @NotNull(message = "O campo 'data de nascimento' é requerido.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate DtNascimento;

}
