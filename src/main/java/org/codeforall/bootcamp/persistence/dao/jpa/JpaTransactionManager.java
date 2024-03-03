package org.codeforall.bootcamp.persistence.dao.jpa;

public class JpaTransactionManager {
    private JpaSessionManager sm;

    /**
     * Initializes a new {@code JPA Transaction Manager} instance given a session manager
     *
     * @param sm the session manager
     */
    public JpaTransactionManager(JpaSessionManager sm) {
        this.sm = sm;
    }

    public void beginRead() {
        sm.startSession();
    }

    public void beginWrite() {
        sm.getCurrentSession().getTransaction().begin();
    }

    public void commit() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().commit();
        }

        sm.stopSession();
    }

    public void rollback() {

        if (sm.getCurrentSession().getTransaction().isActive()) {
            sm.getCurrentSession().getTransaction().rollback();
        }

        sm.stopSession();
    }
}
