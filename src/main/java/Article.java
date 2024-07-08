public record Article(
        String title,
        String link,
        String lede,
        String press,
        String topic
){

    @Override
    public String toString(){
     return "%s : %s (%s)".formatted(press, title, link);
    }
}
