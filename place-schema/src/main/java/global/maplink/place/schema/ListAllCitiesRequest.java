package global.maplink.place.schema;

import global.maplink.MapLinkServiceRequest;
import global.maplink.env.Environment;
import global.maplink.http.Response;
import global.maplink.http.request.Request;
import global.maplink.json.JsonMapper;
import global.maplink.validations.ValidationViolation;
import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static global.maplink.http.request.Request.get;
import static global.maplink.place.schema.exception.PlaceErrorType.REQUIRED_FIELD_STATE_INVALID;
import static java.util.Objects.isNull;

@EqualsAndHashCode
@ToString
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class ListAllCitiesRequest implements MapLinkServiceRequest<List<String>> {

    public static final String PATH = "place/v1/places/state/%s/cities";
    private final String state;

    @Override
    public Request asHttpRequest(Environment environment, JsonMapper mapper) {
        var path = String.format(PATH, state);
        return get(environment.withService(path));
    }

    @Override
    public Function<Response, List<String>> getResponseParser(JsonMapper mapper) {
        return r -> r.parseBodyArray(mapper, String.class);
    }

    @Override
    public List<ValidationViolation> validate() {
        List<ValidationViolation> violations = new LinkedList<>();
        if (isNull(state)) {
            violations.add(REQUIRED_FIELD_STATE_INVALID);
        }
        return violations;
    }
}
