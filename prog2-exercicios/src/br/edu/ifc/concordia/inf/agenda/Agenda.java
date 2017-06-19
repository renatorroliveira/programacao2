package br.edu.ifc.concordia.inf.agenda;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Agenda extends JFrame {


	private List<Contato> agenda;
	private JPanel root;
	private JList<String> listaDeContatosNaTela;
	private JList<String> listaDeEmailsNaTela;
	private DefaultListModel<String> listaDeContatos;
	
	private JPanel containerDeDetalhes;
	private JLabel detalhesNome;
	private JLabel detalhesSobrenome;
	
	public Agenda() {
		super("Agenda Eletrônica");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 350);
		Agenda frame = this;
		agenda = new LinkedList<Contato>();
		Contato renato = new Contato("Renato", "Oliveira");
		renato.emails.add(new Email("renatorro@bla.com", "Pessoal"));
		agenda.add(renato);
		
		GridLayout windowLayout = new GridLayout(1, 2);
		windowLayout.setHgap(10);
		windowLayout.setVgap(10);
		root = new JPanel();
		root.setLayout(windowLayout);
		
		listaDeContatos = new DefaultListModel<String>();
		for (int i = 0; i < agenda.size(); i++) {
			listaDeContatos.addElement(agenda.get(i).nome
					+ " " + agenda.get(i).sobrenome);
		}
		listaDeContatosNaTela = new JList<String>(listaDeContatos);
		listaDeContatosNaTela.setPreferredSize(new Dimension(200, 500));
		listaDeContatosNaTela.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Contato selecionado = agenda.get(e.getFirstIndex());
				detalhesNome.setText(selecionado.nome);
				detalhesSobrenome.setText(selecionado.sobrenome);
				DefaultListModel<String> emails = new DefaultListModel<String>();
				for (Email email : selecionado.emails) {
					emails.addElement(email.email);
				}
				listaDeEmailsNaTela.setModel(emails);
			}
		});
		JScrollPane scroller = new JScrollPane(listaDeContatosNaTela);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		root.add(scroller);
		
		containerDeDetalhes = new JPanel();
		GridLayout gridDeDetalhes = new GridLayout(3, 2);
		containerDeDetalhes.setLayout(gridDeDetalhes);
		containerDeDetalhes.add(new JLabel("Nome:"));
		detalhesNome = new JLabel("");
		containerDeDetalhes.add(detalhesNome);
		containerDeDetalhes.add(new JLabel("Sobrenome:"));
		detalhesSobrenome = new JLabel("");
		containerDeDetalhes.add(detalhesSobrenome);
		containerDeDetalhes.add(new JLabel("Emails:"));
		listaDeEmailsNaTela = new JList<String>();
		JScrollPane emailsScroller = new JScrollPane(listaDeEmailsNaTela);
		containerDeDetalhes.add(emailsScroller);
		
		root.add(containerDeDetalhes);
		
		this.add(root);
		this.setVisible(true);
	}
}
