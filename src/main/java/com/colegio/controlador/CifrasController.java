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
import com.colegio.entidad.Departamento;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
@Controller
@SessionAttributes("MENSAJE")
public class CifrasController {
	
	private List<Cifras> lstCifras;
	
	public List<Cifras> getLstCifras() {
		return lstCifras;
	}
	public void setLstCifras(List<Cifras> lstCifras) {
		this.lstCifras = lstCifras;
	}
	public List<Departamento> getLstDepartamento() {
		return lstDepartamento;
	}
	public void setLstDepartamento(List<Departamento> lstDepartamento) {
		this.lstDepartamento = lstDepartamento;
	}
	private List<Departamento> lstDepartamento;
	
	
	@RequestMapping("/verCifras")
	public String metVerCiudadano() {
		return "registraCifras";
	}
	


	@RequestMapping("/cargaCifras")
	@ResponseBody
	public List<Cifras> lista() {
		String readLine=ObtenerJson("http://env-6360882.j.layershift.co.uk/rest/servicios/cifras");
		Type listType = null;
		Gson gson = new Gson();
		listType = new TypeToken<ArrayList<Cifras>>(){}.getType();
		System.out.println(listType);
    	ArrayList<Cifras> arrayDeJson = gson.fromJson(readLine, listType);
    	lstCifras=arrayDeJson;    	
		return lstCifras;
	}
	
	@RequestMapping("/cargaDepartamento")
	@ResponseBody
	public List<Departamento> listaDepartamento() {
		String readLine=ObtenerJson("http://env-6360882.j.layershift.co.uk/rest/servicios/departamento");
		Type listType = null;
		Gson gson = new Gson();
		listType = new TypeToken<ArrayList<Departamento>>(){}.getType();
    	ArrayList<Departamento> arrayDeJson = gson.fromJson(readLine, listType);
    	lstDepartamento=arrayDeJson;    	
	return lstDepartamento;
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
		@RequestMapping("/updateCifras")
		public String metupdateCifras(Cifras bean, Model m) {
				Gson gson = new Gson();
				String json=gson.toJson(bean);
				System.out.println(json);
				try {
					int responseCode =PUTRequest(json,"http://env-6360882.j.layershift.co.uk/rest/servicios/cifras/update/");
					if (responseCode!=200)
						m.addAttribute("MENSAJE", "Actualización erronea");
					else
						m.addAttribute("MENSAJE", "Actualización exitosa");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return "redirect:verCifras";
		}
		
		@RequestMapping("/saveCifras")
		public String metsaveCifras(Cifras bean, Model m) {
				Gson gson = new Gson();
				String json=gson.toJson(bean);
				System.out.println(json);
				try {
					int responseCode =POSTRequest(json,"http://env-6360882.j.layershift.co.uk/rest/servicios/cifras/add/");
					if (responseCode!=200)
						m.addAttribute("MENSAJE", "Actualización erronea");
					else
						m.addAttribute("MENSAJE", "Actualización exitosa");
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			return "redirect:verCifras";
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
