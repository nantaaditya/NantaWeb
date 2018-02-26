package com.nanta.base;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class Converter {
  public final static MapperFactory MAPPER = new DefaultMapperFactory.Builder().build();
}
