package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Stock;

public class ImplStockDAO implements I_DAO<Stock, Integer> {
	private final String INSERT = "INSERT INTO stock (cantidadStock, idLibro) VALUES (?,?)"; // 2elem
	private final String UPDATE = "UPDATE stock SET cantidadStock=? WHERE idLibro?"; // 3elem
	private final String DELETE = "DELETE FROM stock WHERE idLibro=?"; // 1elem
	private final String GETONE = "SELECT idStock, cantidadStock, idLibro FROM stock WHERE idLibro=?"; // 1elem
	private final String GETALL = "SELECT idStock, cantidadStock, idLibro FROM stock"; // 0elem

	private Connection con = null;

	// Constructor (crea nueva conex.)
	public ImplStockDAO() {
		con = new ConexionDB().getConnection();
	}

	// Metodo INSERT SQL
	public void insertar(Stock stock) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement(INSERT);
			stat.setInt(1, stock.getCantidadStock());
			stat.setInt(2, stock.getIdLibro());

			if (stat.executeUpdate() != 1)
				throw new DAOException("Error adding stock");

		} catch (SQLException e) {
			throw new DAOException("Error adding stock in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error adding stock in DAO", ex);
				}
			}
		}
	}

	// METODO UPDATE SQL
	public void modificar(Stock stock) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement(UPDATE);
			stat.setInt(1, stock.getCantidadStock());
			stat.setInt(2, stock.getIdLibro());
			stat.setInt(3, stock.getIdStock());

			if (stat.executeUpdate() != 1)
				throw new DAOException("Error update stock");

		} catch (SQLException e) {
			throw new DAOException("Error update stock in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update stock in DAO", ex);
				}
			}
		}
	}

	// METODO DELETE SQL
	public void eliminarPorId(Integer id) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement(DELETE);
			stat.setInt(1, id);

			if (stat.executeUpdate() != 1)
				throw new DAOException("Error delete stock");

		} catch (SQLException e) {
			throw new DAOException("Error delete stock in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update stock in DAO", ex);
				}
			}
		}
	}

	// METODO GETONE SQL
	public Stock obtenerPorId(Integer id) throws DAOException {

		PreparedStatement stat = null;
		ResultSet rs = null;
		Stock stock = null;

		try {
			stat = con.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();

			if (rs.next())
				stock = convertir(rs);
			else
				throw new DAOException("No se ha encontrado registro");

		} catch (SQLException e) {
			throw new DAOException("Error delete stock in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update stock in DAO", ex);
				}
			}
		}
		return (stock);
	}

	// METODO GETALL SQL
	public List<Stock> obtenerTodos() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Stock> stocks = new ArrayList<>();

		try {
			stat = con.prepareStatement(GETALL);
			rs = stat.executeQuery();

			if (rs.next())
				stocks.add(convertir(rs));
			else
				throw new DAOException("No se ha encontrado registro");
		} catch (SQLException e) {
			throw new DAOException("Error delete stock in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update stock in DAO", ex);
				}
			}
		}
		return (stocks);
	}

	// Obtiene un objeto Autor a partir del resultado de la query
	public Stock convertir(ResultSet rs) throws SQLException {
		// Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Integer idStock = rs.getInt("idStock");
		Integer cantidadStock = rs.getInt("cantidadStock");
		Integer idLibro = rs.getInt("idLibro");
		// Con los atributos creo el objeto
		Stock stock = new Stock(idStock, cantidadStock, idLibro);
		// Retorno el objeto creado
		return (stock);
	}
}
