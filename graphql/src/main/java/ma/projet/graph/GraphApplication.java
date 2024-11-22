package ma.projet.graph;

import ma.projet.graph.entities.Compte;
import ma.projet.graph.entities.Transaction;
import ma.projet.graph.entities.TypeCompte;
import ma.projet.graph.entities.TypeTransaction;
import ma.projet.graph.repositories.CompteRepository;
import ma.projet.graph.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class GraphApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository, TransactionRepository transactionRepository) {
		return args -> {
			// Initialisation des comptes
			Compte compte1 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			Compte compte2 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT));
			Compte compte3 = compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));

			// Ajouter des transactions pour chaque compte
			// L'ID est généré automatiquement, donc il faut passer null pour le champ ID.
			transactionRepository.save(new Transaction(null, new Date(), compte1, TypeTransaction.DEPOT, 1000.0));
			transactionRepository.save(new Transaction(null, new Date(), compte1, TypeTransaction.RETRAIT, 200.0));

			transactionRepository.save(new Transaction(null, new Date(), compte2, TypeTransaction.DEPOT, 500.0));
			transactionRepository.save(new Transaction(null, new Date(), compte2, TypeTransaction.RETRAIT, 300.0));

			transactionRepository.save(new Transaction(null, new Date(), compte3, TypeTransaction.DEPOT, 700.0));
			transactionRepository.save(new Transaction(null, new Date(), compte3, TypeTransaction.RETRAIT, 150.0));

			System.out.println("Transactions ajoutées pour les comptes.");
		};
	}



}
