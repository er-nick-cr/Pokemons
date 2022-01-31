
package com.example.pokemons.data.datasource.network.pokemonPhoto;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonPhoto {

    @SerializedName("form_name")
    @Expose
    private String formName;
    @SerializedName("form_names")
    @Expose
    private List<Object> formNames = null;
    @SerializedName("form_order")
    @Expose
    private int formOrder;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("is_battle_only")
    @Expose
    private boolean isBattleOnly;
    @SerializedName("is_default")
    @Expose
    private boolean isDefault;
    @SerializedName("is_mega")
    @Expose
    private boolean isMega;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("names")
    @Expose
    private List<Object> names = null;
    @SerializedName("order")
    @Expose
    private int order;
    @SerializedName("pokemon")
    @Expose
    private Pokemon pokemon;
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("types")
    @Expose
    private List<Type> types = null;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<Object> getFormNames() {
        return formNames;
    }

    public void setFormNames(List<Object> formNames) {
        this.formNames = formNames;
    }

    public int getFormOrder() {
        return formOrder;
    }

    public void setFormOrder(int formOrder) {
        this.formOrder = formOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsBattleOnly() {
        return isBattleOnly;
    }

    public void setIsBattleOnly(boolean isBattleOnly) {
        this.isBattleOnly = isBattleOnly;
    }

    public boolean isIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean isIsMega() {
        return isMega;
    }

    public void setIsMega(boolean isMega) {
        this.isMega = isMega;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getNames() {
        return names;
    }

    public void setNames(List<Object> names) {
        this.names = names;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PokemonPhoto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("formName");
        sb.append('=');
        sb.append(((this.formName == null)?"<null>":this.formName));
        sb.append(',');
        sb.append("formNames");
        sb.append('=');
        sb.append(((this.formNames == null)?"<null>":this.formNames));
        sb.append(',');
        sb.append("formOrder");
        sb.append('=');
        sb.append(this.formOrder);
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(this.id);
        sb.append(',');
        sb.append("isBattleOnly");
        sb.append('=');
        sb.append(this.isBattleOnly);
        sb.append(',');
        sb.append("isDefault");
        sb.append('=');
        sb.append(this.isDefault);
        sb.append(',');
        sb.append("isMega");
        sb.append('=');
        sb.append(this.isMega);
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("names");
        sb.append('=');
        sb.append(((this.names == null)?"<null>":this.names));
        sb.append(',');
        sb.append("order");
        sb.append('=');
        sb.append(this.order);
        sb.append(',');
        sb.append("pokemon");
        sb.append('=');
        sb.append(((this.pokemon == null)?"<null>":this.pokemon));
        sb.append(',');
        sb.append("sprites");
        sb.append('=');
        sb.append(((this.sprites == null)?"<null>":this.sprites));
        sb.append(',');
        sb.append("types");
        sb.append('=');
        sb.append(((this.types == null)?"<null>":this.types));
        sb.append(',');
        sb.append("versionGroup");
        sb.append('=');
        sb.append(((this.versionGroup == null)?"<null>":this.versionGroup));
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
        result = ((result* 31)+((this.formNames == null)? 0 :this.formNames.hashCode()));
        result = ((result* 31)+((this.types == null)? 0 :this.types.hashCode()));
        result = ((result* 31)+((this.pokemon == null)? 0 :this.pokemon.hashCode()));
        result = ((result* 31)+((this.sprites == null)? 0 :this.sprites.hashCode()));
        result = ((result* 31)+ this.formOrder);
        result = ((result* 31)+(this.isDefault? 1 : 0));
        result = ((result* 31)+((this.names == null)? 0 :this.names.hashCode()));
        result = ((result* 31)+((this.versionGroup == null)? 0 :this.versionGroup.hashCode()));
        result = ((result* 31)+((this.formName == null)? 0 :this.formName.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+(this.isMega? 1 : 0));
        result = ((result* 31)+ this.id);
        result = ((result* 31)+(this.isBattleOnly? 1 : 0));
        result = ((result* 31)+ this.order);
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PokemonPhoto) == false) {
            return false;
        }
        PokemonPhoto rhs = ((PokemonPhoto) other);
        return (((((((((((((((this.formNames == rhs.formNames)||((this.formNames!= null)&&this.formNames.equals(rhs.formNames)))&&((this.types == rhs.types)||((this.types!= null)&&this.types.equals(rhs.types))))&&((this.pokemon == rhs.pokemon)||((this.pokemon!= null)&&this.pokemon.equals(rhs.pokemon))))&&((this.sprites == rhs.sprites)||((this.sprites!= null)&&this.sprites.equals(rhs.sprites))))&&(this.formOrder == rhs.formOrder))&&(this.isDefault == rhs.isDefault))&&((this.names == rhs.names)||((this.names!= null)&&this.names.equals(rhs.names))))&&((this.versionGroup == rhs.versionGroup)||((this.versionGroup!= null)&&this.versionGroup.equals(rhs.versionGroup))))&&((this.formName == rhs.formName)||((this.formName!= null)&&this.formName.equals(rhs.formName))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&(this.isMega == rhs.isMega))&&(this.id == rhs.id))&&(this.isBattleOnly == rhs.isBattleOnly))&&(this.order == rhs.order));
    }

}
