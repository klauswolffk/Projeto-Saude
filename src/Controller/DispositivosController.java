package Controller;

import Model.Dispositivos;
import Model.Medico;

import java.util.ArrayList;
import java.util.Iterator;

public class DispositivosController {

    private static ArrayList<Dispositivos> dispositivos = new ArrayList<>();

    // Método para cadastrar dispositivo
    public String cadastrarDispositivo(Dispositivos dispositivo) {
        // Validação de dados obrigatórios
        if (dispositivo.getTipo() == null || dispositivo.getTipo().isEmpty()) {
            return "Tipo do dispositivo é obrigatório.";
        }
        if (dispositivo.getMarca() == null || dispositivo.getMarca().isEmpty()) {
            return "Marca do dispositivo é obrigatória.";
        }
        if (dispositivo.getModelo() == null || dispositivo.getModelo().isEmpty()) {
            return "Modelo do dispositivo é obrigatório.";
        }
        if (dispositivo.getValoresReferencia() == null || dispositivo.getValoresReferencia().isEmpty()) {
            return "Valores de referência são obrigatórios.";
        }

        // Validação para garantir que o modelo do dispositivo seja único
        for (Dispositivos d : dispositivos) {
            if (d.getModelo().equalsIgnoreCase(dispositivo.getModelo())) {
                return "Modelo de dispositivo já cadastrado.";
            }
        }

        // Adicionando dispositivo à lista
        dispositivos.add(dispositivo);
        return "Dispositivo cadastrado com sucesso!";
    }

    // Método para remover dispositivo pelo modelo
    public String removerDispositivo(String modelo) {
        // Usando iterador para evitar erro de modificação da lista durante iteração
        Iterator<Dispositivos> iterator = dispositivos.iterator();
        while (iterator.hasNext()) {
            Dispositivos dispositivo = iterator.next();
            if (dispositivo.getModelo().equalsIgnoreCase(modelo)) {
                iterator.remove();  // Remove o dispositivo
                return "Dispositivo removido com sucesso!";
            }
        }
        return "Dispositivo não encontrado.";
    }

    // Método para visualizar dispositivos cadastrados
    public String visualizarDispositivos() {
        if (dispositivos.isEmpty()) {
            return "Nenhum dispositivo cadastrado.";
        }

        StringBuilder sb = new StringBuilder();
        for (Dispositivos dispositivo : dispositivos) {
            sb.append("Tipo: ").append(dispositivo.getTipo())
                    .append("\nMarca: ").append(dispositivo.getMarca())
                    .append("\nModelo: ").append(dispositivo.getModelo())
                    .append("\nValores de Referência: ").append(dispositivo.getValoresReferencia())
                    .append("\n\n");
        }
        return sb.toString();
    }

    public static Dispositivos buscarDispoPorModelo(String modelo) {
        for (Dispositivos dispo : dispositivos) {
            if (dispo.getModelo().equals(modelo)) {
                return dispo;
            }
        }
        return null;
    }

    // Método para listar todos os dispositivos cadastrados
    public ArrayList<Dispositivos> listarDispositivos() {
        return this.dispositivos;
    }
}
