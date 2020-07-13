package modelo_Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numQuarto, Date chekIng, Date checkOut) {

		this.numQuarto = numQuarto;
		this.checkIn = chekIng;
		this.checkOut = checkOut;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizandoDatas(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto: "
				+ numQuarto
				+ ", checkIn: " 
				+ sdf.format(checkIn)
				+ ", checkOut: " 
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+" noites.";
	}

}