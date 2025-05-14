package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

    public MainView() {
        setTitle("Agência de Viagens");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton btnClientes = new JButton("Gerenciar Clientes");
        JButton btnPacotes = new JButton("Gerenciar Pacotes");
        JButton btnServicos = new JButton("Gerenciar Serviços");
        JButton btnContratar = new JButton("Contratar Pacote");
        JButton btnConsultas = new JButton("Consultas");
        JButton btnPovoarBanco = new JButton("Povoar Banco de Dados");

        btnClientes.addActionListener(this::abrirClientes);
        btnPacotes.addActionListener(this::abrirPacotes);
        btnServicos.addActionListener(this::abrirServicos);
        btnContratar.addActionListener(this::abrirContratacao);
        btnConsultas.addActionListener(this::abrirConsultas);
        btnPovoarBanco.addActionListener(this::povoarBanco);

        add(btnClientes);
        add(btnPacotes);
        add(btnServicos);
        add(btnContratar);
        add(btnConsultas);
        add(btnPovoarBanco);
    }

    private void abrirClientes(ActionEvent e) {
        // abrir tela clientes
    }

    private void abrirPacotes(ActionEvent e) {
        // abrir tela pacotes
    }

    private void abrirServicos(ActionEvent e) {
        // abrir tela serviços
    }

    private void abrirContratacao(ActionEvent e) {
        // abrir tela de contratação
    }

    private void abrirConsultas(ActionEvent e) {
        // abrir tela de consultas
    }

    private void povoarBanco(ActionEvent e) {
        // executar script de povoamento
    }
}

