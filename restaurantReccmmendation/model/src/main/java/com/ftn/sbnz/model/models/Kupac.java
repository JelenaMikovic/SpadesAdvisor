class Kupac {
    String ime;
    List<Telefon> kupljeniTelefoni;

    public Kupac(String ime) {
        this.ime = ime;
        this.kupljeniTelefoni = new ArrayList<>();
    }

    public void kupiTelefon(Telefon telefon) {
        kupljeniTelefoni.add(telefon);
    }

    public List<Telefon> getKupljeniTelefoni() {
        return kupljeniTelefoni;
    }
}