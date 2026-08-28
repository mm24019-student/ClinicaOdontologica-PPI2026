package sv.ues.edu.occ.ingenieria.pp115_2026.salud.galeanosv.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.UUID;

/**
 * @author oscar
 */
@Converter(autoApply = true)
public class UUIDConverter implements AttributeConverter<UUID, UUID> {
    @Override
    public UUID convertToDatabaseColumn(UUID uuid) {
        return uuid;
    }
    @Override
    public UUID convertToEntityAttribute(UUID db) {
        return db;
    }
}