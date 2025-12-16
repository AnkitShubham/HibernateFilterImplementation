package dev.project.hibernateFilterImplementation.aspect;

import dev.project.hibernateFilterImplementation.context.CountryContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CountryFilterAnnotationAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Before("@within(dev.project.hibernateFilterImplementation.annotation.EnableCountryFilter) || @annotation(dev.project.hibernateFilterImplementation.annotation.EnableCountryFilter)")
    public void applyLocaleFilter() {
        String country = CountryContext.getCountry();
        System.out.println(country);
        if (country != null) {
            Session session = entityManager.unwrap(Session.class);

            if (session.getEnabledFilter("countryFilter") == null) {
                org.hibernate.Filter filter = session.enableFilter("countryFilter");
                System.out.println("country: " + country);
                filter.setParameter("country", country);
            }
        }
    }
}
