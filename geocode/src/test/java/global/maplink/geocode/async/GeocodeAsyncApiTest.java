package global.maplink.geocode.async;

import global.maplink.MapLinkSDK;
import global.maplink.credentials.MapLinkCredentials;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static global.maplink.geocode.common.Defaults.DEFAULT_CLIENT_ID;
import static global.maplink.geocode.common.Defaults.DEFAULT_SECRET;
import static org.assertj.core.api.Assertions.assertThat;

public class GeocodeAsyncApiTest {

    @BeforeEach
    public void initializeSDK() {
        MapLinkSDK
                .configure()
                .with(MapLinkCredentials.ofKey(DEFAULT_CLIENT_ID, DEFAULT_SECRET))
                .initialize();
    }

    @AfterEach
    public void cleanupSDK() {
        MapLinkSDK.resetConfiguration();
    }

    @Test
    public void mustBeInstantiableWithGetInstance() {
        GeocodeAsyncAPI instance = GeocodeAsyncAPI.getInstance();
        assertThat(instance).isNotNull();
    }
}