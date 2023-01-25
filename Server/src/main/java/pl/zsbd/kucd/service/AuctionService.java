package pl.zsbd.kucd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zsbd.kucd.entity.Auction;
import pl.zsbd.kucd.interfaces.BaseService;
import pl.zsbd.kucd.repository.AuctionRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuctionService implements BaseService<Auction> {

    private final AuctionRepository auctionRepository;

    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction findById(Long id) {
        return auctionRepository.findById(id).get();
    }

    @Override
    public void save(Auction entity) {
        auctionRepository.save(entity);
    }

    @Override
    public void edit(Auction entity) {

    }

    @Override
    public void delete(Auction entity) {

    }

    public boolean existsByTitle(String title){
        return auctionRepository.existsByTitle(title);
    }
}
