package org.test.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.test.entity.Agence;
import org.test.entity.RefreshTokenRequest;
import org.test.entity.admin;
import org.test.entity.banquier;
import org.test.entity.credit;
import org.test.entity.historiqueadmin;
import org.test.entity.infocredit;
import org.test.entity.jwtRequest;

@Controller
@RequestMapping("/test")
public class testcontr {
@Autowired
	private RestTemplate restTemplate;

@GetMapping(value="/postbanquier")

public Object getformbanquier(Model model ,HttpSession testy) {
	if(testy.getAttribute("id")==null||testy.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	HttpHeaders headers2 = new HttpHeaders();
    headers2.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
    headers2.setContentType(MediaType.APPLICATION_JSON);
  try {  
    HttpEntity<?> entity ;
    entity=(HttpEntity<?>) test(restTemplate,testy);
    ResponseEntity<Agence[]> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/api/agencies", //
            HttpMethod.GET, entity, Agence[].class);
    HttpStatus statusCode = response.getStatusCode();
    if (statusCode == HttpStatus.OK) {
 model.addAttribute("ttest",response.getBody());
	model.addAttribute("banquier", new banquier());
return "formbanquier";	
    }
  }
catch(Exception e) {
		  if(test3(restTemplate,testy)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,testy)=="hello") {
   return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,testy);
ResponseEntity<Agence[]> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/api/agencies", //
        HttpMethod.GET, entity2, Agence[].class);
			    HttpStatus statusCode2 = response2.getStatusCode();
			    if (statusCode2 == HttpStatus.OK) {    
			    	model.addAttribute("ttest",response2.getBody());
			    	model.addAttribute("banquier", new banquier());
return "formbanquier";
			    	} testy.removeAttribute("token");
						testy.removeAttribute("refresh");
			    	return new ModelAndView("redirect:/test/logout" );}
			    else {
			    	 testy.removeAttribute("token");
						testy.removeAttribute("refresh");			    	
				return new ModelAndView("redirect:/test/logout" );				
		  }
		  }
	  return new ModelAndView("redirect:/test/logout" );
}

@GetMapping("/deletebanquier")
public Object deletebanquier(Long id,HttpSession testy) {
	
	if(testy.getAttribute("id")==null||testy.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}	
	
	
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,testy)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,testy);
  ResponseEntity<Void> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/banker/banquiers/"+id, 
          HttpMethod.DELETE, entity, Void.class);
  HttpStatus statusCode = response.getStatusCode();
  if (statusCode == HttpStatus.OK) {
	  return new ModelAndView("redirect:/test/banquiers" );}}
catch(Exception e) {
	if(test3(restTemplate,testy)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,testy)=="hello") {
return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,testy);
ResponseEntity<Void> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/banker/banquiers/"+id, 
 HttpMethod.DELETE, entity2, Void.class);
		    HttpStatus statusCode2 = response2.getStatusCode();
		    if (statusCode2 == HttpStatus.OK) {   
		    	return new ModelAndView("redirect:/test/banquiers" );}
		    else {
		    	 testy.removeAttribute("token");
					testy.removeAttribute("refresh");
					return new ModelAndView("redirect:/test/logout" );			
	  }}}
return new ModelAndView("redirect:/test/logout" );}

@PostMapping(value="/addbanquier")
public Object addbanquier(Model model,banquier banquier,HttpSession testo ) {
	if(testo.getAttribute("id")==null||testo.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	 if(testo.getAttribute("token").toString()==null &&testo.getAttribute("id")!=null) {
		 return new ModelAndView("signin" );
	 }
try {	
	String ctre="Bearer "+testo.getAttribute("token");
	  headers.set("Autorization",ctre );	  
	HttpEntity<banquier> testtt= new HttpEntity<>(banquier,headers);
   ResponseEntity<banquier> result 
   = restTemplate.postForEntity("https://bank-app-api.herokuapp.com/banker/addBanker/"+banquier.getIdagencee(), testtt, banquier.class);
   if (result.getStatusCode() == HttpStatus.OK) {
	   banquier test=result.getBody();
  	 model.addAttribute("test",test);
  	 return "confirmationbanquier";
  	}}
catch(Exception e) {
	  if(test3(restTemplate,testo)==true) {
		  try {
		  String ctre="Bearer "+testo.getAttribute("token");
		  headers.set("Autorization",ctre );
		HttpEntity<banquier> testtt= new HttpEntity<>(banquier,headers);
	     ResponseEntity<banquier> result 
	     = restTemplate.postForEntity("https://bank-app-api.herokuapp.com/banker/addBanker/"+banquier.getIdagencee(), testtt, banquier.class);
		    if (result.getStatusCode() == HttpStatus.OK) {   
		    	model.addAttribute("test3",result.getBody());
			return "confirmationbanquier";
			 }}
		    catch(Exception ex) {
				  testo.removeAttribute("token");
					testo.removeAttribute("refresh");
				  return new ModelAndView("redirect:/test/logout" );
			  }
		    return new ModelAndView("redirect:/test/logout" );
		  }
	  else {
		  testo.removeAttribute("token");
			testo.removeAttribute("refresh");
		  return new ModelAndView("redirect:/test/logout" );
	  }
	  }
return new ModelAndView("redirect:/test/logout" );
}
@GetMapping("/banquiers")
public Object getbanquiers(Model model,HttpSession test) {
	if(test.getAttribute("id")==null||test.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,test)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,test);
	    ResponseEntity<?> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/banker/bankers", //
	            HttpMethod.GET, entity, banquier[].class);
	  HttpStatus statusCode = response.getStatusCode();
	    if (statusCode == HttpStatus.OK) {   
		model.addAttribute("test",response.getBody());
	return "banquiers";
	    }}
catch(Exception e) {
		  if(test3(restTemplate,test)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,test)=="hello") {
   return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,test);
			    ResponseEntity<banquier[]> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/banker/bankers", //
			            HttpMethod.GET, entity2, banquier[].class);
			    HttpStatus statusCode2 = response2.getStatusCode();
			    if (statusCode2 == HttpStatus.OK) {   
			    	model.addAttribute("test",response2.getBody());
				return new ModelAndView("redirect:/test/banquiers" );				
		  }
		  else {
			  test.removeAttribute("token");
				test.removeAttribute("refresh");
			  return new ModelAndView("redirect:/test/logout" );
		  }
		  }}
	  return new ModelAndView("redirect:/test/logout" );
	}

@GetMapping("/admins")
public Object getadmins(Model model,HttpSession test) {
	if(test.getAttribute("id")==null||test.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,test)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,test);
	    ResponseEntity<?> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/admin/admins", //
	            HttpMethod.GET, entity, admin[].class);
	  HttpStatus statusCode = response.getStatusCode();
	    if (statusCode == HttpStatus.OK) {   
		model.addAttribute("test",response.getBody());
	return "admins";
	    }
	}
catch(Exception e) {
		  if(test3(restTemplate,test)==true) {
HttpEntity<?> entity2;
entity2 = (HttpEntity<?>) test(restTemplate,test);
			    ResponseEntity<admin[]> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/admin/admins", //
			            HttpMethod.GET, entity2, admin[].class);
			    HttpStatus statusCode2 = response2.getStatusCode();
			    if (statusCode2 == HttpStatus.OK) {   
			    	model.addAttribute("test",response2.getBody());
			    	return new ModelAndView("redirect:/test/banquiers" );
 }
		  else {
			  test.removeAttribute("token");
				test.removeAttribute("refresh");
			  return new ModelAndView("redirect:/test/logout" ); 
		  }
		  }}
	  return new ModelAndView("redirect:/test/logout" );
	}
@GetMapping("/deleteadmin")
public Object deleteadmin(Long id,HttpSession testy) {
	if(testy.getAttribute("id")==null||testy.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,testy)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,testy);
  ResponseEntity<Void> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/admin/admin/"+id, 
          HttpMethod.DELETE, entity, Void.class);
  HttpStatus statusCode = response.getStatusCode();
  if (statusCode == HttpStatus.OK) {
	  return new ModelAndView("redirect:/test/admins" );}}
catch(Exception e) {
	  if(test3(restTemplate,testy)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,testy)=="hello") {
return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,testy);
ResponseEntity<Void> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/admin/admin/"+id, 
 HttpMethod.DELETE, entity2, Void.class);
		    HttpStatus statusCode2 = response2.getStatusCode();
		    if (statusCode2 == HttpStatus.OK) {   
		    	return new ModelAndView("redirect:/test/admins" );}
		    else {
		    	 testy.removeAttribute("token");
					testy.removeAttribute("refresh");
					return new ModelAndView("redirect:/test/logout" );
	  }	  }}
return new ModelAndView("redirect:/test/logout" );
}
 

@GetMapping(value="/postadmin")

public Object getformadmin(Model model ,HttpSession vers) {
	if(vers.getAttribute("id")==null||vers.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	model.addAttribute("admin", new admin());
	return "formadmin";
}

@PostMapping(value="/addadmin")
public Object addadmin(Model model,admin admin,HttpSession testo ) {
	if(testo.getAttribute("id")==null||testo.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	 if(testo.getAttribute("token").toString()==null &&testo.getAttribute("id")!=null) {
		 return new ModelAndView("signin" );
	 }
try {	
	String ctre="Bearer "+testo.getAttribute("token");
	  headers.set("Autorization",ctre );	  
	HttpEntity<admin> testtt= new HttpEntity<>(admin,headers);
   ResponseEntity<admin> result 
   = restTemplate.postForEntity("https://bank-app-api.herokuapp.com/admin/addadmin", testtt, admin.class);
   if (result.getStatusCode() == HttpStatus.OK) {
	   admin test=result.getBody();
  	 model.addAttribute("test",test);
  	 return "confirmationadmin";
  	}}
catch(Exception e) {
	  if(test3(restTemplate,testo)==true) {
		  try {
		  String ctre="Bearer "+testo.getAttribute("token");
		  headers.set("Autorization",ctre );
		 		HttpEntity<admin> testtt= new HttpEntity<>(admin,headers);
 ResponseEntity<admin> result 
	     = restTemplate.postForEntity("https://bank-app-api.herokuapp.com/admin/addadmin", testtt, admin.class);
 if (result.getStatusCode() == HttpStatus.OK) {   
		    	model.addAttribute("test",result.getBody());
			return "confirmationadmin";
			 }}
		    catch(Exception ex) {
				  testo.removeAttribute("token");
					testo.removeAttribute("refresh");
				  return new ModelAndView("redirect:/test/logout" );
			  }
		    return new ModelAndView("redirect:/test/logout" );
		  }
	  else {
		  testo.removeAttribute("token");
			testo.removeAttribute("refresh");
		  return new ModelAndView("redirect:/test/logout" );
	  }
	  }
return new ModelAndView("redirect:/test/logout" );	
}

@GetMapping(value="/modimdp")
public Object modimdp(Model model,Long id,HttpSession testo ) {
	if(testo.getAttribute("id")==null||testo.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	 if(testo.getAttribute("token").toString()==null &&testo.getAttribute("id")!=null) {
		 return new ModelAndView("signin" );
	 }
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,testo)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,testo);
		ResponseEntity<Void> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/banker/sendpassword/"+id, 
				  HttpMethod.PUT, entity, Void.class);
   if (response2.getStatusCode() == HttpStatus.OK) {
	   return new ModelAndView("redirect:/test/banquiers" );
  	}}
catch(Exception e) {
	  if(test3(restTemplate,testo)==true) {
		  try {
			  entity=(HttpEntity<?>) test(restTemplate,testo);
				ResponseEntity<Void> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/banker/sendpassword/"+id, 
						  HttpMethod.PUT, entity, Void.class);
		   if (response2.getStatusCode() == HttpStatus.OK) {
			   return new ModelAndView("redirect:/test/banquiers" );
		  	}
		   }
		    catch(Exception ex) {
				  testo.removeAttribute("token");
					testo.removeAttribute("refresh");
				  return new ModelAndView("redirect:/test/logout" );
			  }
		    return new ModelAndView("redirect:/test/logout" );
		  }
	  else {
		  testo.removeAttribute("token");
			testo.removeAttribute("refresh");
		  return new ModelAndView("redirect:/test/logout" );
	  }
	  }
return new ModelAndView("redirect:/test/logout" );

}
	/*
@GetMapping(value="getformmdp")
public Object getformmdp(Model model,Long id ,HttpSession testy) {
	HttpHeaders headers2 = new HttpHeaders();
    headers2.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
    headers2.setContentType(MediaType.APPLICATION_JSON);
	model.addAttribute("formmdp", new String());
	model.addAttribute("idd", id);
	return "modifmdp";
}
*/
@GetMapping("/acceptercredit")
public Object acceptercredit(Long id, Long ida,HttpSession testy) {
	if(testy.getAttribute("id")==null||testy.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,testy)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,testy);
  ResponseEntity<Void> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/credit/activerCredit/"+id, 
          HttpMethod.PUT, entity, Void.class);
  HttpStatus statusCode = response.getStatusCode();
  if (statusCode == HttpStatus.OK) {
	return new ModelAndView("redirect:/test/credits?idagence="+ida);
  }}
catch(Exception e) {

	  if(test3(restTemplate,testy)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,testy)=="hello") {
return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,testy);
ResponseEntity<Void> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/credit/activerCredit/"+id, 
 HttpMethod.PUT, entity2, Void.class);
		    HttpStatus statusCode2 = response2.getStatusCode();
		    if (statusCode2 == HttpStatus.OK) {   
		    	return new ModelAndView("redirect:/test/credits?idagence="+ida);}
		    else {
		    	 testy.removeAttribute("token");
					testy.removeAttribute("refresh");
					return new ModelAndView("redirect:/test/logout" );			
	  }
	  }}
return new ModelAndView("redirect:/test/logout" );
}

@GetMapping("/rejetercredit")
public Object rejetercredit(Long id,Long ida,HttpSession testy) {
	if(testy.getAttribute("id")==null||testy.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,testy)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,testy);
 ResponseEntity<Void> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/credit/"+id+"/delete", 
         HttpMethod.DELETE, entity, Void.class);
 HttpStatus statusCode = response.getStatusCode();
 if (statusCode == HttpStatus.OK) {
	return new ModelAndView("redirect:/test/credits?idagence="+ida);
 }}
catch(Exception e) {
	if(test3(restTemplate,testy)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,testy)=="hello") {
return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,testy);
ResponseEntity<Void> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/credit/"+id+"/delete", 
HttpMethod.DELETE, entity2, Void.class);
		    HttpStatus statusCode2 = response2.getStatusCode();
		    if (statusCode2 == HttpStatus.OK) {   
		    	return new ModelAndView("redirect:/test/credits?idagence="+ida);}
		    else {
		    	 testy.removeAttribute("token");
					testy.removeAttribute("refresh");
					return new ModelAndView("redirect:/test/logout" );			
	  }
	  }}
return new ModelAndView("redirect:/test/logout" );
}

@GetMapping("/deleteagence")
public Object getagences(Long id,HttpSession testy) {
	if(testy.getAttribute("id")==null||testy.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 HttpEntity<?> entity ;
	    if(    test(restTemplate,testy)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,testy);
   ResponseEntity<infocredit> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/api/deleteagence/"+id, 
           HttpMethod.DELETE, entity, infocredit.class);
   HttpStatus statusCode = response.getStatusCode();
   if (statusCode == HttpStatus.OK) {
	return "redirect:/test/agences";}}
catch(Exception e) {
	if(test3(restTemplate,testy)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,testy)=="hello") {
return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,testy);
ResponseEntity<Void> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/api/deleteagence/"+id, 
  HttpMethod.DELETE, entity2, Void.class);
		    HttpStatus statusCode2 = response2.getStatusCode();
		    if (statusCode2 == HttpStatus.OK) {   
		    	return "redirect:/test/agences";}
		    else {
		    	 testy.removeAttribute("token");
					testy.removeAttribute("refresh");
					return new ModelAndView("redirect:/test/logout" );			
	  }
	  }}
return new ModelAndView("redirect:/test/logout" );

}

@GetMapping(value="/postagence")
public Object getformagence(Model model ,HttpSession vers) {
	if(vers.getAttribute("id")==null||vers.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	model.addAttribute("agence", new Agence());
	return "formagence";
}


@GetMapping("/detailss")
public Object getdetails(Model model,Long ida,HttpSession testy) {
	if(testy.getAttribute("id")==null||testy.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 HttpEntity<?> entity ;
	 int test=0;
	    if(    test(restTemplate,testy)=="hello") {
	   return new ModelAndView("signin" );}
	try {
		entity=(HttpEntity<?>) test(restTemplate,testy);
    ResponseEntity<infocredit> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/infos/"+ida, 
            HttpMethod.GET, entity, infocredit.class);
    HttpStatus statusCode = response.getStatusCode();
    if (statusCode == HttpStatus.OK) {
    	
   if(response.getBody().getMensualite()>(0.2*response.getBody().getSalaire())) { test=2;
   }model.addAttribute("cond",test);
	model.addAttribute("details",response.getBody());
	return "details";}}
catch(Exception e) {
		  if(test3(restTemplate,testy)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,testy)=="hello") {
   return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,testy);
ResponseEntity<infocredit> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/infos/"+ida, 
        HttpMethod.GET, entity2, infocredit.class);
			    HttpStatus statusCode2 = response2.getStatusCode();
			    if (statusCode2 == HttpStatus.OK) {   
			    	   if(response2.getBody().getMensualite()>(0.2*response2.getBody().getSalaire())) { test=2;
			    	   }model.addAttribute("cond",test);
			    		model.addAttribute("details",response2.getBody());
			    		return "details";}
			    else {
			    	 testy.removeAttribute("token");
						testy.removeAttribute("refresh");
			    	model.addAttribute("test",response2.getBody());
				return new ModelAndView("redirect:/test/logout" );				
		  }
		  }}
	  return new ModelAndView("redirect:/test/logout" );
	}

@GetMapping("/historique")
public Object gethisto(Model model,Long id,HttpSession test4) {
	if(test4.getAttribute("id")==null||test4.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	 Long vari;
	  if(id==null) {
		  if(test4.getAttribute("idagence")==null) {
			  return new ModelAndView("redirect:/test/logout" );
		  }
		  vari=Long.parseLong(test4.getAttribute("idagence").toString());
	  }else {
		  vari=id;
		  test4.setAttribute("idagence", id);
	  }
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<?> entity ;
    if(    test(restTemplate,test4)=="hello") {
       return new ModelAndView("signin" );}
 try {   entity= (HttpEntity<?>) test(restTemplate,test4);
    ResponseEntity<historiqueadmin[]> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/histo/"+vari, //
            HttpMethod.GET, entity,historiqueadmin[].class);
    HttpStatus statusCode = response.getStatusCode();
    if (statusCode == HttpStatus.OK) {
	model.addAttribute("test5",response.getBody());
	List<Double>testy=new ArrayList<Double>();
	List<Double>testy2=new ArrayList<Double>();
	List<Double>testy3=new ArrayList<Double>();
	List<String> dates=new ArrayList<String>();
	List<Double>difference=new ArrayList<Double>();
SimpleDateFormat datee=new SimpleDateFormat("yyyy-MM-dd");
int d=0;
historiqueadmin actuel=new historiqueadmin();
for(historiqueadmin k:response.getBody()) {
	if(d>=response.getBody().length-30) {
		testy.add(k.getSoldeagence());
		testy2.add(k.getRestecredit());
		testy3.add(k.getSoldeclients());
		difference.add(k.getSoldeagence()-k.getSoldeclients()+k.getRestecredit());
		dates.add(datee.format(k.getJour()));
	}d++;
	if(d==response.getBody().length) {actuel.setSoldeclients(k.getSoldeclients());
	actuel.setRestecredit(k.getRestecredit());
	actuel.setSoldeagence(k.getSoldeagence());
	}
	}
	model.addAttribute( "agence",testy.toArray());
	model.addAttribute( "credits",testy2.toArray());
	model.addAttribute( "clients",testy3.toArray());
	model.addAttribute( "difference",difference.toArray());
	model.addAttribute("dates",dates.toArray());
	model.addAttribute("actuel",actuel);
    }}
	catch(Exception e) {
		  if(test3(restTemplate,test4)==true) {
			  return new ModelAndView("redirect:/test/historique?id="+test4.getAttribute("idagence") );}
		  else {
			  test4.removeAttribute("token");
			test4.removeAttribute("refresh");
			  return new ModelAndView("redirect:/logout" );
		       }
	  }
     HttpEntity<?> entity2;
     if(    test(restTemplate,test4)=="hello") {
    	   return new ModelAndView("signin" );}
try {     entity2= (HttpEntity<?>) test(restTemplate,test4);
    ResponseEntity<Double[]> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/histo/infos/"+id, //
            HttpMethod.GET, entity2,Double[].class);
    if(response2.getStatusCode()==HttpStatus.OK) {
    List<Double>infoos=new ArrayList<Double>();
    for(Double g:response2.getBody()) {
    	infoos.add(g);
    }
    Double percent1=infoos.get(1)*100/(infoos.get(1)+infoos.get(2));
    Double percent2=infoos.get(2)*100/(infoos.get(1)+infoos.get(2));
    Double percent3=infoos.get(3)*100/(infoos.get(1)+infoos.get(2));
    Double percent4=infoos.get(4)*100/(infoos.get(1)+infoos.get(2));
    model.addAttribute("bankers",infoos.get(0));
    model.addAttribute("couvert",percent1);
    model.addAttribute("cferme",percent2);
    model.addAttribute("cheque",percent3);
    model.addAttribute("epargne",percent4);
    return "test";
    }
}catch(Exception e) {
		  if(test3(restTemplate,test4)==true) {
			  return new ModelAndView("redirect:/test/historique?id="+test4.getAttribute("idagence") );}
		  else {
			  test4.removeAttribute("token");
			test4.removeAttribute("refresh");
			  return new ModelAndView("redirect:/logout" );
		  }
	  }
		  return new ModelAndView("redirect:/logout" );
}
@GetMapping("/credits")
public Object getcreditsbyagences(Model model,Long idagence ,HttpSession test) {
	if(test.getAttribute("id")==null||test.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
  Long vari;
  if(idagence==null) {
	  if(test.getAttribute("idagence")==null) {
		  return new ModelAndView("redirect:/logout" );
	  }
	  vari=Long.parseLong(test.getAttribute("idagence").toString());
  }else {
	  vari=idagence;
	  test.setAttribute("idagence", idagence);
  }
  HttpEntity<?> entity;
  if(    test(restTemplate,test)=="hello") {
	   return new ModelAndView("signin" );}
try {  entity= (HttpEntity<?>) test(restTemplate,test);
 ResponseEntity<credit[]> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/credit/"+vari+"/agence", //
            HttpMethod.GET, entity, credit[].class);
    HttpStatus statusCode = response.getStatusCode();
    if (statusCode == HttpStatus.OK) {   
    	model.addAttribute("credits",response.getBody());
    	return "credits";
       } }
    catch(Exception e) {
    		  if(test3(restTemplate,test)==true) {
    			  HttpEntity<?>entity2;
    			  if(    test(restTemplate,test)=="hello") {
    				   return new ModelAndView("signin" );}
    			  entity2 = (HttpEntity<?>) test(restTemplate,test);
    			  ResponseEntity<credit[]> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/credit/"+vari+"/agence", //
    			             HttpMethod.GET, entity2, credit[].class);
    			     HttpStatus statusCode2 = response2.getStatusCode();
    			     if (statusCode2 == HttpStatus.OK) {   
    			     	model.addAttribute("credits",response2.getBody());
    			     	return "credits";
    			        } 
    		  else {
    			  test.removeAttribute("token");
  				test.removeAttribute("refresh");
    			  return new ModelAndView("redirect:/logout" );
    		  }
    		  }
    	  return new ModelAndView("redirect:/logout" );
    	  }	 
return new ModelAndView("redirect:/logout" );
}
@PostMapping(value="/addagence")
public Object addagence(Model model,Agence agence ,HttpSession testo) {
	if(testo.getAttribute("id")==null||testo.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	  HttpHeaders headers = new HttpHeaders();
	  headers.setContentType(MediaType.APPLICATION_JSON);
	 if(testo.getAttribute("token").toString()==null &&testo.getAttribute("id")!=null) {
		 return new ModelAndView("signin" );
	 }
try {	  String ctre="Bearer "+testo.getAttribute("token");
	  headers.set("Autorization",ctre );
	HttpEntity<Agence> testtt= new HttpEntity<>(agence,headers);
     ResponseEntity<Agence> result 
     = restTemplate.postForEntity("https://bank-app-api.herokuapp.com/api/addagence", testtt, Agence.class);
     if (result.getStatusCode() == HttpStatus.OK) {
    	 Agence test=result.getBody();
    	 model.addAttribute("test",test);
    	 return new ModelAndView("redirect:/test/agences");}}
catch(Exception e) {
	  if(test3(restTemplate,testo)==true) {
		  try {
		  String ctre="Bearer "+testo.getAttribute("token");
		  headers.set("Autorization",ctre );
		HttpEntity<Agence> testtt= new HttpEntity<>(agence,headers);
	     ResponseEntity<Agence> result 
	     = restTemplate.postForEntity("https://bank-app-api.herokuapp.com/api/addagence", testtt, Agence.class);
		    if (result.getStatusCode() == HttpStatus.OK) {   
		    	model.addAttribute("test3",result.getBody());
			return new ModelAndView("redirect:/test/agences" );
			 }}
		    catch(Exception ex) {
				  testo.removeAttribute("token");
					testo.removeAttribute("refresh");
				  return new ModelAndView("redirect:/logout" );
			  }
		    return new ModelAndView("redirect:/test/logout" );
		  }
	  else {
		  testo.removeAttribute("token");
			testo.removeAttribute("refresh");
		  return new ModelAndView("redirect:/logout" );
	  }
	  }
return new ModelAndView("redirect:/logout" );	
}



@GetMapping("/agences")
public Object getagences(Model model,HttpSession test) {
	if(test.getAttribute("id")==null||test.getAttribute("token")==null) {
		return new ModelAndView("redirect:/test/logout" );
	}
	HttpEntity<?> entity ;
    if(    test(restTemplate,test)=="hello") {
   return new ModelAndView("signin" );}
try {
	entity=(HttpEntity<?>) test(restTemplate,test);
    ResponseEntity<?> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/api/agencies", //
            HttpMethod.GET, entity, Agence[].class);
  HttpStatus statusCode = response.getStatusCode();
    if (statusCode == HttpStatus.OK) {   
	model.addAttribute("test3",response.getBody());
return "agences";
    } }
catch(Exception e) {
		  if(test3(restTemplate,test)==true) {
HttpEntity<?> entity2;
if(    test(restTemplate,test)=="hello") {
   return new ModelAndView("signin" );}
entity2 = (HttpEntity<?>) test(restTemplate,test);
			    ResponseEntity<Agence[]> response2 = restTemplate.exchange("https://bank-app-api.herokuapp.com/api/agencies", //
			            HttpMethod.GET, entity2, Agence[].class);
			    HttpStatus statusCode2 = response2.getStatusCode();
			    if (statusCode2 == HttpStatus.OK) {   
			    	System.out.println("jcbjbcjcj");
			    	model.addAttribute("test3",response2.getBody());
				return new ModelAndView("redirect:/test/agences" );				
		  }
		  else {
			  test.removeAttribute("token");
				test.removeAttribute("refresh");
			  return new ModelAndView("redirect:/test/logout" );
		  }
		  }}
	  return new ModelAndView("redirect:/test/logout" );
}




public boolean test3(RestTemplate rest,HttpSession testy) {
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
RefreshTokenRequest test=new RefreshTokenRequest();
test.setRefreshToken(testy.getAttribute("refresh").toString());
test.setUserId(testy.getAttribute("id").toString());
ResponseEntity<String> result 
= restTemplate.postForEntity("https://bank-app-api.herokuapp.com/renewAdmin", test, String.class);
if(result.getHeaders().toString()==null)return false;
else {
	testy.setAttribute("token", result.getHeaders().get("Authorization").toString().substring(1, result.getHeaders().get("Authorization").toString().length()-1));
return true;}
}


public Object test(RestTemplate rest,HttpSession testy) {
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
if(testy.getAttribute("token")==null) {
	return "hello";
}
String ctre="Bearer "+testy.getAttribute("token");
headers.set("Autorization",ctre );
HttpEntity<?> entity = new HttpEntity<>("parameters", headers);
return entity;
}

@GetMapping(value="/logout")

public Object logout(HttpSession test ) {
	if(test.getAttribute("id")!=null) {
		
	     HttpEntity<?> entity ;
    if(    test(restTemplate,test)=="hello") {
	  return new ModelAndView("redirect:/test/authentif" );
}
try {
	entity=(HttpEntity<?>) test(restTemplate,test);
   ResponseEntity<String> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/logoutadm/"+test.getAttribute("id"), //
	            HttpMethod.GET, entity, String.class);
  HttpStatus statusCode = response.getStatusCode();
    if (statusCode == HttpStatus.OK) { 
    	  test.removeAttribute("token");
			test.removeAttribute("refresh");	
  	  return new ModelAndView("redirect:/test/authentif" );
    } }
catch(Exception e) {
		  if(test3(restTemplate,test)==true) {
entity=(HttpEntity<?>) test(restTemplate,test);
   ResponseEntity<String> response = restTemplate.exchange("https://bank-app-api.herokuapp.com/logoutadm/"+test.getAttribute("id"), //
	            HttpMethod.GET, entity, String.class);
  HttpStatus statusCode = response.getStatusCode();
    if (statusCode == HttpStatus.OK) {   
    	  test.removeAttribute("token");
			test.removeAttribute("refresh");		
			  return new ModelAndView("redirect:/test/authentif" );
    }
		  else {
			  test.removeAttribute("token");
				test.removeAttribute("refresh");
				  return new ModelAndView("redirect:/test/authentif" );
		  }
		  }}
return new ModelAndView("redirect:/test/authentif" );
	}
	  return new ModelAndView("redirect:/test/authentif" );
	
}
@GetMapping(value="/authentif")
public String getformauthentif(Model model ) {
	model.addAttribute("login", new jwtRequest());
	return "signin";
}

@PostMapping(value="/authen")
public Object veriflogin(Model model,jwtRequest login,HttpSession token ) {
	 HttpHeaders headers = new HttpHeaders();
	headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
     headers.setContentType(MediaType.APPLICATION_JSON);
     ResponseEntity<String> result 
     = restTemplate.postForEntity("https://bank-app-api.herokuapp.com/authenticateAdmin", login, String.class);
    if (Integer.parseInt(result.getBody().toString())>0) {
    	 HttpHeaders test=result.getHeaders();
    	 model.addAttribute("test",test);
token.setAttribute("token",result.getHeaders().get("Authorization").toString().substring(1,result.getHeaders().get("Authorization").toString().length()-1) );
token.setAttribute("refresh",result.getHeaders().get("RefreshToken").toString().substring(1, result.getHeaders().get("RefreshToken").toString().length()-1) );
token.setAttribute("id", Integer.parseInt(result.getBody().toString()));
return new ModelAndView("redirect:/test/agences" );
     }
     if (Integer.parseInt(result.getBody().toString())==-1) {
   	  return new ModelAndView("redirect:/test/logout" );
     }
	  return new ModelAndView("redirect:/test/logout" );
}
}
