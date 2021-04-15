package io.flats.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Role()).canEqual("Other"));
        assertFalse((new Role()).canEqual("Other"));
    }

    @Test
    public void testCanEqual2() {
        Role role = new Role();

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertTrue(role.canEqual(role1));
    }

    @Test
    public void testCanEqual3() {
        Role role = new Role();

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertTrue(role.canEqual(role1));
    }

    @Test
    public void testEquals() {
        assertFalse((new Role()).equals("42"));
        assertFalse((new Role()).equals("42"));
    }

    @Test
    public void testEquals2() {
        Role role = new Role();

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertFalse(role.equals(role1));
    }

    @Test
    public void testEquals3() {
        Role role = new Role();
        assertTrue(role.equals(new Role()));
    }

    @Test
    public void testEquals4() {
        Role role = new Role();
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertTrue(role.equals(role1));
    }

    @Test
    public void testEquals5() {
        Role role = new Role();
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);
        assertFalse(role.equals(role1));
    }

    @Test
    public void testEquals6() {
        Role role = new Role();

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertFalse(role.equals(role1));
    }

    @Test
    public void testEquals7() {
        Role role = new Role();
        assertTrue(role.equals(new Role()));
    }

    @Test
    public void testEquals8() {
        Role role = new Role();
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertTrue(role.equals(role1));
    }

    @Test
    public void testEquals9() {
        Role role = new Role();
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);
        assertFalse(role.equals(role1));
    }

    @Test
    public void testHashCode() {
        assertEquals(102, (new Role()).hashCode());
        assertEquals(102, (new Role()).hashCode());
    }

    @Test
    public void testHashCode2() {
        Role role = new Role();
        role.setName("Name");
        assertEquals(2420454, role.hashCode());
    }

    @Test
    public void testHashCode3() {
        Role role = new Role();
        role.setName("Name");
        assertEquals(2420454, role.hashCode());
    }

    @Test
    public void testSetName() {
        Role role = new Role();
        role.setName("Name");
        assertEquals("Role(name=Name)", role.toString());
    }

    @Test
    public void testSetName2() {
        Role role = new Role();
        role.setName("Name");
        assertEquals("Role(name=Name)", role.toString());
    }

    @Test
    public void testToString() {
        assertEquals("Role(name=null)", (new Role()).toString());
        assertEquals("Role(name=null)", (new Role()).toString());
    }
}
