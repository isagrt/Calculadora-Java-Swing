import javax.swing.*;
import java.awt.*;

public class janela {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Poupex");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Painel com os labels
        JPanel text = new JPanel();
        text.setBackground(new Color(235, 235, 235));
        text.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        text.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        //juros
        JLabel fees = new JLabel("Juros ao mes %: ");
        fees.setFont(new Font("Verdana", Font.BOLD, 15));
        JTextField feesField = new JTextField();
        feesField.setPreferredSize(new Dimension(150, 25));
        feesField.setFont(new Font("Verdana", Font.PLAIN, 15));

        text.add(fees, gbc);
        gbc.gridx = 1; // label na coluna (horizontal)
        text.add(feesField, gbc);  
        gbc.gridy++; // avança para a próxima linha
        gbc.gridx = 0; // Volta a coluna para 0 

        //anos
        JLabel years = new JLabel("N° de anos: ");
        years.setFont(new Font("Verdana", Font.BOLD, 15));
        JTextField yearsField = new JTextField();
        yearsField.setPreferredSize(new Dimension(150, 25));
        yearsField.setFont(new Font("Verdana", Font.PLAIN, 15));

        text.add(years, gbc);
        gbc.gridx = 1;
        text.add(yearsField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        //deposito mensal
        JLabel deposit = new JLabel("Depósito mensal R$: ");
        deposit.setFont(new Font("Verdana", Font.BOLD, 15));
        JTextField depositField = new JTextField();
        depositField.setPreferredSize(new Dimension(150, 25));
        depositField.setFont(new Font("Verdana", Font.PLAIN, 15));

        text.add(deposit, gbc);
        gbc.gridx = 1;
        text.add(depositField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        //campo inativo de resultado
        JLabel result = new JLabel("Total poupado R$: ");
        result.setFont(new Font("Verdana", Font.BOLD, 16));
        JTextField resultField = new JTextField();
        resultField.setPreferredSize(new Dimension(150, 25));//necessário definir um setText ao campo de resultado
        resultField.setFont(new Font("Verdana", Font.BOLD, 16));
        resultField.setEditable(false);

        text.add(result, gbc);
        gbc.gridx = 1;
        text.add(resultField, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        JButton ok = new JButton("OK");
        ok.setPreferredSize(new Dimension(150, 25));
        ok.setBackground(new Color(164, 210, 222));
        ok.setForeground(new Color(60, 61, 61));
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
                JOptionPane.showMessageDialog(frame, "Por favor, preencha todos os campos corretamente.", "Erro!!", JOptionPane.ERROR_MESSAGE);
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
