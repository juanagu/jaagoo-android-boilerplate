package co.jagu.presentation.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * Class that represent a person in the app layer
 */
@AutoValue
public abstract class PersonModel implements Parcelable {

    /*--
    Fields
    -- */
    abstract String firstName();

    abstract String lastName();

    @Nullable
    abstract String avatar();

    /*--
    Builder
    --*/

    static Builder builder() {
        return new $AutoValue_PersonModel.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder setFirstName(String firstName);

        abstract Builder setLastName(String lastName);

        abstract Builder setAvatar(String avatar);

        abstract PersonModel build();
    }


}
