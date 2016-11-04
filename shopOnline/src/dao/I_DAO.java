package dao;

import java.util.List;

public interface I_DAO<T,K>
{
	void insertar(T a) throws DAOException;
	void modificar(T a)throws DAOException;
	void eliminarPorId(K id)throws DAOException;
	T obtenerPorId(K id)throws DAOException;
	List<T> obtenerTodos()throws DAOException;
}
