package gr.dimitriskaitantzidis.schoolspringapp.dto;

import gr.dimitriskaitantzidis.schoolspringapp.enums.Record;
import gr.dimitriskaitantzidis.schoolspringapp.model.BaseEntity;

public interface BaseDTO<T extends BaseEntity> {
    T toEntity(Record record);
}
