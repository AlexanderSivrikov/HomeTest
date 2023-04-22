import api.Entry;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

public class ApiTest {

    public List<Entry> getAllEntries(){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.publicapis.org/entries")
                .then()
                .extract()
                .jsonPath()
                .getList("entries", Entry.class);
    }
    public int getEntriesSize(String param){
        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.publicapis.org/entries" + param)
                .then()
                .extract()
                .jsonPath()
                .getInt("entries.size()");
    }
    @Test
    public void checkCategories(){
        List<Entry> categories = getAllEntries().stream().filter(e->e.category.contains("Authentication & Authorization")).collect(Collectors.toList());
        List<String> authCategories = categories.stream().map(Entry::getCategory).collect(Collectors.toList());
        Assert.assertTrue(authCategories.stream().allMatch(x->x.contentEquals("Authentication & Authorization")));
        for (int i = 0; i < categories.size(); i++) {
            System.out.println("[");
            System.out.println("    API: " + categories.get(i).aPI);
            System.out.println("    Description: " + categories.get(i).description + ",");
            System.out.println("    Auth: " + categories.get(i).auth + ",");
            System.out.println("    HTTPS: " + categories.get(i).hTTPS + ",");
            System.out.println("    Cors: " + categories.get(i).cors + ",");
            System.out.println("    Link: " + categories.get(i).link + ",");
            System.out.println("    Category: " + categories.get(i).category);
            System.out.println("]");
        }
        Assert.assertEquals(authCategories.size(), getEntriesSize("?Category=Authentication & Authorization"));
    }
}
