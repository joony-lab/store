package newmcdonaldapp;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="StoreManagement_table")
public class StoreManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @PrePersist
    public void onPrePersist(){
        DeliveryStart deliveryStart = new DeliveryStart();
        BeanUtils.copyProperties(this, deliveryStart);
        deliveryStart.publishAfterCommit();


        CookStarted cookStarted = new CookStarted();
        BeanUtils.copyProperties(this, cookStarted);
        cookStarted.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




}
