package cx;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class exec {
	
	public void CreerCompte() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir votre adresse mail : " );
		String Adressemail = sc.nextLine();
		
		System.out.println("Saisir votre prénom : " );
		String Nom = sc.nextLine();
		
		System.out.println("Saisir votre nom : " );
		String Prenom = sc.nextLine();
		
		System.out.println("Saisir votre date de naissance : " );
		String DateNaissance = sc.nextLine();
		

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
		 
        
        Statement myStmt = myConn.createStatement();

        String sql = "insert into utilisateur " + " (adressemail,nom,prenom,,datenaissance)"
                  + " values (nom,prenom,adresse,datenaissance)";
        
         myStmt.executeUpdate(sql);

          System.out.println("Insert complete.");
		
	
		
	}
	
	public void CreerPage(String adresse) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat formater = null;
		System.out.println("Saisir le nom de la page : " );
		String Nom = sc.nextLine();
		
		System.out.println("Saisir son genre : " );
		String genre = sc.nextLine();
		
		Date date = new Date();
		formater = new SimpleDateFormat("yyyy-MM-dd");
	    
	    String datecrea = formater.format(date);
		System.out.println(datecrea);

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
		 
        
        Statement myStmt = myConn.createStatement();

        String sql = "insert into page (NomP,GenreP,DateCreationP,CreateurP) values ('" + Nom + "','" + genre +"','" + datecrea +"','"+ adresse+ "');";
        
        myStmt.executeUpdate(sql);
        String sql2 ="insert into AdminP (NomP,Adresse) values ('" + Nom + "','"+ adresse+ "');";
        myStmt.executeUpdate(sql2);
        System.out.println("Insertion réussie.");
		
	
		
	}
	
	public void CreerGroupe(String adresse) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat formater = null;
		System.out.println("Saisir le nom du groupe : " );
		String Nom = sc.nextLine();
		
		System.out.println("Saisir son genre : " );
		String genre = sc.nextLine();
		
		Date date = new Date();
		formater = new SimpleDateFormat("yyyy-MM-dd");
	    String datecrea = formater.format(date);
		

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
		 
        
        Statement myStmt = myConn.createStatement();

        String sql = "insert into groupe (NomG,GenreG,DateCreationG,CreateurG) values ('" + Nom + "','" + genre +"','" + datecrea +"','"+ adresse+ "');";
        
        myStmt.executeUpdate(sql);
        String sql2 ="insert into AdminG (NomG,Adresse) values ('" + Nom + "','"+ adresse+ "');";
        myStmt.executeUpdate(sql2);

        System.out.println("Insertion réussie.");
		
	
		
	}
	
	public void PosterMsg(String adresse) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat formater = null;
		System.out.println("Saisir le message que vous voulez le publier : " );
		String contenu = sc.nextLine();
		System.out.println("Saisir l'adresse de l'utilisateur que vous voulez publier sur son mur : " );
		String ad = sc.nextLine();
		Date date1 = new Date();
		formater = new SimpleDateFormat("yyyy-MM-dd");
	    String date = formater.format(date1);

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
		 
        
        Statement myStmt = myConn.createStatement();

        String sql = "insert into mur (Auteur,Contenu,Date,AdresseDesti) values ('" + adresse + "','" + contenu +"','" +date+ "','" + ad+ "');";
        
         myStmt.executeUpdate(sql);

         System.out.println("Insertion réussie.");
		
	
		
	}
	
	public void FollowPage(String adresse) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisir le nom de la page : " );
		String Nom = sc.nextLine();

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
		 
        
        Statement myStmt = myConn.createStatement();

        String sql = "insert into MembrePage (AdresseMP,NomP) values ('"+ adresse +"','"+ Nom + "');";
        myStmt.executeUpdate(sql);
        System.out.println("Insertion réussie.");
		
	
		
	}
	
	
	public void AjouterAdmin() throws SQLException {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Si vous voulez ajouter admin à une page tapez 1 , si a un groupe tapez 2 : " );
		String choix = sc.nextLine();
		System.out.println("Saisir le nom du page ou du groupe : " );
		String Nom = sc.nextLine();
		System.out.println("Saisir l'adresse du l'admin : " );
		String adresse = sc.nextLine();
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
        Statement myStmt = myConn.createStatement();
        if (choix.equals("1")) {
        	String sql = "insert into AdminP (NomP,Adresse) values ('"+ Nom +"','"+ adresse + "');";
        	myStmt.executeUpdate(sql);
        	System.out.println("Insertion réussie.");
        }
        else {
        	String sql = "insert into AdminG (NomG,Adresse) values ('"+ Nom +"','"+ adresse + "');";
        	myStmt.executeUpdate(sql);
        	System.out.println("Insertion réussie.");
        }

        
		
	
		
	}
	
	
	
	public void RejoindreGroupe(String adresse) throws SQLException {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Saisir le nom du groupe : " );
		String Nom = sc.nextLine();

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
		 
        
        Statement myStmt = myConn.createStatement();

        String sql = "insert into MembreGroupe (AdresseMG,NomG) values ('"+ adresse +"','"+ Nom + "');";
        myStmt.executeUpdate(sql);
        System.out.println("Insertion réussie.");
		
	
		
	}
	
	
	
	
	public void EnvoyerInvitation(String adresse) {
		
		
		try {	
			
			Scanner sc = new Scanner(System.in);
			System.out.println("donner l'adresse de la personne dont vous voulez être ami(e) avec :" );
			String adresse2 = sc.nextLine();
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
			 
	        
	        Statement myStmt = myConn.createStatement();

	        String sql = "insert into ListeAttente (AdresseUtilisateur,AdresseAttente) values ('"+ adresse2 +"','"+ adresse + "');";

	         myStmt.executeUpdate(sql);

	         System.out.println("Insertion réussie.");
	      } 
		
		catch (Exception exc) {
	          exc.printStackTrace();
	      } 

}
	


	public void AccepterInvitation(String adresse) {
		
		
		try {	
			
			Scanner sc = new Scanner(System.in);
			System.out.println("donner l'adresse de la personne dont vous voulez accepter :" );
			String adresse2 = sc.nextLine();
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
			 
	        
	        Statement myStmt = myConn.createStatement();

	        String sql = "insert into ListeAmis (AdresseUtilisateur,AdresseAmis) values ('"+ adresse +"','"+ adresse2 + "');";
	         myStmt.executeUpdate(sql);
	         
	         String sql2 = "DELETE FROM ListeAttente WHERE AdresseAttente ='"+ adresse2+"';";
	         myStmt.executeUpdate(sql2);

	         System.out.println("Insertion réussie.");
	      } 
		
		catch (Exception exc) {
	          exc.printStackTrace();
	      } 

}



	public void SupprimerInvitation(String adresse) {
	
	
		try {	
		
			Scanner sc = new Scanner(System.in);
			System.out.println("donner l'adresse de la personne dont vous voulez supprimer son invitation" );
			String adresse2 = sc.nextLine();
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "root");
			 
	        
	        Statement myStmt = myConn.createStatement();
	
	        String sql = "DELETE FROM ListeAttente WHERE AdresseAttente ='"+ adresse2+"';";
	
	         myStmt.executeUpdate(sql);
	
	         System.out.println("Insertion réussie.");
	      } 
		
		catch (Exception exc) {
	          exc.printStackTrace();
	      } 

}















}
