package org.iesbelen.controlador;

import org.iesbelen.excepciones.MiExcepcion;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceClass {

    @ExceptionHandler(MiExcepcion.class)
    public String handleMiExcepcion(Model model, MiExcepcion miExcepcion) {
        model.addAttribute("traza", miExcepcion.getMessage());
        return "error-mi-excepcion";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleAllUncaughtException(Model model, RuntimeException exception) {
        model.addAttribute("traza", exception.getMessage());
        return "error";
    }
}
