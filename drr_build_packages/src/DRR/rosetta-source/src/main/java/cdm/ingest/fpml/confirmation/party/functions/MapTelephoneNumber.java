package cdm.ingest.fpml.confirmation.party.functions;

import cdm.base.staticdata.party.TelephoneNumber;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.TelephoneTypeEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTelephoneNumber.MapTelephoneNumberDefault.class)
public abstract class MapTelephoneNumber implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlTelephoneNumber 
	* @return cdmTelephoneNumber 
	*/
	public TelephoneNumber evaluate(fpml.consolidated.shared.TelephoneNumber fpmlTelephoneNumber) {
		TelephoneNumber.TelephoneNumberBuilder cdmTelephoneNumberBuilder = doEvaluate(fpmlTelephoneNumber);
		
		final TelephoneNumber cdmTelephoneNumber;
		if (cdmTelephoneNumberBuilder == null) {
			cdmTelephoneNumber = null;
		} else {
			cdmTelephoneNumber = cdmTelephoneNumberBuilder.build();
			objectValidator.validate(TelephoneNumber.class, cdmTelephoneNumber);
		}
		
		return cdmTelephoneNumber;
	}

	protected abstract TelephoneNumber.TelephoneNumberBuilder doEvaluate(fpml.consolidated.shared.TelephoneNumber fpmlTelephoneNumber);

	public static class MapTelephoneNumberDefault extends MapTelephoneNumber {
		@Override
		protected TelephoneNumber.TelephoneNumberBuilder doEvaluate(fpml.consolidated.shared.TelephoneNumber fpmlTelephoneNumber) {
			TelephoneNumber.TelephoneNumberBuilder cdmTelephoneNumber = TelephoneNumber.builder();
			return assignOutput(cdmTelephoneNumber, fpmlTelephoneNumber);
		}
		
		protected TelephoneNumber.TelephoneNumberBuilder assignOutput(TelephoneNumber.TelephoneNumberBuilder cdmTelephoneNumber, fpml.consolidated.shared.TelephoneNumber fpmlTelephoneNumber) {
			cdmTelephoneNumber = toBuilder(TelephoneNumber.builder()
				.setTelephoneNumberType(MapperS.of(fpmlTelephoneNumber).<TelephoneTypeEnum>map("getType", telephoneNumber -> telephoneNumber._getType()).checkedMap("to-enum", e -> cdm.base.staticdata.party.TelephoneTypeEnum.valueOf(e.name()), IllegalArgumentException.class).get())
				.setNumber(MapperS.of(fpmlTelephoneNumber).<String>map("getNumber", telephoneNumber -> telephoneNumber.getNumber()).get())
				.build());
			
			return Optional.ofNullable(cdmTelephoneNumber)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
