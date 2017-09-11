package tom.springboot.springbootwebapp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Permission extends AbstractDomainClass {
    private String permission;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles=new ArrayList<>();

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role){
        if(!this.getRoles().contains(role)){
            this.getRoles().add(role);
        }
        if(!role.getPermissions().contains(this)){
            role.getPermissions().add(this);
        }
    }
    public void removeRole(Role role){
        this.roles.remove(role);
        role.getPermissions().remove(this);
    }
}
