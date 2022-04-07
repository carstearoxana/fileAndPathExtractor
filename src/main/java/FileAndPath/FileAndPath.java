package FileAndPath;

//Extrage din el: calea fisierului,
//        numele folder-ului in care se afla fisierul,
//        numele fisierului fara extensie si
//        extensia fisierului fara punctASAsa

public class FileAndPath {
    private String filePath;

    public FileAndPath(String filePath) {
        this.filePath = checkIsNullOrSpaceOrEmptyString(filePath);
    }

    public String checkIsNullOrSpaceOrEmptyString(String stringToCheck) {
        if (stringToCheck == null) {
            throw new NullPointerException("Null value");
        }
        if (stringToCheck.equals(" ") || stringToCheck.equals("")) {
            throw new IllegalArgumentException("Empty value");
        }
        return stringToCheck;
    }

    public char getSlash(){
        if(filePath.contains("/")){
            return '/';
        }else if(filePath.equals("\\")){
            return '\\';
        }else return 0;
    }

    public int getLastIndexOfSlash(String temporaryPath){
        return temporaryPath.lastIndexOf(getSlash());
    }

    public String getParentPath(){
        return getLastIndexOfSlash(filePath) <=0 ? "" : filePath.substring(0,getLastIndexOfSlash(filePath));
    }

    public String getFolderName(){
        String parenrPath=getParentPath();
        return parenrPath.equals("") ? parenrPath : parenrPath.substring(getLastIndexOfSlash(parenrPath)+1, getLastIndexOfSlash(filePath));
    }

    public String getFileName(){
        if(getExtensionDotIndex()>-1){
            return compareSlashIndexAndDotIndex() ? filePath.substring(getLastIndexOfSlash(filePath)+1): filePath.substring(getLastIndexOfSlash(filePath)+1,getExtensionDotIndex());
        }else return filePath.substring(getLastIndexOfSlash(filePath)+1);
    }

    public String getFileExtension(){
        if(getExtensionDotIndex()<0||compareSlashIndexAndDotIndex()){
            return"";
        }else return filePath.substring(getExtensionDotIndex()+1);
    }

    private boolean compareSlashIndexAndDotIndex(){
        return getLastIndexOfSlash(filePath)>=0 && getLastIndexOfSlash(filePath)+1==getExtensionDotIndex();
    }

    private int getExtensionDotIndex(){
        return filePath.lastIndexOf(".");
    }

    @Override
    public String toString() {
        return  filePath;
    }
}
