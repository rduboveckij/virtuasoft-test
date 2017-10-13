package com.virtuasoft.rdu.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author rdu
 * @since 13.10.2017
 */
@Slf4j
@Configuration
//@ShellComponent
@ComponentScan
@PropertySource("classpath:application.properties")
public class HiLoGameCommands {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HiLoGameCommands.class);
        HiLoGameService hiLoGameService = context.getBean(HiLoGameService.class);
        hiLoGameService.createPlayer("Bob");
        hiLoGameService.createPlayer("Rob");
        hiLoGameService.createPlayer("Ivan");

        hiLoGameService.startNewGame();

        do {
            String gameWinner = hiLoGameService.playGame().getName();
            int currentGameNumber = hiLoGameService.getCurrentGameNumber();
            log.info("{} player is win {} game ", gameWinner, currentGameNumber);
        } while (!hiLoGameService.isFinished());
        log.info("Absolute winner is " + hiLoGameService.getAbsoluteWinner().getName());
    }

    /*@ShellMethod"Translate text from one language to another.")
    public String translate(
            @ShellOption(mandatory = true) String text,
            @ShellOption(mandatory = true, defaultValue = "en_US") Locale from,
            @ShellOption(mandatory = true) Locate to
    ) {
        // invoke service
        return service.translate(text, from, to);
    }*/

}
