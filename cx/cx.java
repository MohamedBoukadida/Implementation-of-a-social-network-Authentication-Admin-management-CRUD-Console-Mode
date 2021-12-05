package cx;
import java.sql.*;
import java.util.Scanner;


public class cx {

	public static void main(String[] args) throws SQLException{
		Scanner sc = new Scanner(System.in);
		String adresse ="";
		exec A = new exec();
		System.out.println("Bienvenue dans votre réseau social ! \nTapez 1 si vous voulez créer un compte , Tapez 2 si vous voulez vous connectez");
		String test = sc.nextLine();
		
		
		if (test.equals("1")) {
			
			System.out.println("Saisir votre adresse mail : " );
			adresse = sc.nextLine();
			
			System.out.println("Saisir votre prénom : " );
			String Nom = sc.nextLine();
			
			System.out.println("Saisir votre nom : " );
			String Prenom = sc.nextLine();
			
			System.out.println("Saisir votre date de naissance yyyy-MMM-dd : " );
			String Datenaissance = sc.nextLine();
			
			System.out.println("Saisir votre mot de passe " );
			String mdp = sc.nextLine();
			
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
			 
	        
	        Statement myStmt = myConn.createStatement();
	        
	 

	        String sql = "insert into utilisateur (AdresseMail,Nom,Prenom,DateNaissance,Mdp) values ('" + adresse + "','" + Nom +"','" + Prenom + "','" + Datenaissance + "','" + mdp + "');";
	        myStmt.executeUpdate(sql);

	        System.out.println("Insertion réussie.");
			
			
		}
		else {
		
			String ad ="";
	        String md = "";
			System.out.println ("donner votre adresse mail");
			adresse = sc.nextLine();
			System.out.println ("donner votre mot de passe");
			String mdp = sc.nextLine();
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
			Statement myStmt = myConn.createStatement();
			String sql = "SELECT AdresseMail,mdp FROM utilisateur where AdresseMail ='"+adresse+"' and mdp ='" +mdp+"';";
		    ResultSet res = myStmt.executeQuery(sql);
		    while(res.next()){
		    	
		          ad = res.getString("AdresseMail");
		          
		          md = res.getString("Mdp");
		          
		        
		           }
		   if ((ad.equals("")== false) && (md.equals("") == false)) {
			 System.out.println ("***** Connexion réussie ***********");
			
		}
		}
		
		
		
		
		while (true) {
			System.out.println("1 : CreerPage \n2 :CreerGroupe \n3 : FollowPage \n4 : RejoindreGroupe \n5 : AjouterAdmin \n6 : EnvoyerInvitation \n7: AccepterInvitation \n8 : SupprimerInvitation \n9 : PosterMsg \n0 : Quitter ");
			String choix = sc.nextLine();
			
			if (choix == "1") {
				A.AccepterInvitation(adresse);
			} else if (choix.equals("1")) {
				A.CreerPage(adresse);
			} else if (choix.equals("2")) {
				A.CreerGroupe(adresse);
			} else if (choix.equals("3")) {
				A.FollowPage(adresse);
			} else if (choix.equals("4")) {
				A.RejoindreGroupe(adresse);
			} else if (choix.equals("5")) {
				A.AjouterAdmin();
			} else if (choix.equals("6")) {
				A.EnvoyerInvitation(adresse);
			} else if (choix.equals("7")) {
				A.AccepterInvitation(adresse);
			} else if (choix.equals("8")) {
				A.SupprimerInvitation(adresse);
			} else if (choix.equals("9")) {
				A.PosterMsg(adresse);	
			} else if (choix.equals("0")) {
				break;
			}
		}
		
	
	}}
	

	
		
		
		
		
		
		
