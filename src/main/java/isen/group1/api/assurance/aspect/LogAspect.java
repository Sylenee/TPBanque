package isen.group1.api.assurance.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Pointcut pour toutes les méthodes dans le projet à partir de la racine contenant le préfixe find*
     */
    @Pointcut("execution(* isen.group1.api.assurance..*.*find*(..))")
    private void findMethod() {}

    /**
     * Log avant l'appel à une méthode de recherche
     * @param joinPoint le point d'entrée pour l'exécution de la méthode
     */
    @Before("findMethod()")
    public void logBeforeFindMethod(JoinPoint joinPoint) {
        log.info("Appel à la méthode de recherche : " + joinPoint.getSignature().getName());
    }

    /**
     * Log après l'appel à une méthode de recherche
     * @param joinPoint le point d'entrée pour l'exécution de la méthode
     * @param result le résultat renvoyé par la méthode de recherche
     */
    @AfterReturning(pointcut = "findMethod()", returning = "result")
    public void logAfterFindMethod(JoinPoint joinPoint, Object result) {
        log.info("Méthode de recherche terminée : " + joinPoint.getSignature().getName() + " Renvoie : " + result.toString());
    }
}

// OLD
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
//import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import java.util.Arrays;
//import java.util.stream.Collectors;
//
//@Aspect
//@Component
//public class LogAspect {
//
//    private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//    // Pointcut pour les méthodes de type GET dans les contrôleurs
//    @Pointcut("execution(* isen.group1.api.assurance.controller.*Controller.get*(..))")
//    private void getMethod() {}
//
//    // Pointcut pour les méthodes de type POST dans les contrôleurs
//    @Pointcut("execution(* isen.group1.api.assurance.controller.*Controller.post*(..))")
//    private void postMethod() {}
//
//    // Pointcut pour les méthodes de type PUT dans les contrôleurs
//    @Pointcut("execution(* isen.group1.api.assurance.controller.*Controller.put*(..))")
//    private void putMethod() {}
//
//    // Pointcut pour les méthodes de type DELETE dans les contrôleurs
//    @Pointcut("execution(* isen.group1.api.assurance.controller.*Controller.delete*(..))")
//    private void deleteMethod() {}
//
//    // Pointcut pour les méthodes de type JDBC
//    @Pointcut("execution(* isen.group1.api.assurance.data.repository.jdbc.*.*(..))")
//    private void jdbcMethod() {}
//
//    // Pointcut pour les méthodes de type JPA
//    @Pointcut("execution(* isen.group1.api.assurance.data.repository.jpa.*.*(..))")
//    private void jpaMethod() {}
//
//    @Before("getMethod() || postMethod() || putMethod() || deleteMethod()")
//    public void logBeforeRestCall(JoinPoint joinPoint) {
//        log.info("REST call: " + joinPoint.getSignature().getName() + " with args "
//                + Arrays.toString(joinPoint.getArgs()));
//    }
//
//    @AfterReturning(pointcut = "getMethod() || postMethod() || putMethod() || deleteMethod()",
//            returning = "result")
//    public void logAfterRestCall(JoinPoint joinPoint, Object result) {
//        log.info("REST call: " + joinPoint.getSignature().getName() + " returns " + result);
//    }
//
//    @Before("jdbcMethod()")
//    public void logBeforeJdbcCall(JoinPoint joinPoint) {
//        JdbcTemplate jdbcTemplate = getJdbcTemplateFromJoinPoint(joinPoint);
//        String sql = getSqlFromJoinPoint(joinPoint);
//        Object[] args = getArgumentsFromJoinPoint(joinPoint);
//        String argsString = Arrays.stream(args)
//                .map(Object::toString)
//                .collect(Collectors.joining(", "));
//        log.info("JDBC call: " + sql + " with args " + argsString);
//    }
//
//    @AfterReturning(pointcut = "jdbcMethod()", returning = "result")
//    public void logAfterJdbcCall(JoinPoint joinPoint, Object result) {
//        JdbcTemplate jdbcTemplate = getJdbcTemplateFromJoinPoint(joinPoint);
//        String sql = getSqlFromJoinPoint(joinPoint);
//        Object[] args = getArgumentsFromJoinPoint(joinPoint);
//        String argsString = Arrays.stream(args)
//                .map(Object::toString)
//                .collect(Collectors.joining(", "));
//        log.info("JDBC call: " + sql + " with args " + argsString + " returns " + result);
//    }
//
//    @Before("jpaMethod()")
//    public void logBeforeJpaCall(JoinPoint joinPoint) {
//        String methodName = joinPoint.getSignature().getName();
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        Object[] args = joinPoint.getArgs();
//        String argsString = Arrays.toString(args);
//        log.info("JPA call: " + methodName + " with args " + argsString + " in " + className);
//    }
//
//    @AfterReturning(pointcut = "jpaMethod()",
//            returning = "result")
//    public void logAfterJpaCall(JoinPoint joinPoint, Object result) {
//        String methodName = joinPoint.getSignature().getName();
//        String className = joinPoint.getTarget().getClass().getSimpleName();
//        log.info("JPA call: " + methodName + " in " + className + " returns " + result);
//    }
//
//    private JdbcTemplate getJdbcTemplateFromJoinPoint(JoinPoint joinPoint) {
//        Object target = joinPoint.getTarget();
//        if (target instanceof JdbcDaoSupport) {
//            return ((JdbcDaoSupport) target).getJdbcTemplate();
//        } else if (target instanceof NamedParameterJdbcDaoSupport) {
//            return ((NamedParameterJdbcDaoSupport) target).getJdbcTemplate();
//        } else {
//            throw new IllegalStateException("Unexpected target class: " + target.getClass().getName());
//        }
//    }
//
//    private String getSqlFromJoinPoint(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String sqlAnnotation = signature.getMethod().toGenericString();
//        if (sqlAnnotation != null) {
//            return sqlAnnotation;
//        } else {
//            throw new IllegalStateException("Missing @Sql annotation on method " + signature.getName());
//        }
//    }
//
//    private Object[] getArgumentsFromJoinPoint(JoinPoint joinPoint) {
//        return joinPoint.getArgs();
//    }
//
//}