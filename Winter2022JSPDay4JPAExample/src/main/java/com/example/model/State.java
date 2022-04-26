package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StateID", nullable = false)
    private Integer stateID;

    @Column(name = "StateCode", length = 32)
    private String stateCode;

    @Column(name = "StateName", length = 64)
    private String stateName;

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer id) {
        this.stateID = id;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

}