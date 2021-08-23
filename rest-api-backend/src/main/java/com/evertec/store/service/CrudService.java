package com.evertec.store.service;

import java.util.List;

/**
 * Interfaz que contiene todos los compromisos funcionales de un DAO básico para realizar operaciones CRUD a través de
 * consultas definidas por los implementadores de la interfaz
 * @param <Entity> clase de la entidad envuelta por el DAO
 * @param <Id> clase de la llave primaria de la entidad envuelta por el DAO
 */
public interface CrudService<Entity, Id> {
	
	/**
    * Cuenta la cantidad de registros en la base de datos mapeables a la clase envuelta por este DAO
    * @return la cantidad de registros mapeables por esta clase existentes en la base de datos
    */
   long count();

   /**
    * Lee todas los registros en la base de datos mapeados a la clase envuelta por este DAO
    * @return todos los registros mapeados
    */
   List<Entity> read();

   /**
    * Lee una cantidad limitada de registros en la base de datos mapeables a la clase envuelta por este DAO
    * @param limit cantidad máxima de registros retornados mapeados
    * @param offset fila a partir de la cual se retornarán los registros mapeados
    * @return Un conjunto de {@code limit} registeos mapeados a partir de la fila {@code offset}
    */
   List<Entity> read(int limit, int offset);

   //Inherited By Abstract IdentifiedDAOs
   /**
    * Elimina un registro en la base de datos mapeable a la clase envuelta por este DAO
    * @param id identificador único del registro en la base de datos
    */
   void delete(Id id);

   /**
    * Lee un registro registro identificado en la base de datos mapeado a la clase envuelta por este DAO
    * @param id identificador único del registro en la base de datos
    * @return el registro mappeada desde la base de datos con id {@code id}
    */
   Entity read(Id id);

   //Implemented by Concrete classes
   /**
    * Crea un registro en la base de datos mapeable a la clase envuelta por este DAO
    * @param e la entidad para mappear y crear en la base de datos
    */
   Entity create(Entity e);

   /**
    * Actualiza un registro en la base de datos mapeada a la clase envuelta por este DAO
    * @param e la entidad para mapeada para actualizar en la base de datos
    */
   void update(Entity e);
}
