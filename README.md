# Sample: Liferay Spring Portlet

A simple spring portlet with form validation in Liferay 6.2.x.

## Importants snippets:

__pom.xml__:

```xml
<dependencies>
  ...
  <dependency>
      <groupId>javax.validation</groupId>
      <artifactId>validation-api</artifactId>
      <version>1.1.0.Final</version>
  </dependency>
  <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>5.1.3.Final</version>
  </dependency>
  ...
</dependencies>
```

__src/main/webapp/WEB-INF/liferay-portlet.xml__:

```xml
<portlet>
    ...
    <requires-namespaced-parameters>false</requires-namespaced-parameters>
    ...
</portlet>
```

__src/main/webapp/WEB-INF/spring-context/portlet-application-context.xml__:

```xml
<beans
      ...
      xmlns:mvc="http://www.springframework.org/schema/mvc"
      xsi:schemaLocation="... http://www.springframework.org/schema/mvc/spring-mvc.xsd"
>
    ...
    <mvc:annotation-driven/>
    ...

    <bean id="annotationMethodHandlerAdapter"
          class="org.springframework.web.portlet.mvc.annotation.AnnotationMethodHandlerAdapter">
        <property name="webBindingInitializer">
            <bean
                    class="org.springframework.web.bind.support.ConfigurableWebBindingInitializer">
                <property name="validator">
                    <ref bean="validator"/>
                </property>
            </bean>
        </property>
    </bean>

    <bean id="validator" class="org.springframework.validation.beanvalidation.LocalValidatorFactoryBean"/>
</beans>
```

__src/main/webapp/jsp/view.jsp__ (bootstrap 2 form input):

```jsp
<form:form ...>
    ...
    <spring:bind path="firstName">
        <div class="control-group ${status.error ? 'error' : ''}">
                <form:label path="firstName" cssClass="control-label">First name:</form:label>
            <div class="controls">
                <form:input path="firstName"/>
                <form:errors path="firstName" cssClass="help-inline"/>
            </div>
        </div>
    </spring:bind>
    ...
</form:form>
```
