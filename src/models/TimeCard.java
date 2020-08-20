package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "timecards")
@NamedQueries({
    @NamedQuery(
            name = "getAllTimeCards",
            query = "SELECT r FROM TimeCard AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getTimeCardsCount",
            query = "SELECT COUNT(r) FROM TimeCard AS r"
            ),
    @NamedQuery(
            name = "getMyAllTimeCards",
            query = "SELECT r FROM TimeCard AS r WHERE r.employee = :employee ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getMyTimeCardsCount",
            query = "SELECT COUNT(r) FROM TimeCard AS r WHERE r.employee = :employee"
            ),

})
@Entity
public class TimeCard {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "timecard_date")
    private Timestamp timecard_date;

    @Column(name = "started_at")
    private Timestamp started_at;

    @Column(name = "finished_at")
    private Timestamp finished_at;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public Timestamp getTimecard_date(){
        return timecard_date;
    }

    public void setTimecard_date(Timestamp timecard_date){
        this.timecard_date = timecard_date;
    }

    public Timestamp getStarted_at(){
        return started_at;
    }

    public void setStarted_at(Timestamp started_at){
        this.started_at = started_at;
    }

    public Timestamp getFinished_at(){
        return finished_at;
    }

    public void setFinished_at(Timestamp finished_at){
        this.finished_at = finished_at;
    }

}