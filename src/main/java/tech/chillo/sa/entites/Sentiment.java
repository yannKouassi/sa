package tech.chillo.sa.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.chillo.sa.enums.TypeSentiment;

import static jakarta.persistence.CascadeType.MERGE;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texte;

    @Enumerated(EnumType.STRING)
    private TypeSentiment type;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}
