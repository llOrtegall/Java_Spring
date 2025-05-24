package ortega.api_rest.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parametros")
public class RequesParamController {

  @Value("${config.codigo}")
  private String codigo;
  @Value("${config.usuario}")
  private String usuario;
  @Value("${config.msg}")
  private String msg;
  @Value("${config.valores}")
  private String[] valores;

  @GetMapping("/detalle")
  public ParametrosDTO detalle(
      @RequestParam(required = false, defaultValue = "hola a todos") String inf) {

    ParametrosDTO dto1 = new ParametrosDTO();
    dto1.setInformacion(inf);
    return dto1;
  }

  @GetMapping("/detalle2")
  public Map<String, Object> detalle2() {
    Map<String, Object> info = new HashMap<>();
    info.put("codigo", codigo);
    info.put("usuario", usuario);
    info.put("msg", msg);
    info.put("valores", Arrays.asList(valores));

    return info;

  }
}
