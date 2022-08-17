package prototype;

public class SlidePresentationDocument extends Document {
    public SlidePresentationDocument(SlidePresentationDocument document) {
        super(document);
        this.pags = document.pags;
        this.text = document.text;
    }

    public SlidePresentationDocument() {
    }

    public SlidePresentationDocument(String text, int pags) {
        super(text, pags);
    }

    @Override
    Document clonar() {
        return new SlidePresentationDocument(this);
    }
}
