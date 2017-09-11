package tom.springboot.springbootwebapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import tom.springboot.springbootwebapp.domain.Permission;
import tom.springboot.springbootwebapp.repositories.PermssionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("springdatajpa")
public class PermissionServicelmpl implements PermissionService {

    private PermssionRepository permissionRepository;

    @Autowired
    public void setPermissionRepository(PermssionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    @Override
    public List<?> listAll() {
        List<Permission> permissions = new ArrayList<>();
        permissionRepository.findAll().forEach(permissions::add);
        return permissions;
    }

    @Override
    public Permission getById(Integer id) {
        return permissionRepository.findOne(id);
    }

    @Override
    public Permission saveOrUpdate(Permission domainObject) {
        return permissionRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        permissionRepository.delete(id);
    }
}
