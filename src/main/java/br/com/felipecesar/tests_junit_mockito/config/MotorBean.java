package br.com.felipecesar.tests_junit_mockito.config;

import br.com.felipecesar.tests_junit_mockito.model.Motor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MotorBean {

    @Primary
    @Bean(name = "motorEletrico")
    public Motor motorEletrico() {
        Motor motor = new Motor();
        motor.setLigado(true);
        motor.setVelocidadeMax(120);
        motor.setPotencia(220);
        return motor;
    }

    @Bean(name = "motorUsado")
    public Motor motorUsado() {
        Motor motor = new Motor();
        motor.setLigado(false);
        motor.setVelocidadeMax(80);
        motor.setPotencia(120);
        return motor;
    }

}
