package modules;

    public class Client {

        String nume;
        String email;
        String adresa;

        public Client() {
        }

        public Client(String nume, String email, String adresa) {
            this.nume = nume;
            this.email = email;
            this.adresa = adresa;
        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAdresa() {
            return adresa;
        }

        public void setAdresa(String adresa) {
            this.adresa = adresa;
        }

        public void afiseazaDetaliiClient() {
            System.out.println("Client cu numele " + nume + " cu adresa de email " + email + " care locuieste pe adresa " + adresa);
        }

    }
