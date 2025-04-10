package org.iesbelen.controlador;

import jakarta.validation.Valid;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    //equivalente a la siguiente anotación
    @GetMapping("/clientes") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Cliente> listaClientes = clienteService.listAll();
        model.addAttribute("listaClientes", listaClientes);

        return "clientes/clientes";
    }

    // DETALLE CLIENTE
    @GetMapping("/clientes/{id}")
    public String detalle(Model model, @PathVariable long id) {

        Cliente cliente = clienteService.one(id);
        model.addAttribute("cliente", cliente);

        return "clientes/detalle-cliente";
    }

    // GET CREAR CLIENTES
    @GetMapping("/clientes/crear")
    public String crear(Model model) {

        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);

        return "clientes/crear-cliente";
    }

    // POST CREAR CLIENTES
    @PostMapping("/clientes/crear")
    public String submitCrear(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "clientes/crear-cliente";
        }
        clienteService.newCliente(cliente);
        return "redirect:/clientes";
    }

    // GET EDITAR CLIENTES
    @GetMapping("/clientes/editar/{id}")
    public String editar(Model model, @PathVariable long id) {

        Cliente cliente = clienteService.one(id);
        model.addAttribute("cliente", cliente);

        return "clientes/editar-cliente";
    }

    // POST EDITAR CLIENTES
    @PostMapping("/clientes/editar/{id}")
    public String submitEditar(@ModelAttribute("cliente") @Valid Cliente cliente, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cliente", cliente);
            return "clientes/editar-cliente";
        }

        clienteService.replaceCliente(cliente);
        return ("redirect:/clientes");
    }

    @PostMapping("/clientes/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable long id) {

        clienteService.deleteCliente(id);

        return new RedirectView("/clientes");
    }

}