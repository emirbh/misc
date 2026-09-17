package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.product.asset.SpreadSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import fpml.consolidated.shared.Leg;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapSpreadScheduleWithAddress.MapSpreadScheduleWithAddressDefault.class)
public abstract class MapSpreadScheduleWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreatePriceKey createPriceKey;
	@Inject protected CreatePriceWithAddress createPriceWithAddress;

	/**
	* @param fpmlSpreadScheduleList 
	* @param fpmlLeg 
	* @return spreadSchedule 
	*/
	public SpreadSchedule evaluate(List<? extends fpml.consolidated.shared.SpreadSchedule> fpmlSpreadScheduleList, Leg fpmlLeg) {
		SpreadSchedule.SpreadScheduleBuilder spreadScheduleBuilder = doEvaluate(fpmlSpreadScheduleList, fpmlLeg);
		
		final SpreadSchedule spreadSchedule;
		if (spreadScheduleBuilder == null) {
			spreadSchedule = null;
		} else {
			spreadSchedule = spreadScheduleBuilder.build();
			objectValidator.validate(SpreadSchedule.class, spreadSchedule);
		}
		
		return spreadSchedule;
	}

	protected abstract SpreadSchedule.SpreadScheduleBuilder doEvaluate(List<? extends fpml.consolidated.shared.SpreadSchedule> fpmlSpreadScheduleList, Leg fpmlLeg);

	public static class MapSpreadScheduleWithAddressDefault extends MapSpreadScheduleWithAddress {
		@Override
		protected SpreadSchedule.SpreadScheduleBuilder doEvaluate(List<? extends fpml.consolidated.shared.SpreadSchedule> fpmlSpreadScheduleList, Leg fpmlLeg) {
			if (fpmlSpreadScheduleList == null) {
				fpmlSpreadScheduleList = Collections.emptyList();
			}
			SpreadSchedule.SpreadScheduleBuilder spreadSchedule = SpreadSchedule.builder();
			return assignOutput(spreadSchedule, fpmlSpreadScheduleList, fpmlLeg);
		}
		
		protected SpreadSchedule.SpreadScheduleBuilder assignOutput(SpreadSchedule.SpreadScheduleBuilder spreadSchedule, List<? extends fpml.consolidated.shared.SpreadSchedule> fpmlSpreadScheduleList, Leg fpmlLeg) {
			if (exists(MapperC.<fpml.consolidated.shared.SpreadSchedule>of(fpmlSpreadScheduleList)).getOrDefault(false)) {
				spreadSchedule = toBuilder(SpreadSchedule.builder()
					.setPrice(createPriceWithAddress.evaluate(createPriceKey.evaluate("spreadSchedule", fpmlLeg)))
					.build());
			} else {
				spreadSchedule = null;
			}
			
			return Optional.ofNullable(spreadSchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
