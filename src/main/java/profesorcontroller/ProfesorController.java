package profesorcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import profesorentity.Profesor;
import profesorservice.ProfesorService;

@RestController
@RequestMapping("/rest/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping()
    public List<Profesor> buscarProfesor() {
        return profesorService.buscarTodo();
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<Profesor> buscarPorId(@PathVariable("id") int id) {
        Profesor profesor = profesorService.buscarPorId(id);
        if (profesor == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesor no encontrado, id proporcionado no es correcto");
        }
        return ResponseEntity.ok(profesor);
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<String> crear(@RequestBody Profesor profesor) {
        profesorService.crear(profesor);
        return ResponseEntity.ok("Profesor creado correctamente");
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity<String> actualizar(@PathVariable("id") int id, @RequestBody Profesor profesor) {
        profesorService.actualizar(profesor);
        return ResponseEntity.ok("Profesor actualizado correctamente");
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") int id) {
        profesorService.eliminarProfesor(id);
        return ResponseEntity.ok("Profesor eliminado correctamente");
    }
}
