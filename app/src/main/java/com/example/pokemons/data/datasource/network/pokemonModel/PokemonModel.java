
package com.example.pokemons.data.datasource.network.pokemonModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonModel {

    @SerializedName("forms")
    @Expose
    private List<Form> forms = null;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = null;

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PokemonModel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("forms");
        sb.append('=');
        sb.append(((this.forms == null)?"<null>":this.forms));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("stats");
        sb.append('=');
        sb.append(((this.stats == null)?"<null>":this.stats));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+ this.id);
        result = ((result* 31)+((this.stats == null)? 0 :this.stats.hashCode()));
        result = ((result* 31)+((this.forms == null)? 0 :this.forms.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PokemonModel) == false) {
            return false;
        }
        PokemonModel rhs = ((PokemonModel) other);
        return (((this.id == rhs.id)&&((this.stats == rhs.stats)||((this.stats!= null)&&this.stats.equals(rhs.stats))))&&((this.forms == rhs.forms)||((this.forms!= null)&&this.forms.equals(rhs.forms))));
    }

}
