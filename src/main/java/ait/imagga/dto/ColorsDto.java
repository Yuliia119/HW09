package ait.imagga.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class ColorsDto {
    @JsonProperty("image_colors")
    private List<ColorsInfoDto> imageColors;
    @JsonProperty("background_colors")
    private List<ColorsInfoDto> backgroundColors;
    @JsonProperty("foreground_colors")
    private List<ColorsInfoDto> foregroundColors;

}


