package fr.dawan.formation.dao;

import fr.dawan.formation.entity.Contact;
import fr.dawan.formation.entity.date.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO
{
    /**
     * Connects to the db_contact database then adds a new contact to the contact table
     * @param contact - Contact to add
     * @throws SQLException - Connection exception returned
     */
    public static void addContact(Contact contact) throws SQLException
    {
        String sql = "INSERT INTO contact(prenom, nom, adresseMail, dateNaiss) VALUES(?, ?, ?, ?)";
        PreparedStatement ps = ConnectionBDD.getConnection().prepareStatement(sql);
        ps.setString(1, contact.getPrenom());
        ps.setString(2, contact.getNom());
        ps.setString(3, contact.getAdresseMail());
        ps.setString(4, contact.getDate().toString());
        ps.executeUpdate();
        ps.close();
    }

    /**
     * Connects to the db_contact database then fetches the existing contact or null
     * @param contact - Contact to fetch
     * @return c - contact found
     * @throws SQLException - Connection exception returned
     */
    public static Contact getContact(Contact contact) throws SQLException
    {
        Contact c;
        Date d = new Date();
        String sql = "SELECT * FROM contact WHERE id=?";
        PreparedStatement ps = ConnectionBDD.getConnection().prepareStatement(sql);
        ps.setInt(1, contact.getId());
        ResultSet rs = ps.executeQuery();

        if(rs.next())
        {
            d.fromString(rs.getString("dateNaiss"));
            c = new Contact(rs.getInt("id"),
                            rs.getString("prenom"),
                            rs.getString("nom"),
                            rs.getString("adresseMail"),
                            d);
            ps.close();
            rs.close();
            return c;
        } else
        {
            ps.close();
            rs.close();
            System.out.println("Contact innexistant");
            return null;
        }
    }

    /**
     * Connects to the db_contact database and fetches contacts born the same day
     * @param date - birthday of contacts to find
     * @return lc - contact lists found with same birthday
     * @throws SQLException - Connection exception returned
     */
    public static List<Contact> getSharedBirthdayContact(Date date) throws SQLException
    {
        Contact c;
        List<Contact> lc = new ArrayList<>();
        String sql = "SELECT * FROM contact WHERE dateNaiss=?";
        PreparedStatement ps = ConnectionBDD.getConnection().prepareStatement(sql);
        ps.setString(1, date.toString());
        ResultSet rs = ps.executeQuery();

        while (rs.next())
        {
            c = new Contact(rs.getInt("id"),
                            rs.getString("prenom"),
                            rs.getString("nom"),
                            rs.getString("adresseMail"),
                            date);
            lc.add(c);
        }
        return lc;
    }

    /**
     * Connects to the db_contact database and deletes the contact from its id
     * @param contact - contact we wish to delete
     * @throws SQLException - Connection exception returned
     */
    public static void deleteContact(Contact contact) throws SQLException
    {
        String sql = "DELETE FROM contact WHERE id=?";
        PreparedStatement ps = ConnectionBDD.getConnection().prepareStatement(sql);
        ps.setInt(1, contact.getId());
        ps.executeUpdate();
        ps.close();
    }

    /**
     * Connects to the db_contact database and updates the contact from its id
     * @param contact - contact we wish to update
     * @throws SQLException - Connection exception returned
     */
    public static void updateContact(Contact contact) throws SQLException
    {
        String sql = "UPDATE contact SET prenom=?, nom=?, adresseMail=?, dateNaiss=? WHERE id=?";
        PreparedStatement ps = ConnectionBDD.getConnection().prepareStatement(sql);
        ps.setString(1, contact.getPrenom());
        ps.setString(2, contact.getNom());
        ps.setString(3, contact.getAdresseMail());
        ps.setString(4, contact.getDate().toString());
        ps.setInt(5, contact.getId());
        ps.executeUpdate();
        ps.close();
    }
}
