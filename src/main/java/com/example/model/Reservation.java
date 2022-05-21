package com.example.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "User_id", referencedColumnName = "id")
    @Column
    private Integer idUser;

    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "Announce_id", referencedColumnName = "id")
    @Column
    private Integer idAnnounce;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private Integer acceptState;

    public Reservation() {
    }

    public Reservation(Integer id, Integer idUser, Integer idAnnounce, Date startDate, Date endDate, Integer acceptState) {
        this.id = id;
        this.idUser = idUser;
        this.idAnnounce = idAnnounce;
        this.startDate = startDate;
        this.endDate = endDate;
        this.acceptState = acceptState;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public Integer getIdAnnounce() {
        return idAnnounce;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Integer getAcceptState() {
        return acceptState;
    }
}
