package org.labs.Tasks.Task17;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        List<String> errors = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);

            if (field.isAnnotationPresent(NotNull.class)) {
                if (value == null) {
                    errors.add("Поле " + field.getName() + " не должно быть null.");
                }
            }

            if (field.isAnnotationPresent(MaxLength.class)) {
                if (value != null && value instanceof String) {
                    int maxLength = field.getAnnotation(MaxLength.class).value();
                    String str = (String) value;
                    if (str.length() > maxLength) {
                        errors.add("Поле " + field.getName() + " превышает максимальную длину " + maxLength + ".");
                    }
                }
            }

            if (field.isAnnotationPresent(Min.class)) {
                if (value instanceof Integer) {
                    int minValue = field.getAnnotation(Min.class).value();
                    int intValue = (Integer) value;
                    if (intValue < minValue) {
                        errors.add("Поле " + field.getName() + " должно быть не меньше " + minValue + ".");
                    }
                }
            }

            if (field.isAnnotationPresent(Range.class)) {
                if (value instanceof Integer) {
                    Range range = field.getAnnotation(Range.class);
                    int min = range.min();
                    int max = range.max();
                    int intValue = (Integer) value;
                    if (intValue < min || intValue > max) {
                        errors.add("Поле " + field.getName() + " должно быть в диапазоне от " + min + " до " + max + ".");
                    }
                }
            }
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(String.join("\n", errors));
        }
    }
}
