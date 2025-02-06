package org.iesbelen.controlador;

import org.iesbelen.excepciones.MiExcepcion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/prueba-error")
    public String lanzarError() {
        throw new MiExcepcion("Este es un error de prueba.");
    }
}