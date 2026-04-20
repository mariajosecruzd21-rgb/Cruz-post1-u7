package com.universidad.patrones.tareas.repository;

import com.universidad.patrones.tareas.model.EstadoTarea;
import com.universidad.patrones.tareas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByEstado(EstadoTarea estado);
    List<Tarea> findByTituloContainingIgnoreCase(String titulo);
}
