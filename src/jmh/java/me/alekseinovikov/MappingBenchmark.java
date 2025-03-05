package me.alekseinovikov;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.googlecode.jmapper.JMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.modelmapper.ModelMapper;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class MappingBenchmark {

    private final Entity entity = new Entity(1L, "name", "description", 1, true, 1.0);

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final JMapper<Dto, Entity> jMapper = new JMapper<>(Dto.class, Entity.class);
    private final Mapper dozerMapper = DozerBeanMapperBuilder.buildDefault();
    private final MapperFactory orikaMapperFactory = new DefaultMapperFactory.Builder().build();
    private final ModelMapper modelMapper = new ModelMapper();
    private final MapperFacade orikaMapper;

    {
        orikaMapperFactory.classMap(Entity.class, Dto.class)
                .field("id", "id")
                .field("name", "name")
                .field("description", "description")
                .field("number", "number")
                .field("flag", "flag")
                .field("price", "price")
                .byDefault()
                .register();
        orikaMapper = orikaMapperFactory.getMapperFacade();
    }

    @Benchmark
    public void mapStruct() {
        final Dto result = MapstructMapper.INSTANCE.map(entity);
        if (!result.equals(entity)) {
            throw new IllegalStateException("Invalid mapping");
        }
    }

    @Benchmark
    public void jacksonObjectMapper() {
        final Dto result = objectMapper.convertValue(entity, Dto.class);
        if (!result.equals(entity)) {
            throw new IllegalStateException("Invalid mapping");
        }
    }

    @Benchmark
    public void jMapper() {
        final Dto result = jMapper.getDestination(entity);
        if (!result.equals(entity)) {
            throw new IllegalStateException("Invalid mapping");
        }
    }

    @Benchmark
    public void dozer() {
        final Dto result = dozerMapper.map(entity, Dto.class);
        if (!result.equals(entity)) {
            throw new IllegalStateException("Invalid mapping");
        }
    }

    @Benchmark
    public void orika() {
        final Dto result = orikaMapper.map(entity, Dto.class);
        if (!result.equals(entity)) {
            throw new IllegalStateException("Invalid mapping");
        }
    }

    @Benchmark
    public void modelMapper() {
        final Dto result = modelMapper.map(entity, Dto.class);
        if (!result.equals(entity)) {
            throw new IllegalStateException("Invalid mapping");
        }
    }

}
