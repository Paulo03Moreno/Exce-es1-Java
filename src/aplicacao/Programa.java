package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.excecoes.DominioExcecoes;
import modelo_Entidades.Reservas;

public class Programa {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("N�mero do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data do check-in(DD/MM/AAAA): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("data do check-out(DD/MM/AAAA): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservas reservas = new Reservas(num, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
			
			System.out.println();
			System.out.println("Digite os dados da atualiza��o da reserva: ");
			System.out.print("Data do check-in(DD/MM/AAAA): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("data do check-out(DD/MM/AAAA): ");
			checkOut = sdf.parse(sc.next());
		
			reservas.atualizandoDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reservas);			
		}
		catch(ParseException e){
			System.out.println("O formato da data � inv�lido!");
		}
		catch(DominioExcecoes e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!!");
		}
		
		sc.close();
	}

}
