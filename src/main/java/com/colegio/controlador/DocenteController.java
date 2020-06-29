package com.colegio.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colegio.entidad.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Controller
@SessionAttributes("MENSAJE")
public class DocenteController {
	
	private List<Usuario> lstDocente;
	
	
	
	public List<Usuario> getLstDocente() {
		return lstDocente;
	}

	public void setLstDocente(List<Usuario> lstDocente) {
		this.lstDocente = lstDocente;
	}



	@RequestMapping("/verDocente")
	public String metVerDocente() {
		return "registraDocente";
	}
	


	@RequestMapping("/cargaDocente")
	@ResponseBody
	public List<Usuario> lista() {
		String readLine=ObtenerJson("http://localhost:8080/WS_REST_Servidor/rest/servicios/docente");
		Type listType = null;
		Gson gson = new Gson();
		listType = new TypeToken<ArrayList<Usuario>>(){}.getType();
		System.out.println(listType);
    	ArrayList<Usuario> arrayDeJson = gson.fromJson(readLine, listType);
    	lstDocente=arrayDeJson;    	
		return lstDocente;
	}
	
	
public String ObtenerJson(String url) {
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
public int PUTRequest(String POST_PARAMS,String url) throws IOException {
    URL obj = new URL(url);
    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
    postConnection.setRequestMethod("PUT");
    postConnection.setRequestProperty("Content-Type", "application/json");
    postConnection.setDoOutput(true);
    OutputStream os = postConnection.getOutputStream();
    os.write(POST_PARAMS.getBytes());
    os.flush();
    os.close();
    int responseCode = postConnection.getResponseCode();
    System.out.println("POST Response Code :  " + responseCode);
    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
    if (responseCode == HttpURLConnection.HTTP_CREATED) {
        BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null){
            response.append(inputLine);
        }in.close();
        System.out.println(response.toString());
    } else {
        System.out.println("POST NOT WORKED");
    }
    
    return responseCode;
}
		@RequestMapping("/updateDocente")
		public String metupdateDocente(Usuario bean, Model m) {
				Gson gson = new Gson();
				String json=gson.toJson(bean);
				System.out.println(json);
				try {
					int responseCode =PUTRequest(json,"http://localhost:8080/WS_REST_Servidor/rest/servicios/usuario/update/");
					if (responseCode!=200)
						m.addAttribute("MENSAJE", "Actualización erronea");
					else
						m.addAttribute("MENSAJE", "Actualización exitosa");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return "redirect:verDocente";
		}
		
		@RequestMapping("/saveDocente")
		public String metsaveDocente(Usuario bean, Model m) {
				Gson gson = new Gson();
				String json=gson.toJson(bean);
				System.out.println(json);
				try {
					int responseCode =POSTRequest(json,"http://localhost:8080/WS_REST_Servidor/rest/servicios/usuario/add/");
					if (responseCode!=200)
						m.addAttribute("MENSAJE", "Registro erroneo");
					else
						m.addAttribute("MENSAJE", "Registro exitoso");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return "redirect:verDocente";
		}
		
		
		public int POSTRequest(String POST_PARAMS,String url) throws IOException {
		    URL obj = new URL(url);
		    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		    postConnection.setRequestMethod("POST");
		    postConnection.setRequestProperty("Content-Type", "application/json");
		    postConnection.setDoOutput(true);
		    OutputStream os = postConnection.getOutputStream();
		    os.write(POST_PARAMS.getBytes());
		    os.flush();
		    os.close();
		    int responseCode = postConnection.getResponseCode();
		    System.out.println("POST Response Code :  " + responseCode);
		    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
		    if (responseCode == HttpURLConnection.HTTP_CREATED) {
		        BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
		        String inputLine;
		        StringBuffer response = new StringBuffer();
		        while ((inputLine = in.readLine()) != null){
		            response.append(inputLine);
		        }in.close();
		        System.out.println(response.toString());
		    } else {
		        System.out.println("POST NOT WORKED");
		    }
		    
		    return responseCode;
		}
	
}
