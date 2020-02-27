package test;

public class Main {

    public static void main(String[] args) {

        Dto dto = new Dto();

        dto.setName("sds");


        System.out.println(MapperDto.MAPPER.map(dto).getName());


    }
}
