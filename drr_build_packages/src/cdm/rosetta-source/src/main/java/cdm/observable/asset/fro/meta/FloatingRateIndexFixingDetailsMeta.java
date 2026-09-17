package cdm.observable.asset.fro.meta;

import cdm.observable.asset.fro.FloatingRateIndexFixingDetails;
import cdm.observable.asset.fro.validation.FloatingRateIndexFixingDetailsTypeFormatValidator;
import cdm.observable.asset.fro.validation.FloatingRateIndexFixingDetailsValidator;
import cdm.observable.asset.fro.validation.exists.FloatingRateIndexFixingDetailsOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=FloatingRateIndexFixingDetails.class)
public class FloatingRateIndexFixingDetailsMeta implements RosettaMetaData<FloatingRateIndexFixingDetails> {

	@Override
	public List<Validator<? super FloatingRateIndexFixingDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexFixingDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndexFixingDetails> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexFixingDetails>create(FloatingRateIndexFixingDetailsValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndexFixingDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexFixingDetails>create(FloatingRateIndexFixingDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexFixingDetails> validator() {
		return new FloatingRateIndexFixingDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexFixingDetails> typeFormatValidator() {
		return new FloatingRateIndexFixingDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexFixingDetails, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexFixingDetailsOnlyExistsValidator();
	}
}
