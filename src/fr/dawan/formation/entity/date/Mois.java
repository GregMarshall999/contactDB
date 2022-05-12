package fr.dawan.formation.entity.date;

public enum Mois
{
    JANVIER("01"),
    FEVRIER("02"),
    MARS("03"),
    AVRIL("04"),
    MAI("05"),
    JUIN("06"),
    JUILLET("07"),
    AOUT("08"),
    SEPTEMBRE("09"),
    OCTOBRE("10"),
    NOVEMBRE("11"),
    DECEMBRE("12");

    private final String mois;

    Mois(String mois)
    {
        this.mois = mois;
    }

    public String getMois()
    {
        return mois;
    }
}
