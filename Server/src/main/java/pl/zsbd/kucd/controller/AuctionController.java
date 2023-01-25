package pl.zsbd.kucd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zsbd.kucd.dto.AuctionDTO;
import pl.zsbd.kucd.entity.Auction;
import pl.zsbd.kucd.mapper.AuctionMapper;
import pl.zsbd.kucd.service.AuctionService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class AuctionController {

    private final AuctionService auctionService;
    private final AuctionMapper auctionMapper;

    @GetMapping("/auctions")
    public Page<List<AuctionDTO>> findAllAuctions(Pageable pageable){
        List<AuctionDTO> dtos = auctionMapper.toDTOs(auctionService.findAll());
        return new PageImpl(dtos, pageable, dtos.size());
    }

    @GetMapping("/create")
    public ResponseEntity<String> canCreate(){
        return ResponseEntity.ok("Test");
    }

    @GetMapping("/auctions/{id}")
    public AuctionDTO findAuction(@PathVariable Long id){
        return auctionMapper.toDTO(auctionService.findById(id));
    }

    @GetMapping("/auctionss/{name}")
    public boolean findAuction(@PathVariable String title){
        return auctionService.existsByTitle(title);
    }

    @PostMapping("/createAuction")
    public ResponseEntity<Void> createAuction(@RequestBody AuctionDTO auctionDTO){
        auctionService.save(auctionMapper.toEntity(auctionDTO));
        return ResponseEntity.ok().build();
    }

}
