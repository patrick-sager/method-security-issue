package com.example.methodsecurity;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import com.example.methodsecurity.repository.ThingRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootTest
public class ThingRepositoryTest {

  @Autowired
  private ThingRepository thingRepository;

  @Test
  public void testPreAuthorizeUserOnly() {
    SecurityContext context = mock(SecurityContext.class);
    Authentication authentication = mock(Authentication.class);

    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_user"));

    doReturn(authorities).when(authentication).getAuthorities();
    doReturn(true).when(authentication).isAuthenticated();
    doReturn(authentication).when(context).getAuthentication();

    SecurityContextHolder.setContext(context);

    thingRepository.findWithOddIds();
  }

  @Test
  public void testPreAuthorizeUserAndAdmin() {
    SecurityContext context = mock(SecurityContext.class);
    Authentication authentication = mock(Authentication.class);

    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_user"));
    authorities.add(new SimpleGrantedAuthority("ROLE_admin"));

    doReturn(authorities).when(authentication).getAuthorities();
    doReturn(true).when(authentication).isAuthenticated();
    doReturn(authentication).when(context).getAuthentication();

    SecurityContextHolder.setContext(context);

    thingRepository.findWithOddIds();
  }

}
