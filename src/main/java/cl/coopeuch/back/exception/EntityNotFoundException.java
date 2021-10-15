package cl.coopeuch.back.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException{
    static final String MESSAGE = "Entity %s(%d) not found";
    
    public EntityNotFoundException(Integer id, String entityName) {
        super(String.format(MESSAGE, entityName, id));
        log.error(String.format(MESSAGE, entityName, id));
    }


}
