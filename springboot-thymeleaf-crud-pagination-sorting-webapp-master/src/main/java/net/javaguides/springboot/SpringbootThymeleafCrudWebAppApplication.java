package net.javaguides.springboot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootThymeleafCrudWebAppApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootThymeleafCrudWebAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeleafCrudWebAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner exemplo(EmployeeRepository repo){
		return(args) -> {
			repo.deleteAll();

			//abrir arquivo
			try {
				FileReader reader = new FileReader("arquivo.txt");
				BufferedReader leitor = new BufferedReader(reader);
				String linhaCompleta = leitor.readLine();
				String[] separado = linhaCompleta.split(",");
				repo.save(new Employee(separado[0],separado[1],separado[2]));

				linhaCompleta = leitor.readLine();
			  	separado = linhaCompleta.split(",");
				repo.save(new Employee(separado[0],separado[1],separado[2]));

				System.out.println(leitor.readLine());
			} catch (IOException ex) {
				System.out.println("Erro :"+ex.getMessage());
			}
	
			//ler primeira linha

			//gerar empregado

			//salvar empregado

			repo.save(new Employee("Marcelo","Telles"));
			repo.save(new Employee("Sidnei","Ferreira"));
			repo.save(new Employee("Isaac","Leite"));
			repo.save(new Employee("Kaua","Ferreira"));
		};
	}
}
