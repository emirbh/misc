package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PenaltyRateChange;
import fpml.consolidated.loan.validation.PenaltyRateChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.PenaltyRateChangeValidator;
import fpml.consolidated.loan.validation.exists.PenaltyRateChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PenaltyRateChange.class)
public class PenaltyRateChangeMeta implements RosettaMetaData<PenaltyRateChange> {

	@Override
	public List<Validator<? super PenaltyRateChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PenaltyRateChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PenaltyRateChange> validator(ValidatorFactory factory) {
		return factory.<PenaltyRateChange>create(PenaltyRateChangeValidator.class);
	}

	@Override
	public Validator<? super PenaltyRateChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PenaltyRateChange>create(PenaltyRateChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PenaltyRateChange> validator() {
		return new PenaltyRateChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PenaltyRateChange> typeFormatValidator() {
		return new PenaltyRateChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PenaltyRateChange, Set<String>> onlyExistsValidator() {
		return new PenaltyRateChangeOnlyExistsValidator();
	}
}
