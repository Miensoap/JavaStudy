package Mordern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Modern_3<T>{
    public Modern_3() throws IOException {
    }

    public String processFile(BufferedReaderProcessor p) throws IOException{
        try (BufferedReader br =
                new BufferedReader(new FileReader("data.txt"))){
            return p.process(br);
        }
    }
    String oneLine = processFile(BufferedReader::readLine);
    // 메소드 참조
    String twoLine = processFile((BufferedReader br) ->
            br.readLine() + br.readLine());
    // 람다 전달

    public <T> void forEach(List<T> list, Consumer<T> c){
        for(T t : list){
            c.accept(t);
        }
    }

}


@FunctionalInterface
interface BufferedReaderProcessor{
    String process(BufferedReader b) throws IOException;
}

@FunctionalInterface
interface Consumer<T>{
    void accept(T t);
}