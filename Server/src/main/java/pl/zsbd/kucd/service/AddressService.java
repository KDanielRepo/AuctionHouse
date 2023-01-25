package pl.zsbd.kucd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zsbd.kucd.entity.Address;
import pl.zsbd.kucd.interfaces.BaseService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService implements BaseService<Address> {
    @Override
    public List<Address> findAll() {
        return null;
    }

    @Override
    public Address findById(Long id) {
        return null;
    }

    @Override
    public void save(Address entity) {

    }

    @Override
    public void edit(Address entity) {

    }

    @Override
    public void delete(Address entity) {

    }
}
