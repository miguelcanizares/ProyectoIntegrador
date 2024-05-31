package com.dam.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.dam.control.ProgralingoListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestPanelP extends JPanel {
    private JLabel lblPregunta;
    private JRadioButton[] optionButtons;
    private ButtonGroup group;
    private JButton btnNext, btnCorregir;
    private int currentQuestionIndex = 0;
    private int[] selectedAnswers;
    private int[] correctAnswers = {0, 0, 2, 2, 3, 1, 0, 0, 0, 2};

    private String[] questions = {
        "¿Qué palabra clave se utiliza para definir una función en Python?",
        "¿Qué símbolo se utiliza para comentar una línea en Python?",
        "¿Qué tipo de datos se utiliza para almacenar una cadena de caracteres en Python?",
        "¿Cuál de los siguientes es un tipo de dato mutable en Python?",
        "¿Cuál es la salida de la expresión '5' + '5' en Python?",
        "¿Cuál es el resultado de la operación 3//2 en Python?",
        "¿Cuál de las siguientes estructuras se utiliza para manejar excepciones en Python?",
        "¿Cómo se define una lista por comprensión en Python?",
        "¿Cuál es la diferencia principal entre una lista y un conjunto en Python?",
        "¿Cuál de las siguientes declaraciones es correcta para abrir un archivo en modo escritura en Python?"
    };

    private String[][] optionsText = {
        {"def", "function", "fun", "define"},
        {"#", "//", "/*", "%"},
        {"char", "string", "str", "text"},
        {"tuple", "str", "list", "int"},
        {"10", "55", "Error", "'55'"},
        {"1.5", "1", "2", "1.0"},
        {"try/except", "do/catch", "try/catch", "attempt/except"},
        {"[x for x in range(5)]", "list(x for x in range(5))", "{x for x in range(5)}", "list[x for x in range(5)]"},
        {"Una lista es ordenada y un conjunto no.", "Un conjunto es ordenado y una lista no.", "No hay diferencia.", "Una lista no permite duplicados y un conjunto sí."},
        {"file = open('archivo.txt', 'r')", "file = open('archivo.txt', 'rw')", "file = open('archivo.txt', 'w')", "file = open('archivo.txt', 'a')"}
    };
    private JButton btnVolver;

    public TestPanelP() {
        setBounds(100, 100, 450, 350);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        lblPregunta = new JLabel();
        lblPregunta.setBounds(10, 11, 414, 50);
        add(lblPregunta);

        optionButtons = new JRadioButton[4];
        group = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            optionButtons[i].setBounds(10, 70 + (i * 25), 400, 23);
            add(optionButtons[i]);
            group.add(optionButtons[i]);
        }
        btnNext = new JButton("Siguiente"); 
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveSelectedAnswer();
                if (selectedAnswers[currentQuestionIndex] == -1) {
                    JOptionPane.showMessageDialog(null, "Debes responder la pregunta para avanzar.");
                    return;
                }
                if (currentQuestionIndex < questions.length - 1) {
                    currentQuestionIndex++;
                    updateQuestion();
                } else {
                    JOptionPane.showMessageDialog(null, "Has completado el quiz! Ahora puedes corregir tus respuestas.");
                    btnNext.setEnabled(false);
                    btnCorregir.setEnabled(true);
                }
            }
        });
        btnNext.setBounds(10, 270, 100, 23);
        add(btnNext);

        btnCorregir = new JButton("Corregir");
        btnCorregir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                correctAnswers();
            }
        });
        btnCorregir.setBounds(120, 270, 100, 23);
        btnCorregir.setEnabled(false);
        add(btnCorregir);
        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(230, 271, 100, 23);
        add(btnVolver);

        selectedAnswers = new int[questions.length];
        for (int i = 0; i < selectedAnswers.length; i++) {
            selectedAnswers[i] = -1; 
        }

        updateQuestion();
    }

    private void updateQuestion() {
        lblPregunta.setText("<html>" + questions[currentQuestionIndex].replace("\n", "<br>") + "</html>");
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(optionsText[currentQuestionIndex][i]);
            optionButtons[i].setSelected(false);
        }
        if (selectedAnswers[currentQuestionIndex] != -1) {
            optionButtons[selectedAnswers[currentQuestionIndex]].setSelected(true);
        }
    }

    private void saveSelectedAnswer() {
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selectedAnswers[currentQuestionIndex] = i;
                break;
            }
        }
    }

    private void correctAnswers() {
        int correctCount = 0;
        StringBuilder resultMessage = new StringBuilder();
        for (int i = 0; i < questions.length; i++) {
            if (selectedAnswers[i] == correctAnswers[i]) {
                correctCount++;
            } else {
                resultMessage.append("Pregunta ").append(i + 1).append(": Incorrecta\n");
            }
        }
        resultMessage.append("Has acertado ").append(correctCount).append(" de ").append(questions.length).append(" preguntas.");
        JOptionPane.showMessageDialog(this, resultMessage.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
    }

    public void hacerVisible() {
        setVisible(true);
    }

    public void setControlador(ProgralingoListener controlador) {
  		btnVolver.addActionListener(controlador);
  		
  	}

  	public JButton getBtnVolver() {
  		return btnVolver;
  	}
 
}

