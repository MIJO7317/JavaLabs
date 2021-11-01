package JavaLabs.AccountantBot;

import JavaLabs.Containers.ArrayList;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Government {

    public static class State {

        private State(String name, String stateCode) {
            this.name = name;
            this.stateCode = stateCode;
            this.cities = new ArrayList<>();
        }

        public ArrayList<City> getCities() {
            return this.cities;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStateCode() {
            return this.stateCode;
        }

        public void setStateCode(String stateCode) {
            this.stateCode = stateCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof State)) return false;
            State state = (State) o;
            return Objects.equals(getCities(), state.getCities())
                    && Objects.equals(getName(), state.getName())
                    && Objects.equals(getStateCode(), state.getStateCode());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCities(), getName(), getStateCode());
        }

        @Override
        public String toString() {
            return "State{" +
                    "name='" + name + '\'' +
                    ", stateCode='" + stateCode + '\'' +
                    //", cities=" + cities +
                    '}';
        }

        private ArrayList<City> cities;
        private String name;
        private String stateCode;
    }

    public static class City {

        private City(String name, State state) {
            this.name = name;
            this.state = state;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public State getState() {
            return this.state;
        }

        public void setState(State state) {
            this.state = state;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof City)) return false;
            City city = (City) o;
            return Objects.equals(this.getName(), city.getName())
                    && Objects.equals(this.getState(), city.getState());
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.getName(), this.getState());
        }

        @Override
        public String toString() {
            return "City{" +
                    "name=" + name + '\'' +
                    ", state=" + state +
                    '}';
        }

        private String name;
        private State state;
    }

    public static City getCity(String city) {
        for (int i = 0; i < Government.cities.size(); i++) {
            City newCity = Government.cities.get(i);
            if (Objects.equals(newCity.getName(), city)) {
                return newCity;
            }
        }
        return null;
    }

    public static State getState(String state) {
        for (int i = 0; i < Government.states.size(); i++) {
            State newState = Government.states.get(i);
            if (Objects.equals(newState.getName(), state)) {
                  return newState;
            }
        }
        return null;
    }

    public static void addCity(String city, State state) {
        if (Government.cities == null) {
            Government.cities = new ArrayList<>();
        }
        for (int i = 0; i < Government.cities.size(); i++) {
            City currentCity = Government.cities.get(i);
            if (Objects.equals(currentCity.name, city)) {
                if (!Objects.equals(currentCity.getState().getName(), state.getName())) {
                    currentCity.getState().cities.remove(currentCity);
                    state.cities.add(currentCity);
                    currentCity.setState(state);
                    return;
                }
            }
        }
        City newCity = new City(city, state);
        state.cities.add(newCity);
    }

    public static void addState(String state, String stateCode) {
        if (Government.states == null) {
            Government.states = new ArrayList<>();
        }
        for (int i = 0; i < Government.states.size(); i++) {
            State currentState = Government.states.get(i);
            if (Objects.equals(currentState.name, state)) {
                if (!Objects.equals(currentState.getStateCode(), stateCode)) {
                    currentState.setStateCode(stateCode);
                    return;
                }
            }
        }
        State newState = new State(state, stateCode);
        Government.states.add(newState);
    }

    //public static boolean deleteCity(String city);

    //public static boolean deleteState(String state);

    private static ArrayList<City> cities;
    public static ArrayList<State> states;
}
