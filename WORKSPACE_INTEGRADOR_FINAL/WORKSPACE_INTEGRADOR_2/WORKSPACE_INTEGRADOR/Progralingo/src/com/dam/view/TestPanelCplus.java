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

public class TestPanelCplus extends JPanel {
    private JLabel lblPregunta;
    private JRadioButton[] optionButtons;
    private ButtonGroup group;
    private JButton btnNext, btnCorregir;
    private int currentQuestionIndex = 0;
    private int[] selectedAnswers;
    private int[] correctAnswers = {1, 2, 0, 2, 1, 3, 1, 0, 2, 3};

    private String[] questions = {
        "¿Qué palabra clave se utiliza para definir una clase en C++?",
        "¿Cuál es el nombre del constructor predeterminado en C++?",
        "¿Qué tipo de datos se utiliza para almacenar un número entero en C++?",
        "¿Cuál de los siguientes no es un modificador de acceso en C++?",
        "¿Qué operador se utiliza para acceder a los miembros de un objeto en C++?",
        "¿Qué significa STL en el contexto de C++?",
        "¿Cuál de los siguientes es un contenedor de secuencia en la STL de C++?",
        "¿Cómo se declara un puntero en C++?",
        "¿Cuál es la principal diferencia entre `new` y `malloc` en C++?",
        "¿Cuál de los siguientes es un tipo de datos abstracto en C++?"
    };

    private String[][] optionsText = {
        {"define", "class", "struct", "object"},
        {"Constructor()", "Main()", "Init()", "Default()"},
        {"float", "double", "int", "char"},
        {"public", "protected", "private", "internal"},
        {"::", "->", ".", ","},
        {"Standard Template Library", "Simple Template Library", "Standard Tools Library", "Simple Tools Library"},
        {"vector", "stack", "queue", "all of the above"},
        {"int* p;", "int p*;", "*int p;", "int p"},
        {"`new` llama al constructor, `malloc` no.", "`malloc` llama al constructor, `new` no.", "No hay diferencia.", "`new` es una función de C, `malloc` es de C++."},
        {"int", "char", "float", "class"}
    };
    private JButton btnVolver;
    public TestPanelCplus() {
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

	public void setControlador(ProgralingoListener controlador) {
		btnVolver.addActionListener(controlador);
		
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
}

