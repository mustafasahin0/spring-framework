package com.example.util;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;

public class MapperUtil {

    private final ModelMapper modelMapper;

    public MapperUtil(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <T> T convert(Object ojectToBeConverted, T convertedObject) {
        return modelMapper.map(ojectToBeConverted, (Type) convertedObject.getClass());
    }
}
