package tom.springboot.springbootwebapp.bootstrap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tom.springboot.springbootwebapp.domain.Permission;
import tom.springboot.springbootwebapp.domain.Product;
import tom.springboot.springbootwebapp.domain.Role;
import tom.springboot.springbootwebapp.domain.User;
import tom.springboot.springbootwebapp.repositories.ProductRepository;
import tom.springboot.springbootwebapp.services.PermissionService;
import tom.springboot.springbootwebapp.services.RoleService;
import tom.springboot.springbootwebapp.services.UserService;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductRepository productRepository;
    private UserService userService;
    private RoleService roleService;
    private PermissionService permissionService;

    private Logger log = Logger.getLogger(SpringJpaBootstrap.class);

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
        loadUsers();
        loadRoles();
        loadPermission();
        assignUsersToUserRole();
        assignUsersToAdminRole();
        assignPermissionsToUserRole();
        assignPermissionsToAdminRole();
    }

    private void loadProducts() {
        Product shirt = new Product();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        productRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        Product mug = new Product();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springframework.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        productRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
    }

    private void loadUsers() {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        userService.saveOrUpdate(user2);

    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        log.info("Saved role" + role.getRole());
        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        log.info("Saved role" + adminRole.getRole());
    }

    private void loadPermission(){
        Permission permission=new Permission();
        permission.setPermission("User");
        permissionService.saveOrUpdate(permission);
        log.info("Saved permission"+permission.getPermission());
        Permission adminPermission=new Permission();
        adminPermission.setPermission("ADMIN");
        permissionService.saveOrUpdate(adminPermission);
        log.info("Saved permission"+adminPermission.getPermission());
    }


    private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("user")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }

    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }

    private void assignPermissionsToUserRole(){
        List<Role> roles= (List<Role>) roleService.listAll();
        List<Permission> permissions= (List<Permission>) permissionService.listAll();

        excuAssignPermissionToRole(roles, permissions,"USER");
    }

    private void assignPermissionsToAdminRole(){
        List<Role> roles= (List<Role>) roleService.listAll();
        List<Permission> permissions= (List<Permission>) permissionService.listAll();

        excuAssignPermissionToRole(roles, permissions,"ADMIN");
    }

    private void excuAssignPermissionToRole(List<Role> roles, List<Permission> permissions,String flag) {
        permissions.forEach(permission -> {
            if(permission.getPermission().equalsIgnoreCase(flag)){
                roles.forEach(role -> {
                    if(role.getRole().equalsIgnoreCase(flag)){
                        role.addPermission(permission);
                        roleService.saveOrUpdate(role);
                    }
                });
            }
        });
    }




}


