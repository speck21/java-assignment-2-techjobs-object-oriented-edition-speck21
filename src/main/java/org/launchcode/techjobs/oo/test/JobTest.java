package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job j1 = new Job();
        Job j2 = new Job();
        assertNotEquals(j1,j2);
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job j1 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertTrue(j1.getName() instanceof String);
        assertEquals(j1.getName(), "Product Tester");
        assertTrue(j1.getEmployer() instanceof Employer);
        assertEquals(j1.getEmployer().getValue(), "ACME");
        assertTrue(j1.getLocation() instanceof Location);
        assertEquals(j1.getLocation().getValue(), "Desert");
        assertTrue(j1.getPositionType() instanceof PositionType);
        assertEquals(j1.getPositionType().getValue(), "Quality Control");
        assertTrue(j1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(j1.getCoreCompetency().getValue(), "Persistence");
    }
    @Test
    public void testJobsForEquality(){
        Job j1 = new Job("a", new Employer("a"), new Location("a"), new PositionType("a"), new CoreCompetency("a"));
        Job j2 = new Job("a", new Employer("a"), new Location("a"), new PositionType("a"), new CoreCompetency("a"));
        assertFalse(j1.equals(j2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job j1 = new Job("aName", new Employer("aEmployer"), new Location("aLocation"), new PositionType("aPositionType"), new CoreCompetency("aCoreCompetency"));

        assertEquals(j1.toString().charAt(0),'\n');
        assertEquals(j1.toString().charAt(j1.toString().length()-1),'\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job j1 = new Job("aName", new Employer("aEmployer"), new Location("aLocation"), new PositionType("aPositionType"), new CoreCompetency("aCoreCompetency"));

        assertEquals(j1.toString(),
                "\n"+
                "ID: "+j1.getId()+"\n" +
                "Name: "+j1.getName()+"\n" +
                "Employer: "+j1.getEmployer().getValue()+"\n" +
                "Location: "+j1.getLocation().getValue()+"\n" +
                "Position Type: "+ j1.getPositionType().getValue()+"\n" +
                "Core Competency: "+j1.getCoreCompetency().getValue()+
                "\n");

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job j1 = new Job("", new Employer("aEmployer"), new Location(""), new PositionType("aPositionType"), new CoreCompetency("aCoreCompetency"));
        assertEquals(j1.toString(),
                "\n"+
                        "ID: "+j1.getId()+"\n" +
                        "Name: "+"Data not available"+"\n" +
                        "Employer: "+j1.getEmployer().getValue()+"\n" +
                        "Location: "+"Data not available"+"\n" +
                        "Position Type: "+ j1.getPositionType().getValue()+"\n" +
                        "Core Competency: "+j1.getCoreCompetency().getValue()+
                        "\n");
    }

}
