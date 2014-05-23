package pl.projekt5.models;

import java.sql.Connection;

/**
 *
 * @author Kuba
 */
public interface Model {
    public void initializeModel(Connection c);
}
