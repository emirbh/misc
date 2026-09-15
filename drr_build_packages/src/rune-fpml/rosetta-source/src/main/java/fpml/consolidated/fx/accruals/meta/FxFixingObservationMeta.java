package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxFixingObservation;
import fpml.consolidated.fx.accruals.validation.FxFixingObservationTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxFixingObservationValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxFixingObservationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFixingObservation.class)
public class FxFixingObservationMeta implements RosettaMetaData<FxFixingObservation> {

	@Override
	public List<Validator<? super FxFixingObservation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxFixingObservation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFixingObservation> validator(ValidatorFactory factory) {
		return factory.<FxFixingObservation>create(FxFixingObservationValidator.class);
	}

	@Override
	public Validator<? super FxFixingObservation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFixingObservation>create(FxFixingObservationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingObservation> validator() {
		return new FxFixingObservationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingObservation> typeFormatValidator() {
		return new FxFixingObservationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingObservation, Set<String>> onlyExistsValidator() {
		return new FxFixingObservationOnlyExistsValidator();
	}
}
