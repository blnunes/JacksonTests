import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String TESTE_JSON_COMUM = "{\n" +
            "  \"pessoa\": \"Bruno boladao\",\n" +
            "  \"idade\": 0,\n" +
            "  \"salario\": 0.0,\n" +
            "  \"status\": false\n" +
            "}";

    private static final String TESTE_LIST_JSON = "[\n" +
            "  {\n" +
            "    \"pessoa\": \"Bruno boladao\",\n" +
            "    \"idade\": 0,\n" +
            "    \"salario\": 0.0,\n" +
            "    \"status\": false\n" +
            "  },\n" +
            "  {\n" +
            "    \"pessoa\": \"Bruno boladao2\",\n" +
            "    \"idade\": 110,\n" +
            "    \"salario\": 11000.0,\n" +
            "    \"status\": false\n" +
            "  }\n" +
            "]";
    
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        jsonToPojo();
        pojoToJson();
        jsonListToPojoList();
        jsonListToPojoArray();
        jsonListToPojoMap();

    }

    private static void jsonListToPojoList() throws JsonProcessingException {
        List<TesteDTO> testeDTO = objectMapper.readValue(TESTE_LIST_JSON, new TypeReference<List<TesteDTO>>() {
        });
        System.out.println(" List JSON TO List POJO " +testeDTO.toString());
    }

    private static void jsonListToPojoArray() throws JsonProcessingException {
        TesteDTO[] testeDTOS = objectMapper.readValue(TESTE_LIST_JSON, TesteDTO[].class);
        List<TesteDTO> testeDTO = Arrays.asList(testeDTOS);
        System.out.println(" List JSON TO Array POJO " +testeDTO.toString());
    }

    private static void jsonListToPojoMap() throws JsonProcessingException {
        Map<String, String> testeDTO = objectMapper.readValue(TESTE_JSON_COMUM, new TypeReference<Map<String, String>>() {});
        System.out.println(" MAP " +testeDTO.toString());
    }


    private static void jsonToPojo() throws JsonProcessingException {
        TesteDTO testeDTO = objectMapper.readValue(TESTE_JSON_COMUM, TesteDTO.class);
        System.out.println(" JSON TO POJO " +testeDTO.toString());
    }

    private static void pojoToJson() throws JsonProcessingException {
        String s = objectMapper.writeValueAsString(montaPessoa());

        System.out.println(" POJO TO JSON " +s);
    }

    private static TesteDTO montaPessoa() {
        return TesteDTO.builder().pessoa("Teste")
                .idade(11)
                .salario(BigDecimal.TEN)
                .status(true)
                .build();
    }
}
