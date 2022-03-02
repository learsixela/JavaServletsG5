package com.desafiolatam.web.models;

public class Auto {
	// atributos
	private Integer id;
	private String marca;
	private Float motor;
	private String color;
	private float velocidad;

	// constructores
	public Auto(String marca, Float motor, String color, float velocidad) {
		super();
		this.marca = marca;
		this.motor = motor;
		this.color = color;
		this.velocidad = velocidad;
	}
	
	public Auto() {
		super();
	}

	// getters&Setters
	public float getVelocidad() {
		return velocidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Float getMotor() {
		return motor;
	}

	public void setMotor(Float motor) {
		this.motor = motor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// metodos
	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", motor=" + motor + ", color=" + color + ", velocidad=" + velocidad + "]";
	}

	public void aumentarVelocidad() {
		velocidad = velocidad + 10;
		System.out.println("La velocidad es: " + velocidad);
	}

	public void aumentarVelocidad(float velocidad) {
		if(velocidad > 0) {
			this.velocidad = this.velocidad + velocidad;
		}
		
		System.out.println("La velocidad es: " + this.velocidad);
	}

	public void aumentarVelocidad(boolean acelerar, boolean frenar) {
		if (acelerar) {
			velocidad = velocidad + 15;
		} else if (frenar) {
			if (velocidad < 15) {
				velocidad = 0;
			} else {
				velocidad = velocidad - 15;
			}
		}

		System.out.println("La velocidad es: " + velocidad);
	}

}
