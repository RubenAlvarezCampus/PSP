package Actividad_4_2_Servidor_SMTP;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import Utilidades.Utilidades;

public class CorreoSMTP {
	public static void main(String args[]) throws IOException {
		String correo = pedir_correo();
		String password = Utilidades.pedirTexto("Dime la contraseña: ");
		Properties propiedades = System.getProperties();
		// El proveedor soporta TLS
		// https://es.wikipedia.org/wiki/Transport_Layer_Security
		propiedades.put("mail.smtp.starttls.enable", "true");
		// Usamos el protocolo TLSv1.2
		propiedades.put("mail.smtp.ssl.protocols", "TLSv1.2");
		// Host del proveedor de correo. Para google es: smtp.gmail.com
		propiedades.put("mail.smtp.host", "smtp.gmail.com");
		// Puerto que utiliza gmail para el envío de correos.
		propiedades.put("mail.smtp.port", "587");
		// Se requiere usuario y password.
		propiedades.put("mail.smtp.auth", "true");
		// Nombre de usuario de gmail.
		propiedades.put("mail.smtp.user", correo);

		// Iniciamos sesión con el servidor de correo utilizando las propiedades
		// establecidas.
		Session sesion = Session.getDefaultInstance(propiedades);
		System.out.println("-----Hemos iniciado sesión con GMAIL------");
		System.out.println("");

		try {
			// Creando el mensaje.
			MimeMessage email = new MimeMessage(sesion);
			// Lista de destinatarios separados por coma.
			String destinatarios = pedir_destinatario();

			// Creando lista de direcciones a partir de la cadena destinatarios.
			InternetAddress[] direccionesTo = InternetAddress.parse(destinatarios, true);

			// Configurando el email que se va a enviar.
			email.setRecipients(Message.RecipientType.TO, direccionesTo);
			email.setSubject(Utilidades.pedirTexto("Titulo: "));
			email.setSentDate(new Date());
			email.setText(Utilidades.pedirTexto("Cuerpo: "));
			System.out.println("-----Hemos configurado el email-----");
			System.out.println(""); 

			// Creando transportador de emails usando protocolo SMTP.
			Transport t = sesion.getTransport("smtp");

			// Conectando al servidor de correo con autentificación.
			t.connect(correo, password);
			System.out.println("-----Hemos conectado con el servidor de GMAIL-----");
			t.sendMessage(email, email.getAllRecipients());
			t.close();

			System.out.println("El mensaje ha sido enviado con éxito");
		} catch (MessagingException e) {
			System.out.println("No se ha podido enviar el mensaje " + e);
		}
	}

	public static String pedir_correo() {

		boolean valido = true;

		while (true) {
			String correo = Utilidades.pedirTexto("Dime tu correo: ");
			valido = validar_destinatario(correo);
			if (valido == true) {
				System.out.println("El email ingresado es válido.");
				return correo;
			} else {
				System.out.println("El email ingresado es inválido.");
			}
		}
	}

	public static String pedir_destinatario() {
		int numero_destinos;
		String destinos = "";
		String destino;
		boolean validar;
		
		//Numero de destinatarios
		do {
			numero_destinos = Utilidades.pedirEntero("Numero de destinatarios: ");
			if (numero_destinos<1) {
				System.out.println("**Tienes que mandar al menos un correo**");
			}
		}while (numero_destinos<1);

		//Validar y añadir correo
		for (int i = 0; i < numero_destinos; i++) {
			do {
				//Pedir
				destino = Utilidades.pedirTexto("Dime el destinatario " + (i + 1) + ": ");
				//Validar
				validar = validar_destinatario(destino);
				if (validar == true) {
					System.out.println("El email ingresado es válido.");
					destinos = (destinos + "," + destino);
				} else {
					System.out.println("**El email +" + (i + 1) + " ingresado es inválido, intentalo de nuevo**");
				}
			} while (validar == false); //Repetir en caso de ser invalido
		}
		return destinos;
	}

	public static boolean validar_destinatario(String destino) {
		// Patrón para validar el email
		Pattern pattern = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

		// El email a validar
		Matcher mather = pattern.matcher(destino);

		return mather.find();
	}
}
