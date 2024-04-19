import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserGUI extends JFrame {
   private JComboBox<String> colorComboBox;
   private JPanel circlePanel;
   private JTextField outputTextField;
   private Color circleColor;

   public ColorChooserGUI() {
      setTitle("Color Chooser");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());

      colorComboBox = new JComboBox<>(new String[] { "Red", "Blue", "Green" });
      colorComboBox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            String selectedColor = (String) colorComboBox.getSelectedItem();
            setColor(selectedColor);
         }
      });
      circleColor = Color.WHITE;
      circlePanel = new JPanel() {
         @Override
         protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(circleColor);
            g.fillOval(0, 0, getWidth(), getHeight());
         }
      };
      circlePanel.setPreferredSize(new Dimension(200, 200));

      outputTextField = new JTextField();
      outputTextField.setEditable(false);

      add(colorComboBox, BorderLayout.NORTH);
      add(circlePanel, BorderLayout.CENTER);
      add(outputTextField, BorderLayout.SOUTH);

      pack();
      setVisible(true);
   }

   private void setColor(String color) {
      switch (color) {
         case "Red":
            circleColor = Color.RED;
            break;
         case "Blue":
            circleColor = Color.BLUE;
            break;
         case "Green":
            circleColor = Color.GREEN;
            break;
         default:
            circleColor = Color.WHITE;
            break;
      }
      circlePanel.repaint();
      outputTextField.setText(color);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new ColorChooserGUI();
         }
      });
   }
}
