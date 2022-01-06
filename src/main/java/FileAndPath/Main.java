package FileAndPath;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello FileAndPath");

        FileAndPath fileAndPath=new FileAndPath("file:///C:/Users/carst/Desktop/SDAcademy/2.Java_Fundamentals/Java_Fundamentals.pdf");
        System.out.println("The path is: "+fileAndPath);
        System.out.println("The parent path is: "+fileAndPath.getParentPath());
        System.out.println("The file name without extension is: "+fileAndPath.getFileName());
        System.out.println("The file extension is: "+fileAndPath.getFileExtension());

//        FileAndPath nullFileAndPath=new FileAndPath(null);
//        System.out.println(nullFileAndPath);

        FileAndPath emptyFileAndPath=new FileAndPath("");
        System.out.println(emptyFileAndPath);




    }
}
