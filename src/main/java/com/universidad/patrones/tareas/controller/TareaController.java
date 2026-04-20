package com.universidad.patrones.tareas.controller;


import com.universidad.patrones.tareas.model.EstadoTarea;
import com.universidad.patrones.tareas.model.Tarea;
import com.universidad.patrones.tareas.repository.TareaRepository;
import com.universidad.patrones.tareas.service.TareaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {
    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }
    @GetMapping
    public List<Tarea> findAll() {
        return tareaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Tarea buscarPorId(@PathVariable Long id) {
        return tareaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarea crear(@Valid @RequestBody  Tarea tarea) {
        return tareaService.crear(tarea);
    }

    @PatchMapping("/{id}/estado")
    public Tarea cambiarEstado(@PathVariable Long id, @RequestParam EstadoTarea estado) {
        return tareaService.cambiarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        tareaService.eliminar(id);
    }


}

