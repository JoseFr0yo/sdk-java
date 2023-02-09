package global.maplink.trip.testUtils;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@RequiredArgsConstructor
public enum ProblemSampleFiles {
    CROSSED_BORDERS_REQUEST("trip/v2/problem/json/crossedBordersRequest.json"),
    SITE_POINT("trip/v2/problem/json/sitePoint.json"),
    TOLL_REQUEST("trip/v2/problem/json/tollRequest.json"),
    TRIP_REQUEST("trip/v2/problem/json/tripRequest.json"),
    VEHICLE_SPECIFICATION("trip/v2/v2problem/json/validVehicleSpecification.json");

    private final String filePath;

    public byte[] load(){
        URL resource = ProblemSampleFiles.class.getClassLoader().getResource(filePath);
        try {
            assert resource != null;
            return Files.readAllBytes(Paths.get(resource.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
