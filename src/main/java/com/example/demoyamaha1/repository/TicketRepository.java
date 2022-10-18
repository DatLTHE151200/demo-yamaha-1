package com.example.demoyamaha1.repository;

import com.example.demoyamaha1.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.Date;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "select distinct t.id, c.ed, c.name, c.counterparty, c.transaction, t.assign_date, t.pending_at, t.complete_date, t.scan_submitted, c.pic as ed_pic,\n" +
            "tl.pic as legal_pic, tl.ontime as legal_ontime,tl.approved as leagal_approval,(select count(tl1.id) from ticket_legal tl1 where tl1.ticket_id = t.id and tl1.checked = 1) as count_legal_check,\n" +
            "ta.pic as acct_pic, ta.ontime as acct_ontime,ta.approved as acct_approval,(select count(ta1.id) from ticket_acct ta1 where ta1.ticket_id = t.id and ta1.checked = 1) as count_acct_check,\n" +
            "t.edit_no\n" +
            "from  demo_yamaha.ticket t\n" +
            "inner join demo_yamaha.contracts c on t.contract_id = c.id \n" +
            "inner join ticket_legal tl on tl.ticket_id = t.id \n" +
            "inner join ticket_acct ta on ta.ticket_id = t.id\n" +
            "where t.assign_date between :from and :to\n" +
            "group by c.id, t.id;",
    nativeQuery = true)
    List<Tuple> findReportRegularByDate(@Param("from")Date from,
                                        @Param("to")Date to);
}
