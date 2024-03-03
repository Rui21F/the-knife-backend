package dao;

import org.codeforall.bootcamp.persistence.dao.jpa.JpaClientDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaSessionManager;
import org.codeforall.bootcamp.persistence.model.Client;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JpaClientDaoTest {

    protected Class<Client> modelType;
    @Mock
    private JpaSessionManager sm;
    @Mock
    private EntityManager em;
    @InjectMocks
    private JpaClientDao dao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        modelType = Client.class;
        dao.setModelType(modelType);

        // Mock the behavior of EntityManager
        when(sm.getCurrentSession()).thenReturn(em);
    }

    @Test
    public void testFindAll() {

       /* // Create a mock TypedQuery
        TypedQuery<Client> query = mock(TypedQuery.class);

        // Create a list of sample clients
        List<Client> clients = new ArrayList<>();

        // Mock the behavior of EntityManager
        when(em.createQuery(any(CriteriaQuery.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(clients);

        // Use Mockito.when to specify the behavior of dao.findAll()
        when(dao.findAll()).thenReturn(clients);

        // Call the method you want to test
        List<Client> result = dao.findAll();

        // Verify that the appropriate methods were called
        verify(sm).getCurrentSession();
        verify(em).createQuery(any(CriteriaQuery.class));
        verify(query).getResultList();

        // Verify the result
        assertEquals(clients, result);*/
    }

}

