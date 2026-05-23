package com.taskmanager.mappers;

public interface CommonMapper <RQ, RS, E>{
    E toEntity(RQ request);
    RS toResponse(E entity);
}
