package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo_Entidades.Reservas;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data do check-in(DD/MM/AAAA): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("data do check-out(DD/MM/AAAA): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
		}else {
			Reservas reservas = new Reservas(num, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
			
			System.out.println();
			System.out.println("Digite os dados da atualização da reserva: ");
			System.out.print("Data do check-in(DD/MM/AAAA): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("data do check-out(DD/MM/AAAA): ");
			checkOut = sdf.parse(sc.next());
		
			Date now = new Date();
			if(checkIn.before(now)|| checkOut.before(now)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser futuras.");
			}else if(!checkOut.after(checkIn)){
				System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
			}else {
				
				reservas.atualizandoDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
			}
		}
		sc.close();
	}

}
