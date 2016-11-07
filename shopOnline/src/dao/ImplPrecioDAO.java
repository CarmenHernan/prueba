package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Precio;

public class ImplPrecioDAO implements I_DAO<Precio, Integer> {
	private final String INSERT = "INSERT INTO precio (precio, idLibro) VALUES (?,?)"; // 2elem
	private final String UPDATE = "UPDATE precio SET precio=? WHERE idLibro=?"; // 3elem
	private final String DELETE = "DELETE FROM precio WHERE idLibro=?"; // 1elem
	private final String GETONE = "SELECT idPrecio, nombre, idLibro FROM precio WHERE idLibro=?"; // 1elem
	private final String GETALL = "SELECT idPrecio, nombre, idLibro FROM precio"; // 0elem

	private Connection con = null;

	// Constructor (crea nueva conex.)
	public ImplPrecioDAO() {
		con = new ConexionDB().getConnection();
	}

	// Metodo INSERT SQL
	public void insertar(Precio precio) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement(INSERT);
			stat.setFloat(1, precio.getPrecio());
			stat.setInt(2, precio.getIdLibro());

			if (stat.executeUpdate() != 1)
				throw new DAOException("Error adding precio");

		} catch (SQLException e) {
			throw new DAOException("Error adding precio in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error adding precio in DAO", ex);
				}
			}
		}
	}

	// METODO UPDATE SQL
	public void modificar(Precio precio) throws DAOException {
		PreparedStatement stat = null;
		try {
			stat = con.prepareStatement(UPDATE);
			stat.setFloat(1, precio.getPrecio());
			stat.setInt(2, precio.getIdLibro());
			stat.setInt(3, precio.getIdPrecio());

			if (stat.executeUpdate() != 1)
				throw new DAOException("Error update precio");

		} catch (SQLException e) {
			throw new DAOException("Error update precio in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update precio in DAO", ex);
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
				throw new DAOException("Error delete precio");

		} catch (SQLException e) {
			throw new DAOException("Error delete precio in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update precio in DAO", ex);
				}
			}
		}
	}

	// METODO GETONE SQL
	public Precio obtenerPorId(Integer id) throws DAOException {

		PreparedStatement stat = null;
		ResultSet rs = null;
		Precio precio = null;

		try {
			stat = con.prepareStatement(GETONE);
			stat.setInt(1, id);
			rs = stat.executeQuery();

			if (rs.next())
				precio = convertir(rs);
			else
				throw new DAOException("No se ha encontrado registro");

		} catch (SQLException e) {
			throw new DAOException("Error delete precio in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update precio in DAO", ex);
				}
			}
		}
		return (precio);
	}

	// METODO GETALL SQL
	public List<Precio> obtenerTodos() throws DAOException {
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<Precio> precios = new ArrayList<>();

		try {
			stat = con.prepareStatement(GETALL);
			rs = stat.executeQuery();

			while(rs.next())
			{
				precios.add(convertir(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("Error delete precio in DAO", e);
		} finally {
			if (stat != null) {
				try {
					stat.close();
				} catch (SQLException ex) {
					throw new DAOException("Error update precio in DAO", ex);
				}
			}
		}
		return (precios);
	}

	// Obtiene un objeto Precio a partir del resultado de la query
	public Precio convertir(ResultSet rs) throws SQLException {
		// Obtengo atributos a partir de la consulta de la tabla (ResultSet)
		Integer idPrecio = rs.getInt("idPrecio");
		Float precio = rs.getFloat("precio");
		Integer idLibro = rs.getInt("idLibro");
		// Con los atributos creo el objeto
		Precio precio_ = new Precio(idPrecio, precio, idLibro);
		// Retorno el objeto creado
		return (precio_);
	}
}
