package com.assignment.mentalhealththeraphycenter.repostory;

import com.assignment.mentalhealththeraphycenter.entity.SuperEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity,ID> extends SuperDAO {
    boolean save(T t , Session session) throws SQLException;
    boolean update(T t , Session session ) throws SQLException, ClassNotFoundException;
    List<T> getAll() throws Exception;
    boolean deleteByPk(ID pk) throws SQLException, ClassNotFoundException;
    Optional<T> findByPK(ID pk, Session session) throws SQLException;
    Optional<String> getLastPK();
}
