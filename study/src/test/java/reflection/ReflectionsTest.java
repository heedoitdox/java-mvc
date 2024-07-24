package reflection;

import java.util.Set;
import net.bytebuddy.utility.dispatcher.JavaDispatcher.Container;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reflection.annotation.Controller;
import reflection.annotation.Repository;
import reflection.annotation.Service;

class ReflectionsTest {

    private static final Logger log = LoggerFactory.getLogger(ReflectionsTest.class);

    @Test
    @DisplayName("클래스 레벨에 @Controller, @Service, @Repository 애노테이션이 설정되어 모든 클래스 찾아 로그로 출력한다")
    void showAnnotationClass() throws Exception {
        Reflections reflections = new Reflections("reflection.examples");

        Set<Class<?>> controllers = reflections.getTypesAnnotatedWith(Controller.class);
        for (Class<?> aClass : controllers) {
            log.info(aClass.getName());
        }

        Set<Class<?>> services = reflections.getTypesAnnotatedWith(Service.class);
        for (Class<?> aClass : services) {
            log.info(aClass.getName());
        }

        Set<Class<?>> repositories = reflections.getTypesAnnotatedWith(Repository.class);
        for (Class<?> aClass : repositories) {
            log.info(aClass.getName());

        }
    }
}
