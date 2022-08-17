package prototype;

abstract class Document {
    String text;
    int pags;

    public Document() {

    }

    public Document(Document document) {
        this.pags = document.pags;
        this.text = document.text;
    }

    public Document(String text, int pags) {
        this.text = text;
        this.pags = pags;
    }

    abstract Document clonar();
}