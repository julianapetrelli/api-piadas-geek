# Conexão com Banco de Dados
spring.datasource.url=jdbc:mysql://localhost/webpiadas?autoReconnect=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.generate-ddl=true

# Exibir Instruções SQL em Console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

<!-- Inclusão de ORM/JPA [ Modelagem Objeto relacional ] -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>