package stream.arrays.stockmarket.StockAdministrationBackEnd.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringJDBCConfigSQLServer {
    @Value("${dbConnectionPathSQLServer}")
    private String sqlServerPath;

    @Value("${dbServerPasswordSQLServer}")
    private String sqlServerPassword;


    @Bean
    public DataSource sqlServerDataSource(){
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        datasource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=StockMarketAdmin");
        datasource.setUsername("login_app");
        datasource.setPassword("CHANGEME");
        return datasource;
    }
}
