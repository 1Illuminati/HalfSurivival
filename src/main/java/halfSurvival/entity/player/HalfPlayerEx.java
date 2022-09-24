package halfSurvival.entity.player;

import doublePlugin.entity.player.NewOfflinePlayer;
import doublePlugin.entity.player.NewPlayer;
import doublePlugin.entity.player.PlayerInfoMaps;
import doublePlugin.util.CoolTime;
import doublePlugin.util.map.InfoMaps;
import doublePlugin.util.map.NotNullStrMap;
import doublePlugin.util.scoreBoard.ScoreBoardHelper;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.Sign;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.profile.PlayerProfile;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.*;

public class HalfPlayerEx {
    NewPlayer newPlayer;

    public HalfPlayerEx(NewPlayer newPlayer) {
        this.newPlayer = newPlayer;
    }

    public boolean checkPlayerNpc() {
        return newPlayer.checkPlayerNpc();
    }

    public NewOfflinePlayer getNewOfflinePlayer() {
        return newPlayer.getNewOfflinePlayer();
    }

    public ScoreBoardHelper getScoreBoardHelper() {
        return newPlayer.getScoreBoardHelper();
    }

    public void setScoreBoardHelper(ScoreBoardHelper scoreBoardHelper) {
        newPlayer.setScoreBoardHelper(scoreBoardHelper);
    }

    public void putRunnable(String code, Runnable run) {
        newPlayer.putRunnable(code, run);
    }

    public Runnable getRunnable(String code) {
        return newPlayer.getRunnable(code);
    }

    public void removeNewPlayer() {
        newPlayer.removeNewPlayer();
    }

    public int getAtkNum() {
        return newPlayer.getAtkNum();
    }

    public void addAtkNum(int value) {
        newPlayer.addAtkNum(value);
    }

    public void addAtkNum() {
        newPlayer.addAtkNum();
    }

    public boolean checkAtkNum(int value) {
        return newPlayer.checkAtkNum(value);
    }

    public int getDefNum() {
        return newPlayer.getDefNum();
    }

    public void addDefNum(int value) {
        newPlayer.addDefNum(value);
    }

    public void addDefNum() {
        newPlayer.addDefNum();
    }

    public boolean checkDefNum(int value) {
        return newPlayer.checkDefNum(value);
    }

    public void sendActionBar(String message) {
        newPlayer.sendActionBar(message);
    }

    public String getUniqueIdtoString() {
        return newPlayer.getUniqueIdtoString();
    }

    public NewPlayer getNewPlayer() {
        return newPlayer.getNewPlayer();
    }

    public boolean getPlayerConnect() {
        return newPlayer.getPlayerConnect();
    }

    public int getPlayerJoinCount() {
        return newPlayer.getPlayerJoinCount();
    }

    public String getName() {
        return newPlayer.getName();
    }

    public String getDisplayName() {
        return newPlayer.getDisplayName();
    }

    public void setDisplayName(String name) {
        newPlayer.setDisplayName(name);
    }

    public String getPlayerListName() {
        return newPlayer.getPlayerListName();
    }

    public void setPlayerListName(String name) {
        newPlayer.setPlayerListName(name);
    }

    public String getPlayerListHeader() {
        return newPlayer.getPlayerListHeader();
    }

    public String getPlayerListFooter() {
        return newPlayer.getPlayerListFooter();
    }

    public void setPlayerListHeader(String header) {
        newPlayer.setPlayerListHeader(header);
    }

    public void setPlayerListFooter(String footer) {
        newPlayer.setPlayerListFooter(footer);
    }

    public void setPlayerListHeaderFooter(String header, String footer) {
        newPlayer.setPlayerListHeaderFooter(header, footer);
    }

    public void setCompassTarget(Location loc) {
        newPlayer.setCompassTarget(loc);
    }

    public Location getCompassTarget() {
        return newPlayer.getCompassTarget();
    }

    public InetSocketAddress getAddress() {
        return newPlayer.getAddress();
    }

    public void sendRawMessage(String message) {
        newPlayer.sendRawMessage(message);
    }

    public void kickPlayer(String message) {
        newPlayer.kickPlayer(message);
    }

    public void chat(String msg) {
        newPlayer.chat(msg);
    }

    public boolean performCommand(String command) {
        return newPlayer.performCommand(command);
    }

    @Deprecated
    public boolean isOnGround() {
        return newPlayer.isOnGround();
    }

    public boolean isSneaking() {
        return newPlayer.isSneaking();
    }

    public void setSneaking(boolean sneak) {
        newPlayer.setSneaking(sneak);
    }

    public boolean isSprinting() {
        return newPlayer.isSprinting();
    }

    public void setSprinting(boolean sprinting) {
        newPlayer.setSprinting(sprinting);
    }

    public void saveData() {
        newPlayer.saveData();
    }

    public void loadData() {
        newPlayer.loadData();
    }

    public void setSleepingIgnored(boolean isSleeping) {
        newPlayer.setSleepingIgnored(isSleeping);
    }

    public boolean isSleepingIgnored() {
        return newPlayer.isSleepingIgnored();
    }

    public Location getBedSpawnLocation() {
        return newPlayer.getBedSpawnLocation();
    }

    public void setBedSpawnLocation(Location location) {
        newPlayer.setBedSpawnLocation(location);
    }

    public void setBedSpawnLocation(Location location, boolean force) {
        newPlayer.setBedSpawnLocation(location, force);
    }

    @Deprecated
    public void playNote(Location loc, byte instrument, byte note) {
        newPlayer.playNote(loc, instrument, note);
    }

    public void playNote(Location loc, Instrument instrument, Note note) {
        newPlayer.playNote(loc, instrument, note);
    }

    public void playSound(Location location, Sound sound, float volume, float pitch) {
        newPlayer.playSound(location, sound, volume, pitch);
    }

    public void playSound(Location location, String sound, float volume, float pitch) {
        newPlayer.playSound(location, sound, volume, pitch);
    }

    public void playSound(Location location, Sound sound, SoundCategory category, float volume, float pitch) {
        newPlayer.playSound(location, sound, category, volume, pitch);
    }

    public void playSound(Location location, String sound, SoundCategory category, float volume, float pitch) {
        newPlayer.playSound(location, sound, category, volume, pitch);
    }

    public void playSound(Entity entity, Sound sound, float volume, float pitch) {
        newPlayer.playSound(entity, sound, volume, pitch);
    }

    public void playSound(Entity entity, Sound sound, SoundCategory category, float volume, float pitch) {
        newPlayer.playSound(entity, sound, category, volume, pitch);
    }

    public void stopSound(Sound sound) {
        newPlayer.stopSound(sound);
    }

    public void stopSound(String sound) {
        newPlayer.stopSound(sound);
    }

    public void stopSound(Sound sound, SoundCategory category) {
        newPlayer.stopSound(sound, category);
    }

    public void stopSound(String sound, SoundCategory category) {
        newPlayer.stopSound(sound, category);
    }

    public void stopSound(SoundCategory category) {
        newPlayer.stopSound(category);
    }

    public void stopAllSounds() {
        newPlayer.stopAllSounds();
    }

    @Deprecated
    public void playEffect(Location loc, Effect effect, int data) {
        newPlayer.playEffect(loc, effect, data);
    }

    public <T> void playEffect(Location loc, Effect effect, T data) {
        newPlayer.playEffect(loc, effect, data);
    }

    public boolean breakBlock(Block block) {
        return newPlayer.breakBlock(block);
    }

    @Deprecated
    public void sendBlockChange(Location loc, Material material, byte data) {
        newPlayer.sendBlockChange(loc, material, data);
    }

    public void sendBlockChange(Location loc, BlockData block) {
        newPlayer.sendBlockChange(loc, block);
    }

    public void sendBlockDamage(Location loc, float progress) {
        newPlayer.sendBlockDamage(loc, progress);
    }

    public void sendEquipmentChange(LivingEntity entity, EquipmentSlot slot, ItemStack item) {
        newPlayer.sendEquipmentChange(entity, slot, item);
    }

    public void sendSignChange(Location loc, String[] lines) throws IllegalArgumentException {
        newPlayer.sendSignChange(loc, lines);
    }

    public void sendSignChange(Location loc, String[] lines, DyeColor dyeColor) throws IllegalArgumentException {
        newPlayer.sendSignChange(loc, lines, dyeColor);
    }

    public void sendSignChange(Location loc, String[] lines, DyeColor dyeColor, boolean hasGlowingText) throws IllegalArgumentException {
        newPlayer.sendSignChange(loc, lines, dyeColor, hasGlowingText);
    }

    public void sendMap(MapView map) {
        newPlayer.sendMap(map);
    }

    public void updateInventory() {
        newPlayer.updateInventory();
    }

    public GameMode getPreviousGameMode() {
        return newPlayer.getPreviousGameMode();
    }

    public void setPlayerTime(long time, boolean relative) {
        newPlayer.setPlayerTime(time, relative);
    }

    public long getPlayerTime() {
        return newPlayer.getPlayerTime();
    }

    public long getPlayerTimeOffset() {
        return newPlayer.getPlayerTimeOffset();
    }

    public boolean isPlayerTimeRelative() {
        return newPlayer.isPlayerTimeRelative();
    }

    public void resetPlayerTime() {
        newPlayer.resetPlayerTime();
    }

    public void setPlayerWeather(WeatherType type) {
        newPlayer.setPlayerWeather(type);
    }

    public WeatherType getPlayerWeather() {
        return newPlayer.getPlayerWeather();
    }

    public void resetPlayerWeather() {
        newPlayer.resetPlayerWeather();
    }

    public void giveExp(int amount) {
        newPlayer.giveExp(amount);
    }

    public void giveExpLevels(int amount) {
        newPlayer.giveExpLevels(amount);
    }

    public float getExp() {
        return newPlayer.getExp();
    }

    public void setExp(float exp) {
        newPlayer.setExp(exp);
    }

    public int getLevel() {
        return newPlayer.getLevel();
    }

    public void setLevel(int level) {
        newPlayer.setLevel(level);
    }

    public int getTotalExperience() {
        return newPlayer.getTotalExperience();
    }

    public void setTotalExperience(int exp) {
        newPlayer.setTotalExperience(exp);
    }

    public void sendExperienceChange(float progress) {
        newPlayer.sendExperienceChange(progress);
    }

    public void sendExperienceChange(float progress, int level) {
        newPlayer.sendExperienceChange(progress, level);
    }

    public boolean getAllowFlight() {
        return newPlayer.getAllowFlight();
    }

    public void setAllowFlight(boolean flight) {
        newPlayer.setAllowFlight(flight);
    }

    @Deprecated
    public void hidePlayer(Player player) {
        newPlayer.hidePlayer(player);
    }

    public void hidePlayer(Plugin plugin, Player player) {
        newPlayer.hidePlayer(plugin, player);
    }

    @Deprecated
    public void showPlayer(Player player) {
        newPlayer.showPlayer(player);
    }

    public void showPlayer(Plugin plugin, Player player) {
        newPlayer.showPlayer(plugin, player);
    }

    public boolean canSee(Player player) {
        return newPlayer.canSee(player);
    }

    @Deprecated
    public void hideEntity(Plugin plugin, Entity entity) {
        newPlayer.hideEntity(plugin, entity);
    }

    @Deprecated
    public void showEntity(Plugin plugin, Entity entity) {
        newPlayer.showEntity(plugin, entity);
    }

    @Deprecated
    public boolean canSee(Entity entity) {
        return newPlayer.canSee(entity);
    }

    public boolean isFlying() {
        return newPlayer.isFlying();
    }

    public void setFlying(boolean value) {
        newPlayer.setFlying(value);
    }

    public void setFlySpeed(float value) throws IllegalArgumentException {
        newPlayer.setFlySpeed(value);
    }

    public void setWalkSpeed(float value) throws IllegalArgumentException {
        newPlayer.setWalkSpeed(value);
    }

    public float getFlySpeed() {
        return newPlayer.getFlySpeed();
    }

    public float getWalkSpeed() {
        return newPlayer.getWalkSpeed();
    }

    @Deprecated
    public void setTexturePack(String url) {
        newPlayer.setTexturePack(url);
    }

    public void setResourcePack(String url) {
        newPlayer.setResourcePack(url);
    }

    public void setResourcePack(String url, byte[] hash) {
        newPlayer.setResourcePack(url, hash);
    }

    public void setResourcePack(String url, byte[] hash, String prompt) {
        newPlayer.setResourcePack(url, hash, prompt);
    }

    public void setResourcePack(String url, byte[] hash, boolean force) {
        newPlayer.setResourcePack(url, hash, force);
    }

    public void setResourcePack(String url, byte[] hash, String prompt, boolean force) {
        newPlayer.setResourcePack(url, hash, prompt, force);
    }

    public Scoreboard getScoreboard() {
        return newPlayer.getScoreboard();
    }

    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
        newPlayer.setScoreboard(scoreboard);
    }

    public WorldBorder getWorldBorder() {
        return newPlayer.getWorldBorder();
    }

    public void setWorldBorder(WorldBorder border) {
        newPlayer.setWorldBorder(border);
    }

    public boolean isHealthScaled() {
        return newPlayer.isHealthScaled();
    }

    public void setHealthScaled(boolean scale) {
        newPlayer.setHealthScaled(scale);
    }

    public void setHealthScale(double scale) throws IllegalArgumentException {
        newPlayer.setHealthScale(scale);
    }

    public double getHealthScale() {
        return newPlayer.getHealthScale();
    }

    public Entity getSpectatorTarget() {
        return newPlayer.getSpectatorTarget();
    }

    public void setSpectatorTarget(Entity entity) {
        newPlayer.setSpectatorTarget(entity);
    }

    @Deprecated
    public void sendTitle(String title, String subtitle) {
        newPlayer.sendTitle(title, subtitle);
    }

    public void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        newPlayer.sendTitle(title, subtitle, fadeIn, stay, fadeOut);
    }

    public void resetTitle() {
        newPlayer.resetTitle();
    }

    public void spawnParticle(Particle particle, Location location, int count) {
        newPlayer.spawnParticle(particle, location, count);
    }

    public void spawnParticle(Particle particle, double x, double y, double z, int count) {
        newPlayer.spawnParticle(particle, x, y, z, count);
    }

    public <T> void spawnParticle(Particle particle, Location location, int count, T data) {
        newPlayer.spawnParticle(particle, location, count, data);
    }

    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, T data) {
        newPlayer.spawnParticle(particle, x, y, z, count, data);
    }

    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ) {
        newPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ);
    }

    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ) {
        newPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ);
    }

    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, T data) {
        newPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, data);
    }

    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, T data) {
        newPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, data);
    }

    public void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        newPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra);
    }

    public void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra) {
        newPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra);
    }

    public <T> void spawnParticle(Particle particle, Location location, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {
        newPlayer.spawnParticle(particle, location, count, offsetX, offsetY, offsetZ, extra, data);
    }

    public <T> void spawnParticle(Particle particle, double x, double y, double z, int count, double offsetX, double offsetY, double offsetZ, double extra, T data) {
        newPlayer.spawnParticle(particle, x, y, z, count, offsetX, offsetY, offsetZ, extra, data);
    }

    public AdvancementProgress getAdvancementProgress(Advancement advancement) {
        return newPlayer.getAdvancementProgress(advancement);
    }

    public int getClientViewDistance() {
        return newPlayer.getClientViewDistance();
    }

    public int getPing() {
        return newPlayer.getPing();
    }

    public String getLocale() {
        return newPlayer.getLocale();
    }

    public void updateCommands() {
        newPlayer.updateCommands();
    }

    public void openBook(ItemStack book) {
        newPlayer.openBook(book);
    }

    public void openSign(Sign sign) {
        newPlayer.openSign(sign);
    }

    public void showDemoScreen() {
        newPlayer.showDemoScreen();
    }

    public boolean isAllowingServerListings() {
        return newPlayer.isAllowingServerListings();
    }

    public Player.Spigot spigot() {
        return newPlayer.spigot();
    }

    public PlayerInventory getInventory() {
        return newPlayer.getInventory();
    }

    public Inventory getEnderChest() {
        return newPlayer.getEnderChest();
    }

    public MainHand getMainHand() {
        return newPlayer.getMainHand();
    }

    public boolean setWindowProperty(InventoryView.Property prop, int value) {
        return newPlayer.setWindowProperty(prop, value);
    }

    public InventoryView getOpenInventory() {
        return newPlayer.getOpenInventory();
    }

    public InventoryView openInventory(Inventory inventory) {
        return newPlayer.openInventory(inventory);
    }

    public InventoryView openWorkbench(Location location, boolean force) {
        return newPlayer.openWorkbench(location, force);
    }

    public InventoryView openEnchanting(Location location, boolean force) {
        return newPlayer.openEnchanting(location, force);
    }

    public void openInventory(InventoryView inventory) {
        newPlayer.openInventory(inventory);
    }

    public InventoryView openMerchant(Villager trader, boolean force) {
        return newPlayer.openMerchant(trader, force);
    }

    public InventoryView openMerchant(Merchant merchant, boolean force) {
        return newPlayer.openMerchant(merchant, force);
    }

    public void closeInventory() {
        newPlayer.closeInventory();
    }

    @Deprecated
    public ItemStack getItemInHand() {
        return newPlayer.getItemInHand();
    }

    @Deprecated
    public void setItemInHand(ItemStack item) {
        newPlayer.setItemInHand(item);
    }

    public ItemStack getItemOnCursor() {
        return newPlayer.getItemOnCursor();
    }

    public void setItemOnCursor(ItemStack item) {
        newPlayer.setItemOnCursor(item);
    }

    public boolean hasCooldown(Material material) {
        return newPlayer.hasCooldown(material);
    }

    public int getCooldown(Material material) {
        return newPlayer.getCooldown(material);
    }

    public void setCooldown(Material material, int ticks) {
        newPlayer.setCooldown(material, ticks);
    }

    public int getSleepTicks() {
        return newPlayer.getSleepTicks();
    }

    public boolean sleep(Location location, boolean force) {
        return newPlayer.sleep(location, force);
    }

    public void wakeup(boolean setSpawnLocation) {
        newPlayer.wakeup(setSpawnLocation);
    }

    public Location getBedLocation() {
        return newPlayer.getBedLocation();
    }

    public GameMode getGameMode() {
        return newPlayer.getGameMode();
    }

    public void setGameMode(GameMode mode) {
        newPlayer.setGameMode(mode);
    }

    public boolean isBlocking() {
        return newPlayer.isBlocking();
    }

    public boolean isHandRaised() {
        return newPlayer.isHandRaised();
    }

    public ItemStack getItemInUse() {
        return newPlayer.getItemInUse();
    }

    public int getExpToLevel() {
        return newPlayer.getExpToLevel();
    }

    public float getAttackCooldown() {
        return newPlayer.getAttackCooldown();
    }

    public boolean discoverRecipe(NamespacedKey recipe) {
        return newPlayer.discoverRecipe(recipe);
    }

    public int discoverRecipes(Collection<NamespacedKey> recipes) {
        return newPlayer.discoverRecipes(recipes);
    }

    public boolean undiscoverRecipe(NamespacedKey recipe) {
        return newPlayer.undiscoverRecipe(recipe);
    }

    public int undiscoverRecipes(Collection<NamespacedKey> recipes) {
        return newPlayer.undiscoverRecipes(recipes);
    }

    public boolean hasDiscoveredRecipe(NamespacedKey recipe) {
        return newPlayer.hasDiscoveredRecipe(recipe);
    }

    public Set<NamespacedKey> getDiscoveredRecipes() {
        return newPlayer.getDiscoveredRecipes();
    }

    @Deprecated
    public Entity getShoulderEntityLeft() {
        return newPlayer.getShoulderEntityLeft();
    }

    @Deprecated
    public void setShoulderEntityLeft(Entity entity) {
        newPlayer.setShoulderEntityLeft(entity);
    }

    @Deprecated
    public Entity getShoulderEntityRight() {
        return newPlayer.getShoulderEntityRight();
    }

    @Deprecated
    public void setShoulderEntityRight(Entity entity) {
        newPlayer.setShoulderEntityRight(entity);
    }

    public boolean dropItem(boolean dropAll) {
        return newPlayer.dropItem(dropAll);
    }

    public float getExhaustion() {
        return newPlayer.getExhaustion();
    }

    public void setExhaustion(float value) {
        newPlayer.setExhaustion(value);
    }

    public float getSaturation() {
        return newPlayer.getSaturation();
    }

    public void setSaturation(float value) {
        newPlayer.setSaturation(value);
    }

    public int getFoodLevel() {
        return newPlayer.getFoodLevel();
    }

    public void setFoodLevel(int value) {
        newPlayer.setFoodLevel(value);
    }

    public int getSaturatedRegenRate() {
        return newPlayer.getSaturatedRegenRate();
    }

    public void setSaturatedRegenRate(int ticks) {
        newPlayer.setSaturatedRegenRate(ticks);
    }

    public int getUnsaturatedRegenRate() {
        return newPlayer.getUnsaturatedRegenRate();
    }

    public void setUnsaturatedRegenRate(int ticks) {
        newPlayer.setUnsaturatedRegenRate(ticks);
    }

    public int getStarvationRate() {
        return newPlayer.getStarvationRate();
    }

    public void setStarvationRate(int ticks) {
        newPlayer.setStarvationRate(ticks);
    }

    public Location getLastDeathLocation() {
        return newPlayer.getLastDeathLocation();
    }

    public void setLastDeathLocation(Location location) {
        newPlayer.setLastDeathLocation(location);
    }

    public double getEyeHeight() {
        return newPlayer.getEyeHeight();
    }

    public double getEyeHeight(boolean ignorePose) {
        return newPlayer.getEyeHeight(ignorePose);
    }

    public Location getEyeLocation() {
        return newPlayer.getEyeLocation();
    }

    public List<Block> getLineOfSight(Set<Material> transparent, int maxDistance) {
        return newPlayer.getLineOfSight(transparent, maxDistance);
    }

    public Block getTargetBlock(Set<Material> transparent, int maxDistance) {
        return newPlayer.getTargetBlock(transparent, maxDistance);
    }

    public List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance) {
        return newPlayer.getLastTwoTargetBlocks(transparent, maxDistance);
    }

    public Block getTargetBlockExact(int maxDistance) {
        return newPlayer.getTargetBlockExact(maxDistance);
    }

    public Block getTargetBlockExact(int maxDistance, FluidCollisionMode fluidCollisionMode) {
        return newPlayer.getTargetBlockExact(maxDistance, fluidCollisionMode);
    }

    public RayTraceResult rayTraceBlocks(double maxDistance) {
        return newPlayer.rayTraceBlocks(maxDistance);
    }

    public RayTraceResult rayTraceBlocks(double maxDistance, FluidCollisionMode fluidCollisionMode) {
        return newPlayer.rayTraceBlocks(maxDistance, fluidCollisionMode);
    }

    public int getRemainingAir() {
        return newPlayer.getRemainingAir();
    }

    public void setRemainingAir(int ticks) {
        newPlayer.setRemainingAir(ticks);
    }

    public int getMaximumAir() {
        return newPlayer.getMaximumAir();
    }

    public void setMaximumAir(int ticks) {
        newPlayer.setMaximumAir(ticks);
    }

    public int getArrowCooldown() {
        return newPlayer.getArrowCooldown();
    }

    public void setArrowCooldown(int ticks) {
        newPlayer.setArrowCooldown(ticks);
    }

    public int getArrowsInBody() {
        return newPlayer.getArrowsInBody();
    }

    public void setArrowsInBody(int count) {
        newPlayer.setArrowsInBody(count);
    }

    public int getMaximumNoDamageTicks() {
        return newPlayer.getMaximumNoDamageTicks();
    }

    public void setMaximumNoDamageTicks(int ticks) {
        newPlayer.setMaximumNoDamageTicks(ticks);
    }

    public double getLastDamage() {
        return newPlayer.getLastDamage();
    }

    public void setLastDamage(double damage) {
        newPlayer.setLastDamage(damage);
    }

    public int getNoDamageTicks() {
        return newPlayer.getNoDamageTicks();
    }

    public void setNoDamageTicks(int ticks) {
        newPlayer.setNoDamageTicks(ticks);
    }

    public Player getKiller() {
        return newPlayer.getKiller();
    }

    public boolean addPotionEffect(PotionEffect effect) {
        return newPlayer.addPotionEffect(effect);
    }

    @Deprecated
    public boolean addPotionEffect(PotionEffect effect, boolean force) {
        return newPlayer.addPotionEffect(effect, force);
    }

    public boolean addPotionEffects(Collection<PotionEffect> effects) {
        return newPlayer.addPotionEffects(effects);
    }

    public boolean hasPotionEffect(PotionEffectType type) {
        return newPlayer.hasPotionEffect(type);
    }

    public PotionEffect getPotionEffect(PotionEffectType type) {
        return newPlayer.getPotionEffect(type);
    }

    public void removePotionEffect(PotionEffectType type) {
        newPlayer.removePotionEffect(type);
    }

    public Collection<PotionEffect> getActivePotionEffects() {
        return newPlayer.getActivePotionEffects();
    }

    public boolean hasLineOfSight(Entity other) {
        return newPlayer.hasLineOfSight(other);
    }

    public boolean getRemoveWhenFarAway() {
        return newPlayer.getRemoveWhenFarAway();
    }

    public void setRemoveWhenFarAway(boolean remove) {
        newPlayer.setRemoveWhenFarAway(remove);
    }

    public EntityEquipment getEquipment() {
        return newPlayer.getEquipment();
    }

    public void setCanPickupItems(boolean pickup) {
        newPlayer.setCanPickupItems(pickup);
    }

    public boolean getCanPickupItems() {
        return newPlayer.getCanPickupItems();
    }

    public boolean isLeashed() {
        return newPlayer.isLeashed();
    }

    public Entity getLeashHolder() throws IllegalStateException {
        return newPlayer.getLeashHolder();
    }

    public boolean setLeashHolder(Entity holder) {
        return newPlayer.setLeashHolder(holder);
    }

    public boolean isGliding() {
        return newPlayer.isGliding();
    }

    public void setGliding(boolean gliding) {
        newPlayer.setGliding(gliding);
    }

    public boolean isSwimming() {
        return newPlayer.isSwimming();
    }

    public void setSwimming(boolean swimming) {
        newPlayer.setSwimming(swimming);
    }

    public boolean isRiptiding() {
        return newPlayer.isRiptiding();
    }

    public boolean isSleeping() {
        return newPlayer.isSleeping();
    }

    public boolean isClimbing() {
        return newPlayer.isClimbing();
    }

    public void setAI(boolean ai) {
        newPlayer.setAI(ai);
    }

    public boolean hasAI() {
        return newPlayer.hasAI();
    }

    public void attack(Entity target) {
        newPlayer.attack(target);
    }

    public void swingMainHand() {
        newPlayer.swingMainHand();
    }

    public void swingOffHand() {
        newPlayer.swingOffHand();
    }

    public void setCollidable(boolean collidable) {
        newPlayer.setCollidable(collidable);
    }

    public boolean isCollidable() {
        return newPlayer.isCollidable();
    }

    public Set<UUID> getCollidableExemptions() {
        return newPlayer.getCollidableExemptions();
    }

    public <T> T getMemory(MemoryKey<T> memoryKey) {
        return newPlayer.getMemory(memoryKey);
    }

    public <T> void setMemory(MemoryKey<T> memoryKey, T memoryValue) {
        newPlayer.setMemory(memoryKey, memoryValue);
    }

    public EntityCategory getCategory() {
        return newPlayer.getCategory();
    }

    public void setInvisible(boolean invisible) {
        newPlayer.setInvisible(invisible);
    }

    public boolean isInvisible() {
        return newPlayer.isInvisible();
    }

    public AttributeInstance getAttribute(Attribute attribute) {
        return newPlayer.getAttribute(attribute);
    }

    public void damage(double amount) {
        newPlayer.damage(amount);
    }

    public void damage(double amount, Entity source) {
        newPlayer.damage(amount, source);
    }

    public double getHealth() {
        return newPlayer.getHealth();
    }

    public void setHealth(double health) {
        newPlayer.setHealth(health);
    }

    public double getAbsorptionAmount() {
        return newPlayer.getAbsorptionAmount();
    }

    public void setAbsorptionAmount(double amount) {
        newPlayer.setAbsorptionAmount(amount);
    }

    @Deprecated
    public double getMaxHealth() {
        return newPlayer.getMaxHealth();
    }

    @Deprecated
    public void setMaxHealth(double health) {
        newPlayer.setMaxHealth(health);
    }

    @Deprecated
    public void resetMaxHealth() {
        newPlayer.resetMaxHealth();
    }

    public Location getLocation() {
        return newPlayer.getLocation();
    }

    public Location getLocation(Location loc) {
        return newPlayer.getLocation(loc);
    }

    public void setVelocity(Vector velocity) {
        newPlayer.setVelocity(velocity);
    }

    public Vector getVelocity() {
        return newPlayer.getVelocity();
    }

    public double getHeight() {
        return newPlayer.getHeight();
    }

    public double getWidth() {
        return newPlayer.getWidth();
    }

    public BoundingBox getBoundingBox() {
        return newPlayer.getBoundingBox();
    }

    public boolean isInWater() {
        return newPlayer.isInWater();
    }

    public World getWorld() {
        return newPlayer.getWorld();
    }

    public void setRotation(float yaw, float pitch) {
        newPlayer.setRotation(yaw, pitch);
    }

    public boolean teleport(Location location) {
        return newPlayer.teleport(location);
    }

    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause cause) {
        return newPlayer.teleport(location, cause);
    }

    public boolean teleport(Entity destination) {
        return newPlayer.teleport(destination);
    }

    public boolean teleport(Entity destination, PlayerTeleportEvent.TeleportCause cause) {
        return newPlayer.teleport(destination, cause);
    }

    public List<Entity> getNearbyEntities(double x, double y, double z) {
        return newPlayer.getNearbyEntities(x, y, z);
    }

    public int getEntityId() {
        return newPlayer.getEntityId();
    }

    public int getFireTicks() {
        return newPlayer.getFireTicks();
    }

    public int getMaxFireTicks() {
        return newPlayer.getMaxFireTicks();
    }

    public void setFireTicks(int ticks) {
        newPlayer.setFireTicks(ticks);
    }

    public void setVisualFire(boolean fire) {
        newPlayer.setVisualFire(fire);
    }

    public boolean isVisualFire() {
        return newPlayer.isVisualFire();
    }

    public int getFreezeTicks() {
        return newPlayer.getFreezeTicks();
    }

    public int getMaxFreezeTicks() {
        return newPlayer.getMaxFreezeTicks();
    }

    public void setFreezeTicks(int ticks) {
        newPlayer.setFreezeTicks(ticks);
    }

    public boolean isFrozen() {
        return newPlayer.isFrozen();
    }

    public void remove() {
        newPlayer.remove();
    }

    public boolean isDead() {
        return newPlayer.isDead();
    }

    public boolean isValid() {
        return newPlayer.isValid();
    }

    public Server getServer() {
        return newPlayer.getServer();
    }

    public boolean isPersistent() {
        return newPlayer.isPersistent();
    }

    public void setPersistent(boolean persistent) {
        newPlayer.setPersistent(persistent);
    }

    @Deprecated
    public Entity getPassenger() {
        return newPlayer.getPassenger();
    }

    @Deprecated
    public boolean setPassenger(Entity passenger) {
        return newPlayer.setPassenger(passenger);
    }

    public List<Entity> getPassengers() {
        return newPlayer.getPassengers();
    }

    public boolean addPassenger(Entity passenger) {
        return newPlayer.addPassenger(passenger);
    }

    public boolean removePassenger(Entity passenger) {
        return newPlayer.removePassenger(passenger);
    }

    public boolean isEmpty() {
        return newPlayer.isEmpty();
    }

    public boolean eject() {
        return newPlayer.eject();
    }

    public float getFallDistance() {
        return newPlayer.getFallDistance();
    }

    public void setFallDistance(float distance) {
        newPlayer.setFallDistance(distance);
    }

    public void setLastDamageCause(EntityDamageEvent event) {
        newPlayer.setLastDamageCause(event);
    }

    public EntityDamageEvent getLastDamageCause() {
        return newPlayer.getLastDamageCause();
    }

    public UUID getUniqueId() {
        return newPlayer.getUniqueId();
    }

    public int getTicksLived() {
        return newPlayer.getTicksLived();
    }

    public void setTicksLived(int value) {
        newPlayer.setTicksLived(value);
    }

    public void playEffect(EntityEffect type) {
        newPlayer.playEffect(type);
    }

    public EntityType getType() {
        return newPlayer.getType();
    }

    public boolean isInsideVehicle() {
        return newPlayer.isInsideVehicle();
    }

    public boolean leaveVehicle() {
        return newPlayer.leaveVehicle();
    }

    public Entity getVehicle() {
        return newPlayer.getVehicle();
    }

    public void setCustomNameVisible(boolean flag) {
        newPlayer.setCustomNameVisible(flag);
    }

    public boolean isCustomNameVisible() {
        return newPlayer.isCustomNameVisible();
    }

    public void setGlowing(boolean flag) {
        newPlayer.setGlowing(flag);
    }

    public boolean isGlowing() {
        return newPlayer.isGlowing();
    }

    public void setInvulnerable(boolean flag) {
        newPlayer.setInvulnerable(flag);
    }

    public boolean isInvulnerable() {
        return newPlayer.isInvulnerable();
    }

    public boolean isSilent() {
        return newPlayer.isSilent();
    }

    public void setSilent(boolean flag) {
        newPlayer.setSilent(flag);
    }

    public boolean hasGravity() {
        return newPlayer.hasGravity();
    }

    public void setGravity(boolean gravity) {
        newPlayer.setGravity(gravity);
    }

    public int getPortalCooldown() {
        return newPlayer.getPortalCooldown();
    }

    public void setPortalCooldown(int cooldown) {
        newPlayer.setPortalCooldown(cooldown);
    }

    public Set<String> getScoreboardTags() {
        return newPlayer.getScoreboardTags();
    }

    public boolean addScoreboardTag(String tag) {
        return newPlayer.addScoreboardTag(tag);
    }

    public boolean removeScoreboardTag(String tag) {
        return newPlayer.removeScoreboardTag(tag);
    }

    public PistonMoveReaction getPistonMoveReaction() {
        return newPlayer.getPistonMoveReaction();
    }

    public BlockFace getFacing() {
        return newPlayer.getFacing();
    }

    public Pose getPose() {
        return newPlayer.getPose();
    }

    public SpawnCategory getSpawnCategory() {
        return newPlayer.getSpawnCategory();
    }

    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
        newPlayer.setMetadata(metadataKey, newMetadataValue);
    }

    public List<MetadataValue> getMetadata(String metadataKey) {
        return newPlayer.getMetadata(metadataKey);
    }

    public boolean hasMetadata(String metadataKey) {
        return newPlayer.hasMetadata(metadataKey);
    }

    public void removeMetadata(String metadataKey, Plugin owningPlugin) {
        newPlayer.removeMetadata(metadataKey, owningPlugin);
    }

    public void sendMessage(String message) {
        newPlayer.sendMessage(message);
    }

    public void sendMessage(String... messages) {
        newPlayer.sendMessage(messages);
    }

    public void sendMessage(UUID sender, String message) {
        newPlayer.sendMessage(sender, message);
    }

    public void sendMessage(UUID sender, String... messages) {
        newPlayer.sendMessage(sender, messages);
    }

    public boolean isPermissionSet(String name) {
        return newPlayer.isPermissionSet(name);
    }

    public boolean isPermissionSet(Permission perm) {
        return newPlayer.isPermissionSet(perm);
    }

    public boolean hasPermission(String name) {
        return newPlayer.hasPermission(name);
    }

    public boolean hasPermission(Permission perm) {
        return newPlayer.hasPermission(perm);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return newPlayer.addAttachment(plugin, name, value);
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        return newPlayer.addAttachment(plugin);
    }

    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return newPlayer.addAttachment(plugin, name, value, ticks);
    }

    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return newPlayer.addAttachment(plugin, ticks);
    }

    public void removeAttachment(PermissionAttachment attachment) {
        newPlayer.removeAttachment(attachment);
    }

    public void recalculatePermissions() {
        newPlayer.recalculatePermissions();
    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return newPlayer.getEffectivePermissions();
    }

    public boolean isOp() {
        return newPlayer.isOp();
    }

    public void setOp(boolean value) {
        newPlayer.setOp(value);
    }

    public String getCustomName() {
        return newPlayer.getCustomName();
    }

    public void setCustomName(String name) {
        newPlayer.setCustomName(name);
    }

    public PersistentDataContainer getPersistentDataContainer() {
        return newPlayer.getPersistentDataContainer();
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile) {
        return newPlayer.launchProjectile(projectile);
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> projectile, Vector velocity) {
        return newPlayer.launchProjectile(projectile, velocity);
    }

    public boolean isConversing() {
        return newPlayer.isConversing();
    }

    public void acceptConversationInput(String input) {
        newPlayer.acceptConversationInput(input);
    }

    public boolean beginConversation(Conversation conversation) {
        return newPlayer.beginConversation(conversation);
    }

    public void abandonConversation(Conversation conversation) {
        newPlayer.abandonConversation(conversation);
    }

    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent details) {
        newPlayer.abandonConversation(conversation, details);
    }

    public void sendRawMessage(UUID sender, String message) {
        newPlayer.sendRawMessage(sender, message);
    }

    public boolean isOnline() {
        return newPlayer.isOnline();
    }

    public PlayerProfile getPlayerProfile() {
        return newPlayer.getPlayerProfile();
    }

    public boolean isBanned() {
        return newPlayer.isBanned();
    }

    public boolean isWhitelisted() {
        return newPlayer.isWhitelisted();
    }

    public void setWhitelisted(boolean value) {
        newPlayer.setWhitelisted(value);
    }

    public Player getPlayer() {
        return newPlayer.getPlayer();
    }

    public long getFirstPlayed() {
        return newPlayer.getFirstPlayed();
    }

    public long getLastPlayed() {
        return newPlayer.getLastPlayed();
    }

    public boolean hasPlayedBefore() {
        return newPlayer.hasPlayedBefore();
    }

    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
        newPlayer.incrementStatistic(statistic);
    }

    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
        newPlayer.decrementStatistic(statistic);
    }

    public void incrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        newPlayer.incrementStatistic(statistic, amount);
    }

    public void decrementStatistic(Statistic statistic, int amount) throws IllegalArgumentException {
        newPlayer.decrementStatistic(statistic, amount);
    }

    public void setStatistic(Statistic statistic, int newValue) throws IllegalArgumentException {
        newPlayer.setStatistic(statistic, newValue);
    }

    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        return newPlayer.getStatistic(statistic);
    }

    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        newPlayer.incrementStatistic(statistic, material);
    }

    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        newPlayer.decrementStatistic(statistic, material);
    }

    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        return newPlayer.getStatistic(statistic, material);
    }

    public void incrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        newPlayer.incrementStatistic(statistic, material, amount);
    }

    public void decrementStatistic(Statistic statistic, Material material, int amount) throws IllegalArgumentException {
        newPlayer.decrementStatistic(statistic, material, amount);
    }

    public void setStatistic(Statistic statistic, Material material, int newValue) throws IllegalArgumentException {
        newPlayer.setStatistic(statistic, material, newValue);
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        newPlayer.incrementStatistic(statistic, entityType);
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        newPlayer.decrementStatistic(statistic, entityType);
    }

    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        return newPlayer.getStatistic(statistic, entityType);
    }

    public void incrementStatistic(Statistic statistic, EntityType entityType, int amount) throws IllegalArgumentException {
        newPlayer.incrementStatistic(statistic, entityType, amount);
    }

    public void decrementStatistic(Statistic statistic, EntityType entityType, int amount) {
        newPlayer.decrementStatistic(statistic, entityType, amount);
    }

    public void setStatistic(Statistic statistic, EntityType entityType, int newValue) {
        newPlayer.setStatistic(statistic, entityType, newValue);
    }

    public Map<String, Object> serialize() {
        return newPlayer.serialize();
    }

    public void sendPluginMessage(Plugin source, String channel, byte[] message) {
        newPlayer.sendPluginMessage(source, channel, message);
    }

    public Set<String> getListeningPluginChannels() {
        return newPlayer.getListeningPluginChannels();
    }

    public void setCoolTimeSecond(String coolTimeName, double second) {
        newPlayer.setCoolTimeSecond(coolTimeName, second);
    }

    public void setCoolTimeMinute(String coolTimeName, int minute) {
        newPlayer.setCoolTimeMinute(coolTimeName, minute);
    }

    public void setCoolTimeHour(String coolTimeName, int hour) {
        newPlayer.setCoolTimeHour(coolTimeName, hour);
    }

    public void setCoolTimeDay(String coolTimeName, int day) {
        newPlayer.setCoolTimeDay(coolTimeName, day);
    }

    public void setCoolTimeMonth(String coolTimeName, int month) {
        newPlayer.setCoolTimeMonth(coolTimeName, month);
    }

    public void setCoolTimeYear(String coolTimeName, int year) {
        newPlayer.setCoolTimeYear(coolTimeName, year);
    }

    public double getLessCoolTime(String coolTimeName) {
        return newPlayer.getLessCoolTime(coolTimeName);
    }

    public void removeCoolTime(String coolTimeName) {
        newPlayer.removeCoolTime(coolTimeName);
    }

    public void reduceCoolTime(String coolTimeName, double reduceSecond) {
        newPlayer.reduceCoolTime(coolTimeName, reduceSecond);
    }

    public boolean checkCoolTime(String coolTimeName) {
        return newPlayer.checkCoolTime(coolTimeName);
    }

    public PlayerInfoMaps getPlayerInfoMaps() {
        return newPlayer.getPlayerInfoMaps();
    }

    public CoolTime getCoolTime() {
        return newPlayer.getCoolTime();
    }

    public void saveInfoMaps() {
        newPlayer.saveInfoMaps();
    }

    public String getFileLoc() {
        return newPlayer.getFileLoc();
    }

    public void copy(InfoMaps infoMaps) {
        newPlayer.copy(infoMaps);
    }

    public NotNullStrMap<Integer> getIntegerMap() {
        return newPlayer.getIntegerMap();
    }

    public int getIntegerValue(String key) {
        return newPlayer.getIntegerValue(key);
    }

    public void setIntegerValue(String key, int value) {
        newPlayer.setIntegerValue(key, value);
    }

    public void addIntegerValue(String key, int value) {
        newPlayer.addIntegerValue(key, value);
    }

    public void removeIntegerValue(String key) {
        newPlayer.removeIntegerValue(key);
    }

    public boolean containsIntegerValue(String key) {
        return newPlayer.containsIntegerValue(key);
    }

    public Set<String> getIntegerKeys() {
        return newPlayer.getIntegerKeys();
    }

    public Collection<Integer> getIntegerValues() {
        return newPlayer.getIntegerValues();
    }

    public NotNullStrMap<Double> getDoubleMap() {
        return newPlayer.getDoubleMap();
    }

    public double getDoubleValue(String key) {
        return newPlayer.getDoubleValue(key);
    }

    public void setDoubleValue(String key, double value) {
        newPlayer.setDoubleValue(key, value);
    }

    public void addDoubleValue(String key, double value) {
        newPlayer.addDoubleValue(key, value);
    }

    public void removeDoubleValue(String key) {
        newPlayer.removeDoubleValue(key);
    }

    public boolean containsDoubleValue(String key) {
        return newPlayer.containsDoubleValue(key);
    }

    public Set<String> getDoubleKeys() {
        return newPlayer.getDoubleKeys();
    }

    public Collection<Double> getDoubleValues() {
        return newPlayer.getDoubleValues();
    }

    public NotNullStrMap<Long> getLongMap() {
        return newPlayer.getLongMap();
    }

    public long getLongValue(String key) {
        return newPlayer.getLongValue(key);
    }

    public void setLongValue(String key, long value) {
        newPlayer.setLongValue(key, value);
    }

    public void addLongValue(String key, long value) {
        newPlayer.addLongValue(key, value);
    }

    public void removeLongValue(String key) {
        newPlayer.removeLongValue(key);
    }

    public boolean containsLongValue(String key) {
        return newPlayer.containsLongValue(key);
    }

    public Set<String> getLongKeys() {
        return newPlayer.getLongKeys();
    }

    public Collection<Long> getLongValues() {
        return newPlayer.getLongValues();
    }

    public NotNullStrMap<String> getStringMap() {
        return newPlayer.getStringMap();
    }

    public String getStringValue(String key) {
        return newPlayer.getStringValue(key);
    }

    public void setStringValue(String key, String value) {
        newPlayer.setStringValue(key, value);
    }

    public void addStringValue(String key, String value) {
        newPlayer.addStringValue(key, value);
    }

    public void removeStringValue(String key) {
        newPlayer.removeStringValue(key);
    }

    public boolean containsStringValue(String key) {
        return newPlayer.containsStringValue(key);
    }

    public Set<String> getStringKeys() {
        return newPlayer.getStringKeys();
    }

    public Collection<String> getStringValues() {
        return newPlayer.getStringValues();
    }

    public NotNullStrMap<Boolean> getBooleanMap() {
        return newPlayer.getBooleanMap();
    }

    public boolean getBooleanValue(String key) {
        return newPlayer.getBooleanValue(key);
    }

    public void setBooleanValue(String key, boolean value) {
        newPlayer.setBooleanValue(key, value);
    }

    public void removeBooleanValue(String key) {
        newPlayer.removeBooleanValue(key);
    }

    public boolean containsBooleanValue(String key) {
        return newPlayer.containsBooleanValue(key);
    }

    public Set<String> getBooleanKeys() {
        return newPlayer.getBooleanKeys();
    }

    public Collection<Boolean> getBooleanValues() {
        return newPlayer.getBooleanValues();
    }

    public NotNullStrMap<ItemStack> getItemStackMap() {
        return newPlayer.getItemStackMap();
    }

    public ItemStack getItemStackValue(String key) {
        return newPlayer.getItemStackValue(key);
    }

    public void setItemStackValue(String key, ItemStack value) {
        newPlayer.setItemStackValue(key, value);
    }

    public void removeItemStackValue(String key) {
        newPlayer.removeItemStackValue(key);
    }

    public boolean containsItemStackValue(String key) {
        return newPlayer.containsItemStackValue(key);
    }

    public Set<String> getItemStackKeys() {
        return newPlayer.getItemStackKeys();
    }

    public Collection<ItemStack> getItemStackValues() {
        return newPlayer.getItemStackValues();
    }

    public NotNullStrMap<Inventory> getInventoryMap() {
        return newPlayer.getInventoryMap();
    }

    public Inventory getInventoryValue(String key) {
        return newPlayer.getInventoryValue(key);
    }

    public void setInventoryValue(String key, Inventory value) {
        newPlayer.setInventoryValue(key, value);
    }

    public void removeInventoryValue(String key) {
        newPlayer.removeInventoryValue(key);
    }

    public boolean containsInventoryValue(String key) {
        return newPlayer.containsInventoryValue(key);
    }

    public Set<String> getInventoryKeys() {
        return newPlayer.getInventoryKeys();
    }

    public Collection<Inventory> getInventoryValues() {
        return newPlayer.getInventoryValues();
    }

    public NotNullStrMap<Location> getLocationMap() {
        return newPlayer.getLocationMap();
    }

    public Location getLocationValue(String key) {
        return newPlayer.getLocationValue(key);
    }

    public void setLocationValue(String key, Location value) {
        newPlayer.setLocationValue(key, value);
    }

    public void addLocationValue(String key, Location value) {
        newPlayer.addLocationValue(key, value);
    }

    public void addLocationValue(String key, Vector vec) {
        newPlayer.addLocationValue(key, vec);
    }

    public void removeLocationValue(String key) {
        newPlayer.removeLocationValue(key);
    }

    public boolean containsLocationValue(String key) {
        return newPlayer.containsLocationValue(key);
    }

    public Set<String> getLocationKeys() {
        return newPlayer.getLocationKeys();
    }

    public Collection<Location> getLocationValues() {
        return newPlayer.getLocationValues();
    }
}
