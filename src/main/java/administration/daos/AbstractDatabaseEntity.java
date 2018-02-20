package administration.daos;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Max on 28.05.2017.
 */


@Entity
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class AbstractDatabaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;

    @Version
    protected Long version;


    @Temporal(TemporalType.TIMESTAMP)
    protected Date created;
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updated;

    protected AbstractDatabaseEntity() {}

    public Date getCreated()
    {
        return created;
    }

    private void setCreated(Date created)
    {
        this.created = created;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
        return "AbstractDatabaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", version=" + version +
                ", updated=" + updated +
                '}';
    }


}
