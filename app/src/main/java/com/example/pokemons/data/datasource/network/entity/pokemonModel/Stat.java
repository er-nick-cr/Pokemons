
package com.example.pokemons.data.datasource.network.entity.pokemonModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat {

    @SerializedName("base_stat")
    @Expose
    private int baseStat;
    @SerializedName("effort")
    @Expose
    private int effort;
    @SerializedName("stat")
    @Expose
    private Stat__1 stat;

    public int getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public Stat__1 getStat() {
        return stat;
    }

    public void setStat(Stat__1 stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Stat.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("baseStat");
        sb.append('=');
        sb.append(this.baseStat);
        sb.append(',');
        sb.append("effort");
        sb.append('=');
        sb.append(this.effort);
        sb.append(',');
        sb.append("stat");
        sb.append('=');
        sb.append(((this.stat == null)?"<null>":this.stat));
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
        result = ((result* 31)+ this.effort);
        result = ((result* 31)+((this.stat == null)? 0 :this.stat.hashCode()));
        result = ((result* 31)+ this.baseStat);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stat) == false) {
            return false;
        }
        Stat rhs = ((Stat) other);
        return (((this.effort == rhs.effort)&&((this.stat == rhs.stat)||((this.stat!= null)&&this.stat.equals(rhs.stat))))&&(this.baseStat == rhs.baseStat));
    }

}
