package thashort.gamer.candidateapp.model.entity;

import lombok.Data;

@Data
public class Status {
    private String _value_;

    protected Status(String value){
        _value_ = value;
    }

    public static final String _PENDING = "PENDING";
    public static final String _APPROVED = "APPROVED";
    public static final String _DECLINED = "DECLINED";

}
