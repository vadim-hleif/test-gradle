package test;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-04T22:45:55+0500",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class MapperDtoImpl implements MapperDto {

    @Override
    public Dto2 map(Dto dto) {
        if ( dto == null ) {
            return null;
        }

        Dto2 dto2 = new Dto2();

        dto2.setName( dto.getName() );

        return dto2;
    }
}
