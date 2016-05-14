package net.creepynations.particles;

import net.minecraft.server.v1_9_R1.EnumParticle;
import net.minecraft.server.v1_9_R1.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * Created by Bouz on 12-May-16.
 */
public class Particle {
    private Core plugin;

    EnumParticle particleType;
    Location loc;
    boolean longDistance;
    float x;
    float y;
    float z;
    float speed;
    int amount;

    public Particle(EnumParticle particleType, Location loc, boolean longDistance, float x, float y, float z, float speed, int amount) {
        this.particleType = particleType;
        this.loc = loc;
        this.longDistance = longDistance;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.z = z;
        this.amount = amount;
    }

    public void toPlayer(Player p) {
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
                this.particleType,
                this.longDistance,
                (float)this.loc.getX(),
                (float)this.loc.getY(),
                (float)this.loc.getZ(),
                this.x,
                this.y,
                this.z,
                this.speed,
                this.amount);

        ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
    }

    public void toAll() {
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(
                this.particleType,
                this.longDistance,
                (float)this.loc.getX(),
                (float)this.loc.getY(),
                (float)this.loc.getZ(),
                this.x,
                this.y,
                this.z,
                this.speed,
                this.amount);

        for(Player p : Bukkit.getServer().getOnlinePlayers()) {
            ((CraftPlayer) p).getHandle().playerConnection.sendPacket(packet);
        }
    }
}
