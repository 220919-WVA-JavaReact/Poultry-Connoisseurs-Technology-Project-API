package com.revature.aspects;

import com.revature.annotations.RoleFilter;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.UserNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecurityAspect {


    private HttpServletRequest req;

    @Autowired
    public SecurityAspect(HttpServletRequest req){
        this.req = req;

    }


    // Need to add in special exception for not allowed. Also exceptions in general maybe need more functionality.
    @Around("@annotation(com.revature.annotations.RoleFilter)")
    public Object roleFilter(ProceedingJoinPoint pjp) throws Throwable{


        List<String> allowedRoles = Arrays.asList( ((MethodSignature) pjp
                .getSignature())
                .getMethod()
                .getAnnotation(RoleFilter.class)
                .rolesAllowed());

        String senderRole = req.getHeader("Role");

        if(allowedRoles.contains(senderRole)){
            return pjp.proceed();
        } else {
            throw new UserNotFoundException();
        }


    }

}
