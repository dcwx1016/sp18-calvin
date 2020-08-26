public class OffByN implements CharacterComparator{
    public int num;
    public OffByN(int N){
        this.num = N;
    }

    @Override
    public boolean equalChars(char x, char y){
        int diff = x - y;
        if(diff == -this.num || diff == this.num){
            return true;
        } else{
            return false;
        }
    }

}
