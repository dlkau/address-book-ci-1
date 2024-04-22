/**
 * This test is used to test the creation of a Contact Class
 */

import com.example.addressbook.model.Contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {
    private Contact contact;
    @BeforeEach
    public void setUp(){
        contact = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
    }
    @Test
    public void testGetId(){
        contact.setID(1);
        assertEquals(1, contact.getId());
    }
    @Test
    public void testGetFirstName(){
        assertEquals("John", contact.getFirstName());
    }
    @Test
    public void testSetFirstName(){
        contact.setFirstname("Jane");
        assertEquals("Jane", contact.getFirstName());
    }
    @Test
    public void testGetLastName(){
        assertEquals("Doe", contact.getLastName());
    }
    @Test
    public void testSetLastName(){
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }
    @Test
    public void testGetEmail(){
        assertEquals("john.doe@example.com", contact.getEmail());
    }
    @Test
    public void testSetEmail(){
        contact.setEmail("jane.smith@example.com");
        assertEquals("jane.smith@example.com", contact.getEmail());
    }
    @Test
    public void testGetPhone(){
        assertEquals("1234567890", contact.getPhone());
    }
    @Test
    public void testSetPhone(){
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }
    @Test
    public void testGetFullName(){
        assertEquals("John Doe(john.doe@example.com)", contact.getFullName());
    }
    @Test
    public void testEmailValidatorAgainstInvalidEmail(){
        String currEmail = contact.getEmail();
        contact.setEmail("Thisisnotanmailaddress");
        assertEquals(currEmail, contact.getEmail());
    }
    @Test
    public void testEmailValidatorAgainstValidEmail(){
        contact.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", contact.getEmail());
    }


}
