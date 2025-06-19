package ait.imagga;

import ait.imagga.dto.ColorsInfoDto;
import ait.imagga.dto.ColorsResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

public class ImaggaColorsAppl {
    public static void main(String[] args) {
        String imgUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "token");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imgUrl);

        URI url = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, url);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ColorsResponseDto> response = restTemplate.exchange(request, ColorsResponseDto.class);

        System.out.println("\nIMAGE COLORS:");
        printColors(response.getBody().getResult().getColors().getImageColors());
        System.out.println("\nBACKGROUND COLORS:");
        printColors(response.getBody().getResult().getColors().getBackgroundColors());
        System.out.println("\nFOREGROUND COLORS:");
        printColors(response.getBody().getResult().getColors().getForegroundColors());
    }

    private static void printColors(List<ColorsInfoDto> colors) {
        if (colors == null || colors.isEmpty()) {
            System.out.println("\nNO COLORS");
            return;
        }

        System.out.printf("%-25s %-25s %-20s\n", "color name", "parent color name", "coverage percent");

        for (ColorsInfoDto color : colors) {
            System.out.printf("%-25s %-25s %-20.2f\n",
                    color.getClosestPaletteColor(),
                    color.getClosestPaletteColorParent(),
                    color.getPercent());
        }
    }
}
