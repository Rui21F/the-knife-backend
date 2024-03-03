package services;

import org.codeforall.bootcamp.persistence.dao.ClientDao;
import org.codeforall.bootcamp.persistence.dao.jpa.JpaTransactionManager;
import org.codeforall.bootcamp.persistence.model.Client;
import org.codeforall.bootcamp.services.imp.ClientServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.transaction.TransactionalException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ClientServiceImpTest {


    @Mock
    private ClientDao clientDao;
    //@Mock
    //private JpaTransactionManager tx;
    @Mock
    private ClientServiceImp clientServiceImpMock;
    @InjectMocks
    private ClientServiceImp clientServiceImp;

    @Before
    public void setup() {
        //instanciar e settar aqui
        clientServiceImp = new ClientServiceImp();
        clientServiceImp.setDao(clientDao);

        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void createClientTestSucceed() {

        Client client = new Client();

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        // Act
        Client result = clientServiceImp.createClient(client);

        // Assert/Verify
        //verify(tx).beginWrite();
        //verify(clientDao).saveOrUpdate(client);
        //verify(tx).commit();
        //verifyNoMoreInteractions(tx);  // Make sure no other interactions with tx occurred

        // Ensure the result is as expected
        // (You might want to assert other properties or conditions based on your implementation)
        assertNotNull(result);
        assertEquals(client, result);

    }

    @Test
    public void createClientTestNameValid() {
        Client client = new Client();
        client.setName("Jonh");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        Client result = clientServiceImp.createClient(client);

        // Assert/Verify
        //verify(tx).beginWrite();
        verify(clientDao).saveOrUpdate(client);
        //verify(tx).commit();
        //verifyNoMoreInteractions(tx);  // Make sure no other interactions with tx occurred

        assertFalse(client.getName().isEmpty());
        assertNotNull(result);
        assertEquals(client, result);
    }

    @Test
    public void createClientTestNameIsEmpty() {
        Client client = new Client();
        client.setName("");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        Client result = clientServiceImp.createClient(client);

        //verify(tx).beginWrite();
        verify(clientDao).saveOrUpdate(client);
        //verify(tx).commit();
        //verifyNoMoreInteractions(tx);  // Make sure no other interactions with tx occurred

        assertTrue(client.getName().isEmpty());
        assertEquals(client, result);
    }

    @Test
    public void updateClientTestNameValid() {
        Client client = new Client();
        client.setName("Jonh");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        Client result = clientServiceImp.updateClient(client);

        //verify(tx).beginWrite();
        //verify(clientDao).saveOrUpdate(client);
        //verify(tx).commit();
        //verifyNoMoreInteractions(tx);  // Make sure no other interactions with tx occurred

        assertFalse(client.getName().isEmpty());
        assertEquals(client, result);
        assertNotNull(result);
    }

    @Test
    public void createClientTestValidEmail() {
        Client client = new Client();
        client.setEmail("test@email.ok");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        Client result = clientServiceImp.createClient(client);

        //verify(tx).beginWrite();
        //verify(clientDao).saveOrUpdate(client);
        //verify(tx).commit();
        //verifyNoMoreInteractions(tx);  // Make sure no other interactions with tx occurred

        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        assertTrue(client.getEmail().matches(emailPattern));
        assertNotNull(result);
    }

    @Test
    public void createClientTestInvalidEmail() {
        Client client = new Client();
        client.setEmail("notvalid@email");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        Client result = clientServiceImp.createClient(client);

        //verify(tx).beginWrite();
        //verify(clientDao).saveOrUpdate(client);
        //verify(tx).commit();
        //verifyNoMoreInteractions(tx);  // Make sure no other interactions with tx occurred

        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        assertFalse(client.getEmail().matches(emailPattern));
    }

    @Test
    public void updateClientTestNameIsEmpty() {
        Client client = new Client();
        client.setName("");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        clientServiceImp.updateClient(client);

        verify(clientDao).saveOrUpdate(client);

        assertTrue(client.getName().isEmpty());
    }

    @Test
    public void updateClientTestValidEmail() {
        Client client = new Client();
        client.setEmail("test@email.ok");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        Client result = clientServiceImp.updateClient(client);

        verify(clientDao).saveOrUpdate(client);

        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        assertTrue(client.getEmail().matches(emailPattern));
        assertNotNull(result);
    }

    @Test
    public void updateClientTestInvalidEmail() {
        Client client = new Client();
        client.setEmail("notvalid@email");

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        when(clientDao.saveOrUpdate(client)).thenReturn(client);

        Client result = clientServiceImp.updateClient(client);

        verify(clientDao).saveOrUpdate(client);

        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        assertFalse(client.getEmail().matches(emailPattern));
    }

    @Test
    public void deleteClientTestSucceed() {
        int fakeId = 999;

        //doNothing().when(tx).beginWrite();
        //doNothing().when(tx).commit();
        //doThrow(new TransactionalException("Simulate rollback", new Exception("Rollback cause"))).when(tx).rollback();

        clientServiceImp.deleteClient(fakeId);

        verify(clientDao).delete(fakeId);

        assertNotNull(fakeId);
    }

    @Test
    public void deleteClientTestFail() {
        int fakeId = 999;

        //doNothing().when(tx).beginWrite();

        clientServiceImp.deleteClient(fakeId);

        verify(clientDao).delete(fakeId);

        assertNull(clientDao.findById(fakeId));
    }

    @Test
    public void getClientByIdTestSucceed() {
        int fakeId = 999;
        Client expectedClient = new Client();

        when(clientDao.findById(fakeId)).thenReturn(expectedClient);

        Client actualClient = clientServiceImp.getClientById(fakeId);

        verify(clientDao).findById(fakeId);

        assertEquals(expectedClient, actualClient);
    }

    @Test
    public void getAllClient(){
        List<Client> list = new ArrayList<>();

        when(clientServiceImpMock.getAllClient()).thenReturn(list);

        //doNothing().when(tx).beginWrite();

        clientServiceImpMock.getAllClient();

        verify(clientServiceImpMock).getAllClient();

        assertEquals(clientServiceImpMock.getAllClient(), list);
    }
}
