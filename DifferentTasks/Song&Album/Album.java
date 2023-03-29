
package Artem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ilia_Dukhov
 */
public class Album {
    private List<Song> album = new ArrayList<>();
    
    public Album(List songs){
        this.album = new ArrayList<>(correctAlbum(album));
    }
    
    public List getSongs(){
        return new ArrayList<>(album);
    }
    
    private List<Song> correctAlbum(List<Song> album){
        for(int i = 0; i<album.size(); i++){
            for(int j = i+1; j<album.size(); j++){
                if(album.get(j).getName()==album.get(i).getName()){
                    album.remove(j);
                }
            }
        }
        return new ArrayList<>(album);
    }
    
    public Song getSong(int index){
        return album.get(index);
    }
    
    public String toString(){
        return String.format("%s", album);
    }
}
