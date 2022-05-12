package fr.dawan.formation.entity.date;

public class Date
{
    private int jours;
    private Mois mois;
    private int annee;

    public Date()
    {

    }

    public Date(int jours, Mois mois, int annee)
    {
        this.annee = annee;
        this.jours = jours;
        this.mois = mois;
    }

    //region getters/setters
    public int getJours() {
        return jours;
    }

    public Mois getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setJours(int jours) {
        this.jours = jours;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
    //endregion

    @Override
    public String toString()
    {
        try {
            String j = "";
            switch (jours) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    j += "0" + jours;
                    break;
                default:
                    j += jours;
            }
            return j + "-" + mois.getMois() + "-" + annee;
        } catch (NullPointerException e)
        {
            return "";
        }
    }

    public void fromString(String date)
    {
        String[] values = date.split("-");
        jours = Integer.parseInt(values[0]);
        switch (values[1])
        {
            case "01":
                mois = Mois.JANVIER;
                break;
            case "02":
                mois = Mois.FEVRIER;
                break;
            case "03":
                mois = Mois.MARS;
                break;
            case "04":
                mois = Mois.AVRIL;
                break;
            case "05":
                mois = Mois.MAI;
                break;
            case "06":
                mois = Mois.JUIN;
                break;
            case "07":
                mois = Mois.JUILLET;
                break;
            case "08":
                mois = Mois.AOUT;
                break;
            case "09":
                mois = Mois.SEPTEMBRE;
                break;
            case "10":
                mois = Mois.OCTOBRE;
                break;
            case "11":
                mois = Mois.NOVEMBRE;
                break;
            case "12":
                mois = Mois.DECEMBRE;
                break;
        }
        annee = Integer.parseInt(values[2]);
    }
}
