
package dao;
import modelo.Produto;
import modelo.Saida;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class SaidaDAO {
    //Não é possivel fazer o Teste da Classe.
    public class SaidaDAO {
        private List <Saida> listaSaida;

        public SaidaDAO() {
            listaSaida = new ArrayList<>();
        }

        public List <Saida> buscar(Produto produto) {
            List <Saida> saidaTotal = new ArrayList<>();
            for (Saida saida : listaSaida) {
                if (saida.getProduto().equals(produto)) {
                    saidaTotal.add(saida);
                }
            }
            return saidaTotal;
        }

        public List <Saida> buscar(String tipo) {
            List <Saida> saidaTotal = new ArrayList<>();
            for (Saida saida : listaSaida) {
                if (saida.getTipo().equals(tipo)) {
                    saidaTotal.add(saida);
                }
            }
            return saidaTotal;
        }

        public List<Saida> buscar(Date inicio, Date fim) {
            List <Saida> saidasEncontradas = new ArrayList<>();
            for (Saida saida : listaSaida) {
                Date dataSaida = saida.getData();
                if (dataSaida.after(inicio) && dataSaida.before(fim)) {
                    saidasEncontradas.add(saida);
                }
            }
            return saidasEncontradas;
        }

        public void salvar(Saida saida) {
            listaSaida.add(saida);
        }
        //ok
        public boolean alterarStatus(Saida saida) {
            for (Saida s : listaSaida) {
                if (s.equals(saida)) {
                    s.alterarStatus();
                    return true;
                }
            }
            return false;
        }
    }

}
