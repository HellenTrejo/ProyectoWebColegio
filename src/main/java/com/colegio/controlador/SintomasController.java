package com.colegio.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.colegio.entidad.Triaje;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
@SessionAttributes("MENSAJE")
public class SintomasController {

	
	private List<Triaje> lstTriaje;
	
	
	public List<Triaje> getLstTriaje() {
		return lstTriaje;
	}


	public void setLstTriaje(List<Triaje> lstTriaje) {
		this.lstTriaje = lstTriaje;
	}


	@RequestMapping("/verSintomas")
	public String metVerSintomas() {
		URL urlForGetRequest = null;
		try {
			urlForGetRequest = new URL("http://env-6360882.j.layershift.co.uk/rest/servicios/triajes");
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
		        	listType = new TypeToken<ArrayList<Triaje>>(){}.getType();
		        	ArrayList<Triaje> arrayDeJson = gson.fromJson(readLine, listType);
		        	lstTriaje=arrayDeJson;
		        } in.close();
		    } else {
		        System.out.println("GET NOT WORKED");
		    }

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "consultaSintomas";
	}
	
	
	@RequestMapping("/cargaTriage")
	@ResponseBody
	public List<Triaje> lista() {
		return lstTriaje;//servicio.listaTriaje();
	}
	
	
}
