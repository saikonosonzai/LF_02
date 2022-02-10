public class KeineKraftException extends Exception {


        private String aktion;
        private String name;
        public KeineKraftException(String name, String aktion) {
            this.aktion = aktion;
            this.name = name;
        }

    public String getName() {
        return name;
    }

    public String getAktion() {
        return aktion;
    }

    @Override
        public String getMessage(){
            return getName() + " hat nicht genug Stärkepunkte mehr für die Aktion: "+ getAktion();
        }


    }

