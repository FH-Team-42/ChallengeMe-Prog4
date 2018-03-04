package administration.daos;

/**
 * Created by Max on 28.05.2017.
 */


import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;



/*
    Our generic Dao for all model objects

    It has package-local visibility - thus, instances can only be created inside
    this package. Using this approach, we can prevent any class from the outside of
    this package to create Dao instances.

    Anyone, who needs a Dao must therefore use our DataController class.

 */
class GenericDao<T> implements IGenericDao<T>
{
    private final Class<T> persistentClass;
    private EntityManager entityManager;

    public GenericDao(Class<T> type, EntityManager em )
    {
        this.persistentClass = type;
        this.entityManager = em;
    }

    /**
     * Get a dao by ID
     * @param id The Daos ID to search for
     * @return The requested Dao
     */
    public T findById( final Long id )
    {
        final T result = getEntityManager().find( persistentClass, id );
        return result;
    }

    /**
     * Get a complete collection of Daos
     * @return The Dao collection
     */
    public Collection<T> findAll()
    {
        Query query = getEntityManager().createQuery(
                "SELECT e FROM " + getEntityClass().getCanonicalName() + " e" );
        return (Collection<T>) query.getResultList();
    }

    /**
     * Create a new entry
     * @param entity The object to create the entry for
     */
    public void create( T entity )
    {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist( entity );
        getEntityManager().getTransaction().commit();
    }

    /**
     * Create new entries for every item in a collection
     * @param newEntities The item collection
     */
    public void createAll( Collection<T> newEntities )
    {
        getEntityManager().getTransaction().begin();

        for( T entry : newEntities )
            getEntityManager().persist( entry );

        getEntityManager().getTransaction().commit();
    }

    /**
     * Update the given entity
     * @param entity The entity to update
     * @return The updated entity
     */
    public T update( T entity )
    {
        getEntityManager().getTransaction().begin();
        final T savedEntity = getEntityManager().merge( entity );
        getEntityManager().getTransaction().commit();

        return savedEntity;
    }

    /**
     * Delete an entry by ID
     * @param id The ID of the entry to delete
     */
    public void delete( Long id )
    {
        T entity = this.findById( id );
        this.delete( entity );
    }

    /**
     * Delete an entry
     * @param entity The entity to delete
     */
    public void delete( T entity )
    {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove( entity );
        getEntityManager().getTransaction().commit();
    }

    /**
     * Delete a list of entries
     * @param entries The list of entries to delete
     */
    public void delete( List<T> entries )
    {
        getEntityManager().getTransaction().begin();

        for( T entry : entries )
        {
            getEntityManager().remove( entry );
        }

        getEntityManager().getTransaction().commit();
    }

/*
    Getter & Setter
 */

    /**
     * Get the class type for this entity
     * @return The class type
     */
    public Class<T> getEntityClass()
    {
        return persistentClass;
    }

    /**
     * Set this instances entity manager
     * @param entityManager The entity manager to assign
     */
    public void setEntityManager( final EntityManager entityManager )
    {
        this.entityManager = entityManager;
    }

    /**
     * Get this instances entity manager
     * @return The entity manager of this instance
     */
    public EntityManager getEntityManager()
    {
        return entityManager;
    }

}


