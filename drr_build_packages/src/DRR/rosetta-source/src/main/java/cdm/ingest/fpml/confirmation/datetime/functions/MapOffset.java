package cdm.ingest.fpml.confirmation.datetime.functions;

import cdm.base.datetime.Offset;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.DayTypeEnum;
import fpml.consolidated.fpmlenum.PeriodEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOffset.MapOffsetDefault.class)
public abstract class MapOffset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlOffset 
	* @return offset 
	*/
	public Offset evaluate(fpml.consolidated.shared.Offset fpmlOffset) {
		Offset.OffsetBuilder offsetBuilder = doEvaluate(fpmlOffset);
		
		final Offset offset;
		if (offsetBuilder == null) {
			offset = null;
		} else {
			offset = offsetBuilder.build();
			objectValidator.validate(Offset.class, offset);
		}
		
		return offset;
	}

	protected abstract Offset.OffsetBuilder doEvaluate(fpml.consolidated.shared.Offset fpmlOffset);

	public static class MapOffsetDefault extends MapOffset {
		@Override
		protected Offset.OffsetBuilder doEvaluate(fpml.consolidated.shared.Offset fpmlOffset) {
			Offset.OffsetBuilder offset = Offset.builder();
			return assignOutput(offset, fpmlOffset);
		}
		
		protected Offset.OffsetBuilder assignOutput(Offset.OffsetBuilder offset, fpml.consolidated.shared.Offset fpmlOffset) {
			offset = toBuilder(Offset.builder()
				.setPeriodMultiplier(MapperS.of(fpmlOffset).<Integer>map("getPeriodMultiplier", _offset -> _offset.getPeriodMultiplier()).get())
				.setPeriod(MapperS.of(fpmlOffset).<PeriodEnum>map("getPeriod", _offset -> _offset.getPeriod()).checkedMap("to-enum", e -> cdm.base.datetime.PeriodEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDayType(MapperS.of(fpmlOffset).<DayTypeEnum>map("getDayType", _offset -> _offset.getDayType()).checkedMap("to-enum", e -> cdm.base.datetime.DayTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.build());
			
			return Optional.ofNullable(offset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
