package za.co.wethinkcode.robotworlds.Server.persistence.pkg;

import za.co.wethinkcode.robotworlds.Server.persistence.DbConnect;

import java.sql.PreparedStatement;

public class DBDelete {

    public DBDelete() {

    }

    public void DeleteAll() {
        try (PreparedStatement st = DbConnect.connection.prepareStatement("DELETE FROM Obstacles;")){
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement st = DbConnect.connection.prepareStatement("DELETE FROM Robots;")){
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (PreparedStatement st = DbConnect.connection.prepareStatement("DELETE FROM Worlds;")){
            st.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
