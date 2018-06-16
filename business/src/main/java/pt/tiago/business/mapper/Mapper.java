package pt.tiago.business.mapper;

/**
 * Created by Tiago Vilas Boas on 15/06/2018.
 */
public interface Mapper<IN,OUT> {

    OUT map(IN in);
}
