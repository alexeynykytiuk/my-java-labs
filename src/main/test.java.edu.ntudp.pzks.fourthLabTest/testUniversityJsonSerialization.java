import edu.ntudp.pzks.fourthLab.JsonManager;
import edu.ntudp.pzks.fourthLab.controllers.UniversityCreator;
import edu.ntudp.pzks.fourthLab.models.University;
import org.junit.Assert;
import org.junit.Test;

public class testUniversityJsonSerialization {
    @Test
    public void testUniversityJsonSerialization() {
        UniversityCreator universityCreate = new UniversityCreator();
        JsonManager jsonManager = new JsonManager();
        University oldUniversity = universityCreate.createTypicalUniversity();
        // Записати університет у файл
        jsonManager.writeToJsonFile("university.json", oldUniversity);

        // Зчитати університет з файлу
        University newUniversity = jsonManager.readFromJsonFile("university.json");

        // Порівняти два університети
        Assert.assertEquals(oldUniversity, newUniversity);
    }
}
