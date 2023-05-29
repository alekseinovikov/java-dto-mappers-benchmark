package me.alekseinovikov;

import org.mapstruct.factory.Mappers;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class MappingBenchmark {

    private final Entity entity = new Entity(1L, "name", "description", 1, true, 1.0);

    @Benchmark
    public void mapStruct() {
        final Dto result = MapstructMapper.INSTANCE.map(entity);
        if (!result.getId().equals(entity.getId())) {
            throw new RuntimeException("Invalid mapping");
        }
    }

}
