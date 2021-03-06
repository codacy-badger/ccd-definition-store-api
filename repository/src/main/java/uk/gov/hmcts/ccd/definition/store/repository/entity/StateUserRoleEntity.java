package uk.gov.hmcts.ccd.definition.store.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Table(name = "state_user_role")
@Entity
public class StateUserRoleEntity extends Authorisation implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable=false)
    private StateEntity stateEntity;

    public StateEntity getStateEntity() {
        return stateEntity;
    }

    public void setStateEntity(final StateEntity stateEntity) {
        this.stateEntity= stateEntity;
    }

}
