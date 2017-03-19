package com.tolean.elab.mapper;

/**
 * Created by Tomasz Kołodziej
 */
public interface EnumMapper<E> {

    String toString(E e);

    E toEnum(String string);

}
