package com.example.droolstut.util;

import org.kie.api.KieServices;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Collection;

public class Util {

    public static KieSession getDefaultKieSession() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.getKieClasspathContainer();
        KieSession kieSession = kieContainer.newKieSession();
        return kieSession;
    }

    public static <T> Collection<T> getFactsFromSession(KieSession kieSession, Class<T> clazz) {
        return (Collection<T>) kieSession.getObjects(new ClassObjectFilter(clazz));
    }

}
