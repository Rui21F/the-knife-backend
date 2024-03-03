package services;

import org.codeforall.bootcamp.persistence.dao.OwnerDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Owner;
import org.codeforall.bootcamp.persistence.model.Restaurant;
import org.codeforall.bootcamp.services.imp.OwnerServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.transaction.TransactionalException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class OwnerServecisImpTest {


    @Mock
    private OwnerDao ownerDao;

    @Mock
    private JpaTransactionManager tx;

    @InjectMocks
    private OwnerServiceImp ownerServiceImp;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createOwnerTestSucceed() {
        Owner owner = new Owner();

        doNothing().when(tx).beginWrite();
        doNothing().when(tx).commit();
        doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(ownerDao.saveOrUpdate(owner)).thenReturn(owner);

        Owner result = ownerServiceImp.createOwner(owner);

        verify(tx).beginWrite();
        verify(ownerDao).saveOrUpdate(owner);
        verify(tx).commit();
        verifyNoMoreInteractions(tx);  // Make sure no other interactions with tx occurred

        assertNotNull(result);
        assertEquals(owner, result);
    }

    @Test
    public void createOwnerTestFailsNameIsEmpty() {
        Owner owner = new Owner();
        owner.setName("");

        doNothing().when(tx).beginWrite();
        ;
        doNothing().when(tx).commit();
        doThrow(new TransactionalException("Simulate roolback", new Exception("Rollback cause"))).when(tx).rollback();

        when(ownerDao.saveOrUpdate(owner)).thenReturn(owner);

        Owner result = ownerServiceImp.createOwner(owner);

        verify(tx).beginWrite();
        verify(ownerDao).saveOrUpdate(owner);
        verify(tx).commit();
        verifyNoMoreInteractions(tx);


        assertTrue(result.getName().isEmpty());
        assertEquals(owner, result);
    }

    @Test
    public void createOwnerTestNameIsValid() {
        Owner owner = new Owner();
        owner.setName("Jonh");

        doNothing().when(tx).beginWrite();
        ;
        doNothing().when(tx).commit();
        doThrow(new TransactionalException("Simulate roolback", new Exception("Rollback cause"))).when(tx).rollback();

        when(ownerDao.saveOrUpdate(owner)).thenReturn(owner);

        Owner result = ownerServiceImp.createOwner(owner);

        verify(tx).beginWrite();
        verify(ownerDao).saveOrUpdate(owner);
        verify(tx).commit();
        verifyNoMoreInteractions(tx);

        assertFalse(result.getName().isEmpty());
        assertEquals(owner, result);
        assertNotNull(result);
    }

    @Test
    public void createOwnerTestRestaurantInvalid() {
        Owner owner = new Owner();
        Restaurant restaurant = new Restaurant();

        restaurant.setOwner(owner);
        owner.setRestaurant(restaurant);

    }
}
