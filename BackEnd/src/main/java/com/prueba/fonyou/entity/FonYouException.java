package com.prueba.fonyou.entity;

/**
 * Exception creada para manejar los errores en la app
 * 
 * @author Jhon Lara
 *
 */
public class FonYouException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FonYouException(String message) {
		super(message);
	}
}
