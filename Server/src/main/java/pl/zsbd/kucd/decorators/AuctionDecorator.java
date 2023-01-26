package pl.zsbd.kucd.decorators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import pl.zsbd.kucd.dto.AuctionDTO;
import pl.zsbd.kucd.entity.Auction;
import pl.zsbd.kucd.entity.User;
import pl.zsbd.kucd.mapper.AuctionMapper;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public abstract class AuctionDecorator implements AuctionMapper {

    @Autowired
    @Qualifier("delegate")
    private AuctionMapper delegate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public Auction toEntity(AuctionDTO dto) {
        Auction auction = delegate.toEntity(dto);
        if(Objects.isNull(auction.getUser())){
            auction.setUser(em.getReference(User.class, 17L));
        }
        return auction;
    }

    @Override
    public AuctionDTO toDTO(Auction entity) {
        AuctionDTO dto = delegate.toDTO(entity);
        dto.setUserId(entity.getUser().getId());
        return dto;
    }

    @Override
    public List<AuctionDTO> toDTOs(List<Auction> entities) {
        return entities
                .stream()
                .filter(Objects::nonNull)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
