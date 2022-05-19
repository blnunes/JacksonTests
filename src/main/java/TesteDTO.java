import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) //IGNORA FIELDS NÃO ENCONTRADO **CUIDADO** POIS CASO O JSON ESTEJA ERRADO NESTE MODO NÃO É LANÇADA NENHUMA EXCEÇÃO.
        //value = {"pessoa", "idade"}) fields selecioandos para serem ignorados, é possível colocar @JSONIGNORE no proprio atributo
//, allowGetters = true, allowSetters = true) autoriza usar só como get ou só como set
public class TesteDTO {

    //@JsonIgnore
    //@JsonProperty("bookCategory")	mapeia o objeto que vem do JSON para o nome que eu quiser
    private String pessoa;
    private Integer idade;
    private BigDecimal salario;
    private boolean status;


}
