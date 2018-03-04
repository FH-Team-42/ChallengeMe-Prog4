package administration.daos;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max.
 *
 * This class represents the abstract database entry for a user. It contains an id, a version,
 * a creation date, an update date and the last login date of the user.
 *
 */


@Entity
@Inheritance( strategy = InheritanceType.JOINED )
public abstract class AbstractUserEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long userId;

    @Version
    protected Long version;


    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated;

    @Temporal( TemporalType.TIMESTAMP )
    private Date lastLogin;

    protected AbstractUserEntity() {}

    /**
     * Get the date the user was created
     *
     * @return The creation date
     */
    public Date getCreated()
    {
        return created;
    }

    /**
     * Set the date the user was created
     *
     * @param created The creation date
     */
    private void setCreated(Date created)
    {
        this.created = created;
    }

    /**
     * Get the users unique User-ID
     *
     * @return The User-ID
     */
    public long getUserId()
    {
        return userId;
    }

    /**
     * Set the users unique User-ID
     *
     * @param userId The new User-ID
     */
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    /**
     * Get the date of the last update for the user
     *
     * @return The last update date
     */
    public Date getUpdated()
    {
        return updated;
    }

    /**
     * Set the latest update date for the user
     *
     * @param updated The new update date
     */
    public void setUpdated(Date updated)
    {
        this.updated = updated;
    }

    /**
     * Get the Version of the user
     *
     * @return The version
     */
    public Long getVersion()
    {
        return version;
    }

    /**
     * Set the version of the user
     *
     * @param version The new version
     */
    public void setVersion(Long version)
    {
        this.version = version;
    }

    /**
     * Get the date of the last login for the user
     *
     * @return The last login date
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * Set the last login date for the user
     *
     * @param lastLogin The new last login date
     */
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
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
                "id=" + userId +
                ", created=" + created +
                ", version=" + version +
                ", updated=" + updated +
                '}';
    }


}
