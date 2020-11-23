package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public void deleteAllWindowsFromARoom(Long RoomId) {
        String jpql = "DELETE FROM Window w WHERE w.room.id = :id";
        em.createQuery(jpql)
                .setParameter("id", RoomId).executeUpdate();
    }

    @Override
    public List<Window> getAllWindowsFromARoom(Long RoomId) {
        String jpql = "select w from Window w where w.room.id = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", RoomId)
                .getResultList();
    }
}