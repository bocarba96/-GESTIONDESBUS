package sn.sentrans.dao;

import sn.sentrans.entities.User;

import java.util.List;

public interface IUser {
    public int add(User u);
    public List<User> liste();
    public int update(User u);
    public int delete(int Idu);
    public User getAll(String email);
    public User getLogin(String email, String password);
}
