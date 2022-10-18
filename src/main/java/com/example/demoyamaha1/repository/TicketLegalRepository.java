package com.example.demoyamaha1.repository;

import com.example.demoyamaha1.entity.TicketLegal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketLegalRepository extends JpaRepository<TicketLegal, Long> {
    List<TicketLegal> findAllByDateBetween(Date from, Date to);

    List<TicketLegal> findAllByCheckAndDateBetween(int check, Date from, Date to);

    List<TicketLegal> findAllByStatusAndDateBetween(int status, Date from, Date to);

    @Query(value = "SELECT t.pic,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.checked = 1 and t1.pic = t.pic and `date` between :from and :to) as checked_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.checked = 1 and t1.pic = t.pic and `date` between :from and :to) as checked_overdue,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.checked = 0 and t1.pic = t.pic and `date` between :from and :to) as unchecked_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.checked = 0 and t1.pic = t.pic and `date` between :from and :to) as unchecked_overdue,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.status = 0 and t1.pic = t.pic and `date` between :from and :to) as pending_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.status = 0 and t1.pic = t.pic and `date` between :from and :to) as pending_overdue,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.status = 1 and t1.pic = t.pic and `date` between :from and :to) as finished_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.status = 1 and t1.pic = t.pic and `date` between :from and :to) as finished_overdue\n" +
            "FROM ticket_legal t group by t.pic;",
            nativeQuery = true)
    List<Tuple> ReportContractLegalByDate(@Param("from") Date from,
                                              @Param("to") Date to);

    @Query(value = "SELECT \n" +
            "(select 'Total') as `pic`,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.checked = 1 and `date` between :from and :to) as checked_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.checked = 1 and `date` between :from and :to) as checked_overdue,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.checked = 0 and `date` between :from and :to) as unchecked_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.checked = 0 and `date` between :from and :to) as unchecked_overdue,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.status = 0 and `date` between :from and :to) as pending_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.status = 0 and `date` between :from and :to) as pending_overdue,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 1 and t1.status = 1 and `date` between :from and :to) as finished_ontime,\n" +
            "(select count(t1.id) from ticket_legal t1 where t1.ontime = 0 and t1.status = 1 and `date` between :from and :to) as finished_overdue;",
            nativeQuery = true)
    Tuple ReportContractLegalTotalByDate(@Param("from") Date from,
                                             @Param("to") Date to);

//    @Query(nativeQuery = true)
//    List<Tuple> StatisticContractLegal(@Param("from") Date from,
//                                                              @Param("to") Date to);
//
//    @Query(nativeQuery = true)
//    Tuple StatisticContractLegalTotal(@Param("from") Date from,
//                                      @Param("to") Date to);
}
