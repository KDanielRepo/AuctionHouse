package pl.zsbd.kucd.abstracts;

import lombok.Data;

import javax.persistence.Version;
import java.time.ZonedDateTime;

@Data
public abstract class AbstractVersionedEntity extends AbstractEntity{
    private Long globalId;
    private ZonedDateTime creationDate;
    @Version
    private long version;
}
