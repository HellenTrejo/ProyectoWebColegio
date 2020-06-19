package com.colegio.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

import com.colegio.entidad.Cifras;
import com.colegio.entidad.Estado;
import com.colegio.entidad.Nacionalidad;
import com.colegio.entidad.Persona;
import com.colegio.entidad.TipoDocumento;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
@Controller
@SessionAttributes("MENSAJE")
public class CiudadanosController {
	
	private List<Persona> lstPersona;
	
	private List<TipoDocumento> lstTipoDoc;
	private List<Nacionalidad> lstNacionalidad;
	private List<Estado> lstEstado;
	
	public List<Nacionalidad> getLstNacionalidad() {
		return lstNacionalidad;
	}
	public void setLstNacionalidad(List<Nacionalidad> lstNacionalidad) {
		this.lstNacionalidad = lstNacionalidad;
	}
	public List<Estado> getLstEstado() {
		return lstEstado;
	}
	public void setLstEstado(List<Estado> lstEstado) {
		this.lstEstado = lstEstado;
	}
	public List<TipoDocumento> getLstTipoDoc() {
		return lstTipoDoc;
	}
	public void setLstTipoDoc(List<TipoDocumento> lstTipoDoc) {
		this.lstTipoDoc = lstTipoDoc;
	}
	public List<Persona> getLstPersona() {
		return lstPersona;
	}
	public void setLstPersona(List<Persona> lstPersona) {
		this.lstPersona = lstPersona;
	}
	@RequestMapping("/verCiudadano")
	public String metVerCiudadano() {
		URL urlForGetRequest = null;
		try {
			urlForGetRequest = new URL("http://env-6360882.j.layershift.co.uk/rest/servicios/persona");
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
		        	listType = new TypeToken<ArrayList<Persona>>(){}.getType();
		        	ArrayList<Persona> arrayDeJson = gson.fromJson(readLine, listType);
		        	lstPersona=arrayDeJson;
		        } in.close();
		    } else {
		        System.out.println("GET NOT WORKED");
		    }

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "consultaCiudadanos";
	}
	


	@RequestMapping("/cargaPersona")
	@ResponseBody
	public List<Persona> lista() {
		return lstPersona;
	}
	
	@RequestMapping("/cargaTipoDocumento")
	@ResponseBody
	public List<TipoDocumento> listaTipoDoc() {
		String readLine=ObtenerJson("http://env-6360882.j.layershift.co.uk/rest/servicios/tipodoc");
		Type listType = null;
		Gson gson = new Gson();
		listType = new TypeToken<ArrayList<TipoDocumento>>(){}.getType();
    	ArrayList<TipoDocumento> arrayDeJson = gson.fromJson(readLine, listType);
    	lstTipoDoc=arrayDeJson;    	
	return lstTipoDoc;
}
	
	@RequestMapping("/cargaNacionalidad")
	@ResponseBody
	public List<Nacionalidad> listaNacionalidad() {
		String readLine=ObtenerJson("http://env-6360882.j.layershift.co.uk/rest/servicios/nacionalidad");
		Type listType = null;
		Gson gson = new Gson();
		listType = new TypeToken<ArrayList<Nacionalidad>>() {
		}.getType();
		ArrayList<Nacionalidad> arrayDeJson = gson.fromJson(readLine, listType);
		lstNacionalidad = arrayDeJson;
	return lstNacionalidad;
}
	
	@RequestMapping("/cargaEstado")
	@ResponseBody
	public List<Estado> listaEstado() {
		String readLine=ObtenerJson("http://env-6360882.j.layershift.co.uk/rest/servicios/estados");
		Type listType = null;
		Gson gson = new Gson();
		listType = new TypeToken<ArrayList<Estado>>() {
		}.getType();
		ArrayList<Estado> arrayDeJson = gson.fromJson(readLine, listType);
		lstEstado = arrayDeJson;
	return lstEstado;
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
		@RequestMapping("/updatePersona")
		public String metsavePersona(Persona bean, Model m) {
				Gson gson = new Gson();
				String json=gson.toJson(bean);
				System.out.println(json);
				try {
					int responseCode =PUTRequest(json,"http://env-6360882.j.layershift.co.uk/rest/servicios/persona/update/");
					if (responseCode!=200)
						m.addAttribute("MENSAJE", "Actualización erronea");
					else
						m.addAttribute("MENSAJE", "Actualización exitosa");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return "redirect:verCiudadano";
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
		
		
		@RequestMapping("/saveCiudadano")
		public String metsaveCiudadano(Persona bean, Model m) {
				Gson gson = new Gson();
				String json=gson.toJson(bean);
				System.out.println(json);
				try {
					int responseCode =POSTRequest(json,"http://env-6360882.j.layershift.co.uk/rest/servicios/persona/add/");
					if (responseCode!=200)
						m.addAttribute("MENSAJE", "Registro erroneo");
					else
						m.addAttribute("MENSAJE", "Registro exitoso");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return "redirect:verCiudadano";
		}
		
	
}
