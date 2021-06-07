package bounce.common.entity;

import bounce.common.Registry;
import bounce.common.entity.PogoEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class EntityTypes {
    public static EntityType<PogoEntity> POGO_ENTITY = EntityType.Builder.<PogoEntity>of(PogoEntity::new, EntityClassification.MISC).build("pogo_stick");
}