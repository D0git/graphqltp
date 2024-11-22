package ma.projet.graph.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor  // Génère un constructeur sans arguments
@AllArgsConstructor // Génère un constructeur avec tous les arguments
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date; // Le type de date est Date

    @ManyToOne
    private Compte compte; // La relation ManyToOne avec Compte

    @Enumerated(EnumType.STRING)
    private TypeTransaction type; // Type de la transaction, basé sur l'enum

    private double montant; // Montant de la transaction, de type double
}
