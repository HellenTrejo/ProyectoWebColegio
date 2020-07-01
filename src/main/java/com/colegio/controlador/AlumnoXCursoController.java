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

import com.colegio.entidad.Curso;
import com.colegio.entidad.Usuario;
import com.colegio.entidad.UsuarioxCurso;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
@Controller
@SessionAttributes("MENSAJE")
public class AlumnoXCursoController {
	
	private List<UsuarioxCurso> lstAlumnoxCurso;

	public List<UsuarioxCurso> getLstAlumnoxCurso() {
		return lstAlumnoxCurso;
	}

	public void setLstAlumnoxCurso(List<UsuarioxCurso> lstAlumnoxCurso) {
		this.lstAlumnoxCurso = lstAlumnoxCurso;
	}
	
	

	@RequestMapping("/verAlumnoXCurso")
	public String metVerCiudadano() {
		return "registraAlumnoPorCurso";
	}
	
	//@RequestMapping("/verConsultaAlumnoXCurso")
	//public String metVerConsultaAlumnoxCurso() {
	//return "ConsultaAlumnoPorCurso";
	//}
	
	
	@RequestMapping("/verConsultaAlumnoXCurso")
	public String metVerSintomas() {
		URL urlForGetRequest = null;
		try {
			urlForGetRequest = new URL("http://localhost:8080/WS_REST_Servidor/rest/servicios/alumnoxCurso");
			String readLine = null;
		    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		    conection.setRequestMethod("GET");
		    int responseCode = conection.getResponseCode();
		    if (responseCode == HttpURLConnection.HTTP_OK) {
		        BufferedReader in = new BufferedReader(
		            new InputStreamReader(conection.getInputStream()));
		        Type listType = null;
		        while ((readLine = in.readLine()) != null) {
		        	Gson gson = new Gson();
		        	listType = new TypeToken<ArrayList<UsuarioxCurso>>(){}.getType();
		        	ArrayList<UsuarioxCurso> arrayDeJson = gson.fromJson(readLine, listType);
		        	lstAlumnoxCurso=arrayDeJson;
		        } in.close();
		    } else {
		        System.out.println("GET NOT WORKED");
		    }

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ConsultaAlumnoPorCurso";
	}


	
	
	
	@RequestMapping("/cargaAlumnoXCurso")
	@ResponseBody
	public List<UsuarioxCurso> lista() {
		return lstAlumnoxCurso;//servicio.listaTriaje();
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
		
		
		@RequestMapping("/saveAlumnoXCurso")
		public String metsaveCurso(UsuarioxCurso bean, Model m) {
				Gson gson = new Gson();
				String json=gson.toJson(bean);
				System.out.println(json);
				try {
					int responseCode =POSTRequest(json,"http://localhost:8080/WS_REST_Servidor/rest/servicios/usuarioxCurso/add/");
					if (responseCode!=200)
						m.addAttribute("MENSAJE", "Registro erroneo");
					else
						m.addAttribute("MENSAJE", "Registro exitoso");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return "redirect:verAlumnoXCurso";
		}
	
	
}
