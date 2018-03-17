package com.skip.service.operation;

/**
 * Contract for commands operations
 * @author Note-Chronos
 *
 * @param <T> Method param
 * @param <S> Return type
 */
public interface ICommandOperation<T, S> {

	S execute(T param);
	
}
