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

public class TestPanelC extends JPanel {
    private JLabel lblPregunta;
    private JRadioButton[] optionButtons;
    private ButtonGroup group;
    private JButton btnNext, btnCorregir;
    private int currentQuestionIndex = 0;
    private int[] selectedAnswers;
    private int[] correctAnswers = {1, 2, 3, 3, 0, 1, 3, 3, 2, 0};

    private String[] questions = {
        "¿Qué palabra clave se utiliza para definir una clase en C#?",
        "¿Cuál es el nombre del método principal en un programa C#?",
        "¿Qué tipo de datos se utiliza para almacenar un número entero en C#?",
        "¿Cuál de los siguientes no es un modificador de acceso en C#?",
        "¿Qué interfaz debe implementarse para crear un hilo en C#?",
        "¿Qué significa CLR en el contexto de C#?",
        "¿Cuál de los siguientes métodos se utiliza para iniciar la ejecución de un hilo en C#?",
        "¿Cuál es la principal diferencia entre excepciones `Checked` y `Unchecked` en C#?",
        "¿Qué patrón de diseño se utiliza en C# para asegurar que una clase tenga solo una instancia y proporcione un punto de acceso global a esa instancia?",
        "En el contexto de la recolección de basura (Garbage Collection) en C#, ¿qué significa \"Generational Garbage Collection\"?"
    };

    private String[][] optionsText = {
        {"function", "class", "define", "object"},
        {"Start()", "Main()", "Begin()", "Init()"},
        {"float", "double", "int", "String"},
        {"public", "private", "protected", "internal"},
        {"IRunnable", "IThread", "IRun", "Thread"},
        {"Common Language Runtime", "Common Language Reference", "Common Language Resource", "Common Language Repository"},
        {"Run()", "Start()", "Execute()", "Perform()"},
        {"`Checked` deben ser capturadas o declaradas, `Unchecked` no.", "`Unchecked` deben ser capturadas o declaradas, `Checked` no.", "`Checked` son errores en tiempo de ejecución, `Unchecked` son errores de compilación.", "No hay diferencia entre `Checked` y `Unchecked` en C#."},
        {"Factory Pattern", "Observer Pattern", "Singleton Pattern", "Decorator Pattern"},
        {"Los objetos se clasifican en generaciones jóvenes y viejas para optimizar la recolección de basura.", "La recolección de basura se realiza en fases generacionales cada cierto período.", "Los objetos generacionales son aquellos que nunca se recolectan.", "Es una técnica que se utiliza solo en CLR experimentales."}
    };
    private JButton btnVolver;

    public TestPanelC() {
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

    public JButton getBtnVolver() {
		return btnVolver;
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
}


