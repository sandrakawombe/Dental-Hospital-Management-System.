package snakayima.miu.edu.dentalhospitalmgmtsystem.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import snakayima.miu.edu.dentalhospitalmgmtsystem.Domain.Appointment;

import java.time.LocalDate;
import java.util.List;

@Service
public class CriteriaQueryService {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Appointment> findAppointmentsWithCriteria(String title, LocalDate date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Appointment> query = cb.createQuery(Appointment.class);
        Root<Appointment> root = query.from(Appointment.class);

        Predicate titlePredicate = cb.equal(root.get("title"), title);
        Predicate datePredicate = cb.equal(root.get("date"), date);

        query.select(root).where(cb.and(titlePredicate, datePredicate));
        return entityManager.createQuery(query).getResultList();
    }
}
