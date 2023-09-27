## Spring Beans Configuration Methods

This document describes the three main ways of creating Spring beans: XML configuration, annotation-based configuration, and Java-based configuration.

**1. XML Configuration**

In XML-based configuration, beans and their dependencies are defined in an XML file (`applicationContext.xml`).

**Example:**

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="myBean" class="com.example.MyClass">
        <property name="property1" value="someValue" />
    </bean>

</beans>
```

**2. Annotation-based Configuration**

Annotations are used to define beans and their configurations. Spring scans the classpath for these annotations and automatically registers the beans in the application context.

**Example:**

```java
package com.example;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    // Bean properties and methods
}
```
```xml
<context:component-scan base-package="demo"></context:component-scan>
```

**3. Java-based Configuration**

Java-based configuration uses Java classes annotated with @Configuration and @Bean annotations to define beans and their dependencies.

**Example:**

```java
package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MyClass myBean() {
        return new MyClass();
    }
}
```

In this approach, the configuration is often bootstrapped using AnnotationConfigApplicationContext:

```java
package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyClass myBean = context.getBean(MyClass.class);
        // Use myBean
        context.close(); // Close the application context
    }
}
```

**Conclusion**

These three approaches provide flexibility in configuring and managing Spring beans based on the project's needs and developer preferences. Each method has its own set of advantages and is suited to different use cases.
