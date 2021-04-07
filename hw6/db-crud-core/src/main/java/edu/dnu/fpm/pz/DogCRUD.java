package edu.dnu.fpm.pz;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static edu.dnu.fpm.pz.ConnectionHelper.getConnection;
import static java.util.Objects.requireNonNull;

public class DogCRUD implements ICRUD<Dog> {
    final String INSERT_QUERY = "INSERT INTO dogs (Name, OwnerId, Age, IsVaccinated)" +
            " VALUES (?, ?, ?, ?)";
    final String SELECT_QUERY = "SELECT * FROM dogs";
    final String SELECT_WITH_FILTER_QUERY = "SELECT * FROM dogs where id = ?";
    final String UPDATE_QUERY = "UPDATE dogs SET ownerId = ?, NAME = ?, " +
            "Age = ?, IsVaccinated = ? WHERE id = ?";
    final String DELETE_QUERY = "DELETE FROM dogs WHERE id = ?";

    public Integer save(Dog dog) {
        requireNonNull(dog.getOwnerId(), "owner id can't be null");

        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(INSERT_QUERY);
            ps.setString(1, dog.getName());
            ps.setInt(2, dog.getOwnerId());
            ps.setInt(3, dog.getAge());
            ps.setBoolean(4, dog.getIsVaccinated());
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saveAll(Collection<Dog> dogs) {
        try (Connection ConnecntionToDB = getConnection()){
            ConnecntionToDB.setAutoCommit(false);

            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(INSERT_QUERY);

            for (Dog dog : dogs) {
                ps.setString(1, dog.getName());
                ps.setInt(2, dog.getOwnerId());
                ps.setInt(3,  dog.getAge());
                ps.setBoolean(4, dog.getIsVaccinated());
                ps.addBatch();
            }

            ps.executeBatch();
            ConnecntionToDB.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Dog findById(Integer id) {
        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(SELECT_WITH_FILTER_QUERY);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return getDogFromResultSetRow(resultSet);
            }
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return null;
    }

    private Dog getDogFromResultSetRow(ResultSet resultSet) throws SQLException {
        return new Dog(resultSet.getInt(1), resultSet.getInt(2),
                resultSet.getString(3), resultSet.getInt(4),resultSet.getBoolean(4));
    }

    public Collection<Dog> findAll() {
        List<Dog> dogs = new ArrayList<Dog>();
        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(SELECT_QUERY);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                dogs.add(getDogFromResultSetRow(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dogs;
    }

    public void update(Dog dog) {
        requireNonNull(dog, "can't update null dog");
        requireNonNull(dog.getId(), "Can't update a dog with null id");

        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(UPDATE_QUERY);

            ps.setInt(1, dog.getOwnerId());
            ps.setString(2, dog.getName());
            ps.setInt(3, dog.getAge());
            ps.setBoolean(4, dog.getIsVaccinated());
            ps.setInt(5, dog.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try (Connection ConnecntionToDB = getConnection()){
            PreparedStatement ps =
                    ConnecntionToDB.prepareStatement(DELETE_QUERY);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
