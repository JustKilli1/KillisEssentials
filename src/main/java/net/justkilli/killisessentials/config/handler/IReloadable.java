package net.justkilli.killisessentials.config.handler;

/**
 * Defines the behavior of a reloadable component.
 */
public interface IReloadable {

    /**
     * Reloads the resource.
     *
     * @return true if the resource is successfully reloaded, false otherwise.
     */
    boolean reload();

}
