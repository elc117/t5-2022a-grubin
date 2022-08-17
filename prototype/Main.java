package prototype;

public class Main {
    public static void main(String[] args) {

        SlidePresentationDocument slide1 = new SlidePresentationDocument("Texto Slide 1", 5);

        SlidePresentationDocument slide2 = (SlidePresentationDocument) slide1.clonar();
        System.out.println(slide2.text);

        TextDocument text1 = new TextDocument("Texto 1", 7);

        TextDocument textcopy = (TextDocument) text1.clonar();
        System.out.println(textcopy.text);

        System.out.println(textcopy.pags);
    }
}
