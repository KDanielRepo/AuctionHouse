package pl.zsbd.kucd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zsbd.kucd.entity.User;
import pl.zsbd.kucd.interfaces.BaseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<User> {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void edit(User entity) {

    }

    @Override
    public void delete(User entity) {

    }
}
