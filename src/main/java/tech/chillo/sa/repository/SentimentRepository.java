package tech.chillo.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tech.chillo.sa.entites.Sentiment;

@Repository
public interface SentimentRepository extends JpaRepository<Sentiment,Long> {
}
