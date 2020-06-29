package com.colegio.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colegio.entidad.Usuario;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



@Controller
@SessionAttributes("MENSAJE")
public class LoginController {

	
	
	@RequestMapping("/verLogin")
	public String metLogin() {
		
		return "Login";
	}
	
	
	@RequestMapping("/verValidarUsuario")
	public String metMenuL(Usuario bean, Model m) {
		System.out.println(bean.getDni());
		System.out.println(bean.getPassword());
		String dni=bean.getDni();
		String contra=bean.getPassword();
		
			System.out.println("Entro");
			String readLine=ObtenerJsonUsuario("http://localhost:8080/WS_REST_Servidor/rest/servicios/usuario/"+dni+"/"+contra);
			Type listType = null;
			Gson gson = new Gson();
			listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
	    	ArrayList<Usuario> arrayDeJson = gson.fromJson(readLine, listType);
	    	System.out.println(arrayDeJson);
			if (arrayDeJson.size()==0) {
				m.addAttribute("MENSAJE", "Usuario y contraseña incorrectos");
			}else {
				for (Usuario Usuario : arrayDeJson) {
					if (Usuario.getRol().getDescripcion().equals("ADMIN")) {
						return "redirect:verMenu";
					} else {
						m.addAttribute("MENSAJE", "Usted no cuenta con los permisos necesarios");
						return "redirect:verLogin";
					}
				}
				
			}
			
		
		
		return "redirect:verLogin";
	}
	
	
	public String ObtenerJsonUsuario(String url) {
		URL urlgetTipodoc = null;
		String readLine = null;
		try {
			urlgetTipodoc = new URL(url);
			HttpURLConnection conection = (HttpURLConnection) urlgetTipodoc.openConnection();
			conection.setRequestMethod("GET");
			int responseCode = conection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
				readLine = in.readLine();
				in.close();
			} else {
				System.out.println("GET NOT WORKED");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return readLine;
	}
	

	
	
	
}
