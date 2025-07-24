import java.io.IOException;

public interface SerializableEntity {
    void serializeToFile(String filename) throws IOException;
}
