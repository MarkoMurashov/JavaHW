package edu.dnu.fpm.pz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static edu.dnu.fpm.pz.ConnectionHelper.getConnection;
import static java.util.Objects.requireNonNull;

public class OwnerCRUD implements ICRUD<Owner> {
    final String INSERT_QUERY = "INSERT INTO owners (NAME, Surname, City)\n" +
            "VALUES (?, ?, ? )";
    final String SELECT_QUERY = "SELECT * FROM Owners";
    final String SELECT_WITH_FILTER_QUERY = "SELECT * FROM owners where id = ?";
    final String UPDATE_QUERY = "UPDATE Owners SET NAME = ?, Surname = ?, " +
            " City = ? WHERE id = ?;";
    final String DELETE_QUERY = "DELETE FROM owners WHERE id = ?";


    public Integer save(Owner owner) throws Exception {
        requireNonNull(owner, "owner could not be null");
        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(INSERT_QUERY);
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getSurname());
            ps.setString(3, owner.getCity());

            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveAll(Collection<Owner> owners) {
        try (Connection ConnecntionToDB = getConnection()){
            ConnecntionToDB.setAutoCommit(false);
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(INSERT_QUERY);
            for (Owner owner : owners) {
                ps.setString(1, owner.getName());
                ps.setString(2, owner.getSurname());
                ps.setString(3, owner.getCity());
                ps.addBatch();
            }

            ps.executeBatch();
            ConnecntionToDB.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Owner findById(Integer id) {
        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(SELECT_WITH_FILTER_QUERY);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return getOwnerFromResultSetRow(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Collection<Owner> findAll() {
        List<Owner> owners = new ArrayList<Owner>();
        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(SELECT_QUERY);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                owners.add(getOwnerFromResultSetRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owners;
    }

    private Owner getOwnerFromResultSetRow(ResultSet result) throws SQLException {
        return new Owner(result.getInt(1), result.getString(2),
                result.getString(3), result.getString(4));
    }

    public void update(Owner owner) {
        requireNonNull(owner, "Couldn't update null owner");
        requireNonNull(owner.getId(), "Couldn't update owner with null id");

        try (Connection ConnecntionToDB = getConnection()){

            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(UPDATE_QUERY);
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getSurname());
            ps.setString(3, owner.getCity());
            ps.setInt(4, owner.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try  (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(DELETE_QUERY);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
