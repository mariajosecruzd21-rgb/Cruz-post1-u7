package com.universidad.patrones.tareas.model;

public class TareaNotFoundException extends RuntimeException {
    public TareaNotFoundException(String message) {
        super(message);
    }

}
