package fr.dawan.formation.entity;

import fr.dawan.formation.entity.date.Date;

public class Contact
{
    private int id;
    private String prenom, nom, adresseMail;
    private Date date;

    public Contact()
    {

    }

    public Contact(String prenom, String nom, String adresseMail, Date date)
    {
        this.date = date;
        this.adresseMail = adresseMail;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Contact(int id, String prenom, String nom, String adresseMail, Date date)
    {
        this.id = id;
        this.date = date;
        this.adresseMail = adresseMail;
        this.nom = nom;
        this.prenom = prenom;
    }

    //region getters/setters
    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public Date getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    //endregion

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", prénom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", adresseMail='" + adresseMail + '\'' +
                ", date=" + date +
                '}';
    }
}
