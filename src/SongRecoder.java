/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author youngjucho
 */
public class SongTracker {
  private final Map<String, SongRecord> songRecordByBandName = new HashMap<>();

  public SongTracker addPlayedSong(String bandName, String songName) {
    songRecordByBandName
        .put(
            bandName,
            songRecordByBandName.getOrDefault(bandName, new SongRecord()).addSong(songName));
     return this;
   }

   public Optional<String> getTopSong(String bandName) {
     SongRecord songRecord = songRecordByBandName.get(bandName);
     if (songRecord == null) {
       return Optional.empty();
     }
     return Optional.of(songRecord.getTopSong());
   }
}

private static class SongRecord {
  @Nullable private String topSong;
   private final Map<String, Integer> songNum = new HashMap<>();
   
   SongRecord addSong(String songName) {
     if (topSong == null) {
       topSong = songName;
       songNum.put(songName, 1);
       return this;
     }

