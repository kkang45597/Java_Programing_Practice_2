package fiona.apple;
import java.util.Map;

interface Command {
    void setState(Map<String, Object> state);
    Object execute();
}