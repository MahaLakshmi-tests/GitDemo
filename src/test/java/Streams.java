import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

        //count number of names start with alphabet 'A' in list
        @Test
        public void regular() {
            ArrayList<String> names = new ArrayList<String>();
            names.add("Akhil");
            names.add("Lakshmi");
            names.add("Anusha");
            names.add("Devansh");
            names.add("Ashutosh");
            int count=0;
            for(int i=0;i<names.size();i++){
                String actual=names.get(i);
                if(actual.startsWith("A")){
                    count++;
                }
            }
            System.out.println(count);

        }

        @Test
        public void streamFilter(){
            ArrayList<String> names = new ArrayList<String>();
            names.add("Akhil");
            names.add("Lakshmi");
            names.add("Anusha");
            names.add("Devansh");
            names.add("Ashutosh");
            Long c=names.stream().filter(s->s.startsWith("A")).count();
            System.out.println(c);
            //print names in list with lenth>4
            names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
            //print first name from list
            names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));

        }

        @Test
        public void streamMap(){
            //print names which has last letter as i with uppercase
            Stream.of("Akhil","Lakshmi","Devansh").filter(s->s.endsWith("i")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
           //print names which has first letter as A with uppercase and sort
            List<String> names= Arrays.asList("Akhil","Lakshmi","Anusha","Devansh");
            names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

            List<String> names1= Arrays.asList("Maha","Kumar","Reddy");
            names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

            //merge two lists
            Stream<String> newStream=Stream.concat(names.stream(),names1.stream());
            //newStream.forEach(s->System.out.println(s));
            boolean value=newStream.anyMatch(s->s.equalsIgnoreCase("Kumars"));
            System.out.println(value);
            Assert.assertTrue(value);
        }

        @Test
        public void streamCollect(){
            List<String> list=Stream.of("Akhil","Akshmi").filter(s->s.startsWith("A")).map(s->s.toUpperCase())
                    .collect(Collectors.toList());
            System.out.println(list.get(0));

            //print distinct elements in sorted manner and get 3rd index
            List<Integer> values=Stream.of(3,2,2,7,5,1,9,7).distinct().sorted().collect(Collectors.toList());
            System.out.println(values);
            System.out.println(values.get(2));
        }
    }


