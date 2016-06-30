package com.dbserver.exercise.restaurant.model;

public class VoteResponse {
    private Boolean valid;
    private String reason;

    public VoteResponse(Boolean Valid, String reason) {
        this.valid = Valid;
        this.reason = reason;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
