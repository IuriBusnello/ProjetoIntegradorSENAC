package senac.senacfx.model.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import senac.senacfx.model.dao.DepartmentDao;
import senac.senacfx.model.entities.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class DepartmentDaoJDBCTest {

    private Connection conn;
    private DepartmentDao departmentDao;

    @Before
    public void setUp() throws SQLException {
        // Configuração do banco de dados em memória (H2)
        conn = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "", "");
        // Inicialização do DAO
        departmentDao = new DepartmentDao() {
            @Override
            public void insert(Department obj) {

            }

            @Override
            public void update(Department obj) {

            }

            @Override
            public void deleteById(Integer id) {

            }

            @Override
            public Department findById(Integer id) {
                return null;
            }

            @Override
            public List<Department> findAll() {
                return List.of();
            }
        };
    }

    @After
    public void tearDown() throws SQLException {
        // Fechar a conexão após os testes
        if (conn != null) {
            conn.close();
        }
    }

    @Test
    public void testInsert() {
        // Cria um departamento para inserção
        Department department = new Department(1, "Test Department");

        // Insere o departamento no banco de dados
        departmentDao.insert(department);

        // Verifica se o ID foi gerado e atribuído ao departamento
        assertNotNull(department.getId());
        assertNotEquals(null, department.getId().intValue());

    }
}
