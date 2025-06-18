package ait.imagga.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ColorsInfoDto {
    @JsonProperty("closest_palette_color")
    private String closestPaletteColor;
    @JsonProperty("closest_palette_color_parent")
    private String closestPaletteColorParent;
    @JsonProperty("percent")
    private double percent;
}
