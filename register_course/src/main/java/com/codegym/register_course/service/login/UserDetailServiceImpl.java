//package com.codegym.register_course.service.login;
//
//import com.codegym.register_course.model.AppUser;
//import com.codegym.register_course.model.UserRole;
//import com.codegym.register_course.repository.login.IAppUserRepository;
//import com.codegym.register_course.repository.login.IUserRoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    private IAppUserRepository userRepository;
//
//    @Autowired
//    private IUserRoleRepository userRoleRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        AppUser appUser = this.userRepository.findByUserName(userName);
//
//        if (appUser == null) {
//            System.out.println("User not found! " + userName);
//            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
//        }
//
//        System.out.println("Found User: " + appUser);
//
//        // [ROLE_USER, ROLE_ADMIN,..]
//        List<UserRole> userRoles = this.userRoleRepository.findByAppUser(appUser);
//
////        for (UserRole userRole:userRoles) {
////            System.err.println(userRole.getAppRole().getName());
////        }
//
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (userRoles != null) {
//            for (UserRole userRole : userRoles) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" +userRole.getAppRole().getRoleName());
//                grantList.add(authority);
//            }
//        }
//
////        for (GrantedAuthority grantedAuthority:grantList) {
////            System.err.println(grantedAuthority.getAuthority());
////        }
//
//        UserDetails userDetails = new User(appUser.getUserName(), //
//                appUser.getUserPass(), grantList);
//
//        return userDetails;
//    }
//}
