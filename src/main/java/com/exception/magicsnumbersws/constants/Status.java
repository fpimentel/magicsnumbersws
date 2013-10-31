/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exception.magicsnumbersws.constants;

/**
 *
 * @author fpimentel
 */
public enum Status {

    ACTIVE(1, "ACTIVO", 1),
    TICKET_PENDIENTE(3, "PENDIENTE", 2);
    private int id;
    private String name;
    private int statusTypeId;

    Status(int id, String name, int statusTypeId) {
        this.id = id;
        this.name = name;
        this.statusTypeId = statusTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(int statusTypeId) {
        this.statusTypeId = statusTypeId;
    }
}
