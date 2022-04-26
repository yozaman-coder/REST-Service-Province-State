package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "agents")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AgentId", nullable = false)
    private Integer agentId;

    @Column(name = "AgtFirstName", length = 20)
    private String agtFirstName;

    @Column(name = "AgtMiddleInitial", length = 5)
    private String agtMiddleInitial;

    @Column(name = "AgtLastName", length = 20)
    private String agtLastName;

    @Column(name = "AgtBusPhone", length = 20)
    private String agtBusPhone;

    @Column(name = "AgtEmail", length = 50)
    private String agtEmail;

    @Column(name = "AgtPosition", length = 20)
    private String agtPosition;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "AgencyId")
    private Integer agencyId;


    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer id) {
        this.agentId = id;
    }

    public String getAgtFirstName() {
        return agtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName = agtFirstName;
    }

    public String getAgtMiddleInitial() {
        return agtMiddleInitial;
    }

    public void setAgtMiddleInitial(String agtMiddleInitial) {
        this.agtMiddleInitial = agtMiddleInitial;
    }

    public String getAgtLastName() {
        return agtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        this.agtLastName = agtLastName;
    }

    public String getAgtBusPhone() {
        return agtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone = agtBusPhone;
    }

    public String getAgtEmail() {
        return agtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail = agtEmail;
    }

    public String getAgtPosition() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agency) {
        this.agencyId = agency;
    }

}