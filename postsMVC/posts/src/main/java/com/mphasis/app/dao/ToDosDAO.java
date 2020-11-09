package com.mphasis.app.dao;

import java.util.List;

import com.mphasis.app.crud.Status;
import com.mphasis.app.crud.ToDos;

public interface ToDosDAO {
ToDos insert(ToDos t);
ToDos update(int id);
Status delete(int id);
List<ToDos> view();
}
