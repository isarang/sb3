package com.github.isarang.sb3.config;

import io.github.classgraph.ModuleReaderProxy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.springframework.aot.hint.ExecutableMode;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;

public class MyRuntimeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        // Register method for reflection
//        Method method = ReflectionUtils.findMethod(MyClass.class, "sayHello", String.class);
//        hints.reflection().registerMethod(method, ExecutableMode.INVOKE);
//        for (Constructor<?> constructor : java.util.HashSet.class.getConstructors()) {
//            hints.reflection().registerConstructor(constructor, ExecutableMode.INVOKE);
//        }
        //hints.reflection().registerType(ModuleReaderProxy.class);
        // Register resources
        //hints.resources().registerPattern("my-resource.txt");

        // Register serialization
        hints.serialization().registerType(java.util.HashSet.class);

        // Register proxy
       // hints.proxies().registerJdkProxy(MyInterface.class);
        //hints.proxies().registerJdkProxy(ModuleReaderProxy.class);
    }
}

