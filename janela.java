import javax.swing.*;
import java.awt.*;

public class janela {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Poupex");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    /* 
        JPanel principal = new JPanel();
        principal.setBackground(new Color(171, 171, 171));
        principal.setLayout(new BorderLayout(10, 10));
    */ 
        
        //Painel com os labels
        JPanel text = new JPanel();
        text.setBackground(new Color(171, 171, 171));
        text.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        text.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 1, 15, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        //juros
        JLabel fees = new JLabel("Juros ao mes %: ");
        fees.setFont(null);// arrumar estilização
        JTextField feesField = new JTextField();
        feesField.setPreferredSize(new Dimension(150, 25));

        text.add(fees, gbc);
        gbc.gridx = 1; // label na coluna (horizontal)
        text.add(feesField, gbc);  
        gbc.gridy++; // avança para a próxima linha
        gbc.gridx = 0; // Volta a coluna para 0 

        //anos
        JLabel years = new JLabel("N° de anos: ");
        years.setFont(null);// arrumar estilização
        JTextField yearsField = new JTextField();
        yearsField.setPreferredSize(new Dimension(150, 25));

        text.add(years, gbc);
        gbc.gridx = 1;
        text.add(yearsField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        //deposito mensal
        JLabel deposit = new JLabel("Depósito mensal R$: ");
        deposit.setFont(null); //arrumar estilização
        JTextField depositField = new JTextField();
        depositField.setPreferredSize(new Dimension(150, 25));

        text.add(deposit, gbc);
        gbc.gridx = 1;
        text.add(depositField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        //campo inativo de resultado
        JLabel result = new JLabel("Total poupado R$: ");
        result.setFont(null); //arrumar estilização
        JTextField resultField = new JTextField();
        resultField.setPreferredSize(new Dimension(150, 25));//necessário definir um setText ao campo de resultado
        resultField.setEditable(false);

        text.add(result, gbc);
        gbc.gridx = 1;
        text.add(resultField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        JButton ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(150, 25));
        ok.addActionListener(e -> {
    try {
        double juros = Double.parseDouble(feesField.getText().trim()) / 100.0;
        int anos = Integer.parseInt(yearsField.getText().trim());
        int meses = anos * 12;
        double deposito = Double.parseDouble(depositField.getText().trim());
        double resultado = 0.0;

        for (int i = 0; i < meses; i++) {
            resultado += deposito;
            resultado += resultado * juros;
        }
        resultField.setText(String.format("%.2f", resultado));
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos corretamente.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    });
  
        gbc.gridx = 0;
        gbc.gridwidth = 2; 
        text.add(ok, gbc);
        gbc.gridwidth = 1; 

        frame.setLayout(new BorderLayout());
        frame.add(text, BorderLayout.CENTER);
        frame.pack(); // ajusta o tamanho automaticamente
        frame.setLocationRelativeTo(null); // centraliza na tela
        frame.setVisible(true);
    }
}
/*
        double jurostotal = Double.parseDouble(txtJuros.getText()) / 100.0;
            int anos = Integer.parseInt(txtAnos.getText());
            double deposito = Double.parseDouble(txtDeposito.getText());
            int meses = anos * 12;
            double total = 0.0;
 
            for (int i = 0; i < meses; i++) {
                total += deposito;
                total += total * jurostotal;
 */