package modelo;

import java.time.LocalDate;

public class Transaccion {
    private String tipo; 
    private double monto;
    private LocalDate fecha;

    public Transaccion(String tipo, double monto, LocalDate fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

	public Object getMotivo() {
		return null;
	}
}
