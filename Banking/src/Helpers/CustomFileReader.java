package Helpers;

import java.util.List;

public abstract class CustomFileReader{
    public abstract List<Object> read(String path, String objectType);
}
