package com.dfsek.terraia;

import com.dfsek.terra.api.TerraPlugin;
import com.dfsek.terra.api.addons.TerraAddon;
import com.dfsek.terra.api.addons.annotations.Addon;
import com.dfsek.terra.api.addons.annotations.Version;
import com.dfsek.terra.api.addons.annotations.Author;
import com.dfsek.terra.api.event.EventListener;
import com.dfsek.terra.api.event.events.config.ConfigPackPreLoadEvent;
import com.dfsek.terra.api.injection.annotations.Inject;
import com.dfsek.terra.registry.exception.DuplicateEntryException;

import java.util.logging.Logger;

@SuppressWarnings("unused")
@Addon("ItemsAdder")
@Version("0.1.0")
@Author("dfsek, EVERYPLANET")
public class TerraItemsAdderAddon extends TerraAddon implements EventListener {
    @Inject
    private TerraPlugin main;

    @Inject
    private Logger logger;

    public void onPackLoad(ConfigPackPreLoadEvent event) {
        try {
            event.getPack().getFunctionRegistry().add("itemsAdderBlock", new ItemsAdderFunctionBuilder());
        } catch(DuplicateEntryException e) {
            e.printStackTrace();
            logger.severe("Failed to inject ItemsAdder function!");
            return;
        }
        logger.info("Injected ItemsAdder function!");
    }

    @Override
    public void initialize() {
        logger.info("Registering events...");
        main.getEventManager().registerListener(this, this);
        logger.info("Done.");
    }
}
