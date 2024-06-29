import dao.Conexao;
import dao.UsuarioDAO;
import modelo.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioDAOTest {

    private Connection conexao;
    private UsuarioDAO usuarioDAO;

    @BeforeEach
    public void setUp() {
        conexao = new Conexao().getConexao();
        usuarioDAO = new UsuarioDAO();

        inserirUsuarioTeste();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        limparDados();
        conexao.close();
    }

    private void inserirUsuarioTeste() {
        String sql = "INSERT INTO tb_usuario (login, senha) VALUES (?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "usuario_teste");
            stmt.setString(2, "senha_teste");
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir usuário de teste: " + e.getMessage());
        }
    }

    private void limparDados() {
        String sql = "DELETE FROM tb_usuario WHERE login = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "usuario_teste");
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao limpar dados de teste: " + e.getMessage());
        }
    }

    /**
     * Test of autenticar method, of class UsuarioDAO.
     */
    @Test
    public void testAutenticar() {
    System.out.println("autenticar");

    String login = "usuario_teste";
    String senha = "senha_teste";

    UsuarioDAO instance = new UsuarioDAO();

    Usuario result = instance.autenticar(login, senha);

    assertNotNull(result);

    assertEquals(login, result.getLogin());

    Usuario expResult = null;
    Usuario invalidResult = instance.autenticar("", "");

    assertEquals(expResult, invalidResult);
    }

}
