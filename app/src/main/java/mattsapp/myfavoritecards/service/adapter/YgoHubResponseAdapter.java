package mattsapp.myfavoritecards.service.adapter;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * Created by Matt on 1/20/2018.
 */

public class YgoHubResponseAdapter extends JsonAdapter<Object> {
    public static final JsonAdapter.Factory FACTORY = new Factory() {
        @Override public
        JsonAdapter<?> create(
                Type type, Set<? extends Annotation> annotations, Moshi moshi) {
            Set<? extends Annotation> delegateAnnotations =
                    Types.nextAnnotations(annotations, Enveloped.class);
            if (delegateAnnotations == null) {
                return null;
            }
            Type envelope =
                    Types.newParameterizedTypeWithOwner(YgoHubResponseAdapter.class, YgoHubResponse.class, type);
            JsonAdapter<YgoHubResponse<?>> delegate = moshi.nextAdapter(this, envelope, delegateAnnotations);
            return new YgoHubResponseAdapter(delegate);
        }
    };

    @Retention(RetentionPolicy.RUNTIME) @JsonQualifier
    public @interface Enveloped {
    }

    public static final class YgoHubResponse<T> {
        public final T data ;//variable name matches json name

        YgoHubResponse(T data) {
            this.data = data;
        }
    }

    private final JsonAdapter<YgoHubResponse<?>> delegate;

    YgoHubResponseAdapter(JsonAdapter<YgoHubResponse<?>> delegate) {
        this.delegate = delegate;
    }

    @Override public Object fromJson(JsonReader reader) throws IOException {
        return delegate.fromJson(reader).data;
    }

    @Override public void toJson(JsonWriter writer, Object value) throws IOException {
        delegate.toJson(writer, new YgoHubResponse<>(value));
    }
}
