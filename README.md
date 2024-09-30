## aag
A simple single-class ASCII image generator.

### How to use
Place the Aag.java class inside your project folder and call the `.write` method passing the file path and output path as arguments.

Usage example:
```java
public class App{
    public static void main(String[] args){
        String filePath = "/home/user/Images/my_image.png";
        String outputPath = "/home/user/Documents/ASCII/";

        Aag.write(filePath, outputPath);
    }
}
```
#### Important
I highly recommend to use the absolute path for both filepath and outputpath.