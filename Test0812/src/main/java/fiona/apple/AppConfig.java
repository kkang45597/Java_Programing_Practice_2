package fiona.apple;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fiona.apple")
class AppConfig {

    @Bean
    public Command command() {
        return new ConcreteCommand();
    }

    @Bean
    public CommandManager commandManager() {
//        return new CommandManager();
    	CommandManager cm = new CommandManager();
    	return cm;
    }
}