package pl.zsbd.kucd.interfaces;

import pl.zsbd.kucd.abstracts.AbstractDTO;

public interface Validator<T extends AbstractDTO> {
    void validate(T entity);
}
