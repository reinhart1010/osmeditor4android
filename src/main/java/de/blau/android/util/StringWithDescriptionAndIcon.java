package de.blau.android.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import de.blau.android.presets.PresetElement;
import de.blau.android.presets.PresetItem;

public class StringWithDescriptionAndIcon extends ExtendedStringWithDescription {
    private static final long serialVersionUID = 2L;

    private transient Drawable icon;
    private final String       iconPath;
    private final String       imagePath;

    /**
     * Construct a new instance
     * 
     * @param value the value
     * @param description the description of the value
     * @param iconPath the path of the associated icon
     */
    public StringWithDescriptionAndIcon(@NonNull final String value, @Nullable final String description, @Nullable final String iconPath) {
        super(value, description);
        this.iconPath = iconPath;
        this.imagePath = null;
    }

    /**
     * Construct a new instance
     * 
     * @param value the value
     * @param description the description of the value
     * @param iconPath the path of the associated icon
     * @param imagePath the path of a larger image
     */
    public StringWithDescriptionAndIcon(@NonNull final String value, @Nullable final String description, @NonNull final String iconPath,
            @Nullable final String imagePath) {
        super(value, description);
        this.iconPath = iconPath;
        this.imagePath = imagePath;
    }

    /**
     * Construct a new instance from object of a known type
     * 
     * @param object one of StringWithDescriptionAndIcon, StringWithDescription, ValueWithCount or String
     */
    public StringWithDescriptionAndIcon(@NonNull final Object object) {
        super(object);
        if (object instanceof StringWithDescriptionAndIcon) {
            this.iconPath = ((StringWithDescriptionAndIcon) object).iconPath;
            this.icon = ((StringWithDescriptionAndIcon) object).icon;
            this.imagePath = ((StringWithDescriptionAndIcon) object).imagePath;
        } else {
            iconPath = null;
            imagePath = null;
        }
    }

    /**
     * Get the Icon
     * 
     * @param context an Android Context
     * @param preset the current PresetItem
     * @return a Drawable with the icon
     */
    @Nullable
    public Drawable getIcon(@NonNull Context context, @NonNull PresetItem preset) {
        if (icon == null) {
            icon = preset.getIconIfExists(context, iconPath);
            if (icon != null) {
                Bitmap bitmap = Util.drawableToBitmap(icon);
                int size = Density.dpToPx(context, PresetElement.ICON_SIZE_DP);
                icon = new BitmapDrawable(context.getResources(), Bitmap.createScaledBitmap(bitmap, size, size, true));
            }
        }
        return icon;
    }

    /**
     * Check if this has an icon
     * 
     * @return true if at least potentially an icon is available
     */
    public boolean hasIcon() {
        return iconPath != null;
    }

    /**
     * Get the path of a larger image
     * 
     * @return the path or null
     */
    @Nullable
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Check if this has an image
     * 
     * @return true if at least potentially an image is available
     */
    public boolean hasImagePath() {
        return imagePath != null;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((iconPath == null) ? 0 : iconPath.hashCode());
        result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof StringWithDescriptionAndIcon)) {
            return false;
        }
        StringWithDescriptionAndIcon other = (StringWithDescriptionAndIcon) obj;
        if (iconPath == null) {
            if (other.iconPath != null) {
                return false;
            }
        } else if (!iconPath.equals(other.iconPath)) {
            return false;
        }
        if (imagePath == null) {
            if (other.imagePath != null) {
                return false;
            }
        } else if (!imagePath.equals(other.imagePath)) {
            return false;
        }
        return true;
    }

}
