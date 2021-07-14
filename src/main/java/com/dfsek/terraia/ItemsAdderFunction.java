package com.dfsek.terramm;

import com.dfsek.terra.api.structures.parser.lang.ImplementationArguments;
import com.dfsek.terra.api.structures.parser.lang.Returnable;
import com.dfsek.terra.api.structures.parser.lang.functions.Function;
import com.dfsek.terra.api.structures.parser.lang.variables.Variable;
import com.dfsek.terra.api.structures.script.TerraImplementationArguments;
import com.dfsek.terra.api.structures.tokenizer.Position;
import com.dfsek.terra.bukkit.world.BukkitAdapter;
import dev.lone.itemsadder.api.CustomBlock;
import org.bukkit.Location;

import java.util.Map;

public class ItemsAdderFunction implements Function<Void> {
    private final Position position;
    private final Returnable<Number> x, y, z;
    private final Returnable<String> block;

    public ItemsAdderFunction(Position position, Returnable<Number> x, Returnable<Number> y, Returnable<Number> z, Returnable<String> block) {
        this.position = position;
        this.x = x;
        this.y = y;
        this.z = z;
        this.block = block;
    }

    @Override
    public ReturnType returnType() {
        return ReturnType.VOID;
    }

    @Override
    public Void apply(ImplementationArguments implementationArguments, Map<String, Variable<?>> map) {
        Location location = BukkitAdapter.adapt(((TerraImplementationArguments) implementationArguments).getBuffer().getOrigin());
        location.add(x.apply(implementationArguments, map).doubleValue(), y.apply(implementationArguments, map).doubleValue(), z.apply(implementationArguments, map).doubleValue());
        CustomBlock customBlock = CustomBlock.getInstance(block.apply(implementationArguments, map));
        if(customBlock != null) //not needed if you're sure the blocks exists.
        {
            //custom block
            customBlock.place(location);
        }
        return null;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
