package administration.daos;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max on 28.05.2017.
 */


@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class AbstractChallengeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long challengeId;

    @Version
    protected Long version;


    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated;

    protected AbstractChallengeEntity() {}

    public Date getCreated()
    {
        return created;
    }

    private void setCreated(Date created)
    {
        this.created = created;
    }

    public long getChallengeId()
    {
        return challengeId;
    }

    public void setChallengeId(Long challengeId)
    {
        this.challengeId = challengeId;
    }

    public Date getUpdated()
    {
        return updated;
    }

    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }

    public Long getVersion()
    {
        return version;
    }

    public void setVersion(Long version)
    {
        this.version = version;
    }


    /*
        JPA Helper Methods
     */

    @PrePersist
    void onCreate()
    {
        System.out.println( "OnCreate" );
        this.setCreated( new Date() );
    }

    @PreUpdate
    void onUpdate()
    {
        System.out.println( "OnUpdate" );
        this.setUpdated( new Date() );
    }

    @Override
    public String toString() {
        return "AbstractChallengeEntity{" +
                "id=" + challengeId +
                ", created=" + created +
                ", version=" + version +
                ", updated=" + updated +
                '}';
    }


}
