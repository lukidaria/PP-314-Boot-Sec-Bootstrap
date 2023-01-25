//package ru.kata.spring.boot_security.demo.start;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.event.ApplicationPreparedEvent;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.boot.context.event.ApplicationStartedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.model.Role;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.repository.RoleRepository;
//import ru.kata.spring.boot_security.demo.service.UserService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class BeanInit {
//
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    private RoleRepository roleRepository;
//
//    @Autowired
//    public void setRoleRepository(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @EventListener(ApplicationStartedEvent.class)
//    public void runAfterSpringBoot() {
//        List<Role> userList = new ArrayList<>();
//        Role roleUser = roleRepository.findRoleByName("ROLE_USER");
//        userList.add(roleUser);
//        List<Role> adminList = new ArrayList<>();
//        Role roleAdmin = roleRepository.findRoleByName("ROLE_ADMIN");
//        adminList.add(roleAdmin);
//
//        User user = new User("firstnameUser", "lastnameUser",
//                35, "user@mail.ru", "100");
//        user.setRoles(userList);
//        userService.saveUser(user);
//
//        User admin = new User("firstnameAdmin", "lastnameAdmin",
//                20, "admin@mail.ru", "100");
//        admin.setRoles(adminList);
//        userService.saveUser(admin);
//
//
//
//    }
//}
