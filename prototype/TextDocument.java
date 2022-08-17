package prototype;

public class TextDocument extends Document {
    public TextDocument(TextDocument document) {
        super(document);
        this.pags = document.pags;
        this.text = document.text;
    }

    public TextDocument() {

    }

    @Override
    Document clonar() {
        return new TextDocument(this);
    }

    public TextDocument(String text, int pags) {
        super(text, pags);
    }
}
