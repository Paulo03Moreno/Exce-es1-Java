package modelo_Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DominioExcecoes;

public class Reservas {
	
	private Integer numQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer numQuarto, Date chekIng, Date checkOut){
		if(!checkOut.after(checkIn)){
			throw new DominioExcecoes("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
		}

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
	
	public void atualizandoDatas(Date checkIn, Date checkOut){
		
		Date now = new Date();
		if(checkIn.before(now)|| checkOut.before(now)) {
			throw new DominioExcecoes("Erro na reserva: As datas de reserva para atualização devem ser futuras.");
		}
		
	
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
