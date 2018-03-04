package administration.daos;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max.
 *
 * This class is the abstract entry for a challenge in the database. It includes the id, the version, the creation
 * date and the update date of a challenge.
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

    /**
     * Get the date the challenge was created on
     *
     * @return The creation date
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * Set the date the challenge was created on
     *
     * @param created The creation date
     */
    private void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * Get the Challenge-ID
     *
     * @return The Challenge-ID
     */
    public long getChallengeId()
    {
        return challengeId;
    }

    /**
     * Set the Challenge-ID
     *
     * @param challengeId The Challenge-ID
     */
    public void setChallengeId(Long challengeId)
    {
        this.challengeId = challengeId;
    }

    /**
     * Get the last time the challenge was updated
     *
     * @return The date of the last update
     */
    public Date getUpdated()
    {
        return updated;
    }

    /**
     * Set the last time the challenge was updated
     *
     * @param updated The date of the last update
     */
    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }

    /**
     * Get the challenges version
     *
     * @return The version number
     */
    public Long getVersion()
    {
        return version;
    }

    /**
     * Set the challenges version
     *
     * @param version The new version
     */
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
