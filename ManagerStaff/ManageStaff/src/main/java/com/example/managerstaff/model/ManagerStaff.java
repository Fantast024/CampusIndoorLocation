package com.example.managerstaff.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ManagerStaff {
    @NonNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NonNull
    private String staffId;
    @NonNull
    private int audiance;
    @NonNull
    private int building;
    @NonNull
    private String locationName;
    @NonNull
    private LocalDateTime date;
    @NonNull
    private String staffName;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
    @NonNull
    private boolean status;

    public ManagerStaff(String staffId, String locationName, int audiance, int building, LocalDateTime date, String staffName) {
        this.staffId = staffId;
        this.staffName = staffName;
        Staff location = new Staff(locationName, audiance, building);
        this.locationName = location.getName();
        this.audiance = location.getAudiance();
        this.building = location.getBuilding();
        this.date = date;
    }

    @PrePersist
    void onCreate() {
        this.setCreateTime(LocalDateTime.now());
        this.setModifiedTime(LocalDateTime.now());
    }

    private void setModifiedTime(LocalDateTime now) {
    }

    private void setCreateTime(LocalDateTime now) {
    }

    @PreUpdate
    void onUpdate() {
        this.setModifiedTime(LocalDateTime.now());
    }


    public boolean isStatus() {
        return status;
    }

    public void setStaffId(String staffId) {
    }

    public void getStaffId(String staffId) {
        return;

    }
}

