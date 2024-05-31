package com.dam.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import com.dam.model.data.Usuario;
import com.dam.model.db.UsuarioPersistencia;
import com.dam.view.IntroLeng;
import com.dam.view.Login;
import com.dam.view.ModificarUsuario;
import com.dam.view.PanelOpciones;
import com.dam.view.PConsultarUsuarios;
import com.dam.view.PPrincipal;
import com.dam.view.Registro;
import com.dam.view.TestPanelC;
import com.dam.view.TestPanelP;
import com.dam.view.TestPanelJ;
import com.dam.view.TestPanelCplus;

public class ProgralingoListener implements ActionListener {
    private PPrincipal pp;
    private Registro rg;
    private Login lg;
    private PanelOpciones po;
    private IntroLeng il;
    private ModificarUsuario mu;
    private PConsultarUsuarios pcu;
    private TestPanelC tpc;
    private TestPanelP tpcp;
    private TestPanelJ tpj;
    private TestPanelCplus tpp;
    private UsuarioPersistencia datosUsuario;
    private UsuarioPersistencia usuarioPersistencia;

    public ProgralingoListener(PPrincipal pp) {
        this.pp = pp;
        datosUsuario = new UsuarioPersistencia();
        usuarioPersistencia = new UsuarioPersistencia();
    }

    public ProgralingoListener(ModificarUsuario modificarUsuario) {
        this.mu = modificarUsuario;
        this.usuarioPersistencia = new UsuarioPersistencia();
        this.mu.setControlador(this);
    }

    public void setLogin(Login lg) {
        this.lg = lg;
    }

    public void setRegistro(Registro rg) {
        this.rg = rg;
    }

    public void setMu(ModificarUsuario mu) {
        this.mu = mu;
    }

    public void setPo(PanelOpciones po) {
        this.po = po;
    }

    public void setPcu(PConsultarUsuarios pcu) {
        this.pcu = pcu;
    }

    public void setIl(IntroLeng il) {
        this.il = il;
    }

    public void setTpc(TestPanelC tpc) {
        this.tpc = tpc;
    }

    public void setTpcp(TestPanelP tpcp) {
        this.tpcp = tpcp;
    }

    public void setTpj(TestPanelJ tpj) {
        this.tpj = tpj;
    }

    public void setTpp(TestPanelCplus tpp) {
        this.tpp = tpp;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        if (ev.getSource() instanceof JMenuItem) {
            if (ev.getSource().equals(pp.getMntmRegistro())) {
                pp.cargarPanel(rg);
            } else if (ev.getSource().equals(pp.getMntmInicioSesion())) {
                pp.cargarPanel(lg);
                validarUsuario();
            }
        } else {
            if (ev.getSource().equals(rg.getBtnOK())) {
                if (registrarUsuario()) {
                    pp.cargarPanel(po);
                }
            } else if (ev.getSource().equals(lg.getBtnLogin())) {
                validarUsuario();
            } else if (ev.getSource().equals(po.getBtnCerrarSesion())) {
                cerrarSesion();
            } else if (ev.getSource().equals(po.getBtnLenguajes())) {
                pp.cargarPanel(il);
            } else if (ev.getSource().equals(il.getBtnCplus())) {
                pp.cargarPanel(tpcp);
            } else if (ev.getSource().equals(il.getBtnPhyton())) {
                pp.cargarPanel(tpp);
            } else if (ev.getSource().equals(il.getBtnJavaScript())) {
                pp.cargarPanel(tpc);
            } else if (ev.getSource().equals(il.getBtnJava())) {
                pp.cargarPanel(tpj);
            } else if (ev.getSource().equals(po.getBtnModificar())) {
                pp.cargarPanel(mu);
            } else if (ev.getSource().equals(tpc.getBtnVolver())) {
                pp.cargarPanel(po);
            } else if (ev.getSource().equals(tpp.getBtnVolver())) {
                pp.cargarPanel(po);
            } else if (ev.getSource().equals(tpj.getBtnVolver())) {
                pp.cargarPanel(po);
            } else if (ev.getSource().equals(tpcp.getBtnVolver())) {
                pp.cargarPanel(po);
            } else if (ev.getSource().equals(mu.getBtnGuardar())) {
                actualizarContrasena();
            }
        }
    }

    public boolean registrarUsuario() {
        Usuario usuario = rg.obtenerUsuario();

        if (usuario != null) {
            int res = datosUsuario.registrarUsuario(usuario);

            if (res == 1) {
                JOptionPane.showMessageDialog(rg, "Se ha registrado el usuario con éxito",
                        "Resultado de Operación", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else if (res == -1) {
                JOptionPane.showMessageDialog(rg, "No se ha podido registrar",
                        "Resultado de Operación", JOptionPane.ERROR_MESSAGE);
            } else if (res == 0) {
                JOptionPane.showMessageDialog(rg, "No se ha podido registrar",
                        "Resultado de Operación", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    public boolean validarUsuario() {
        Usuario user = lg.getUsuario();

        if (user != null) {
            String resultado = datosUsuario.validarUsuario(user);

            if (resultado.equals("Acceso permitido")) {
                pp.cargarPanel(po);
                return true;
            } else {
                lg.mostrarMensaje(resultado, null, 0);
            }
        }
        return false;
    }

    public void actualizarContrasena() {
        String nombreUsuario = mu.getNombreUsuario();
        String antiguaContrasena = mu.getAntiguaContrasena();
        String nuevaContrasena = mu.getNuevaContrasena();

        int resultado = usuarioPersistencia.actualizarContrasena(nombreUsuario, antiguaContrasena, nuevaContrasena);

        if (resultado > 0) {
            JOptionPane.showMessageDialog(mu, "Contraseña actualizada correctamente.");
        } else if (resultado == -1) {
            JOptionPane.showMessageDialog(mu, "Contraseña antigua incorrecta.");
        } else if (resultado == -2) {
            JOptionPane.showMessageDialog(mu, "Usuario no encontrado.");
        } else {
            JOptionPane.showMessageDialog(mu, "Error al actualizar la contraseña.");
        }
    }

    public void cerrarSesion() {
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas cerrar la sesión?", "Confirmar cierre de sesión", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
