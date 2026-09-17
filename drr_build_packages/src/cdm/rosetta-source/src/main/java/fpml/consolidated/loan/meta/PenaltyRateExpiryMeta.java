package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.PenaltyRateExpiry;
import fpml.consolidated.loan.validation.PenaltyRateExpiryTypeFormatValidator;
import fpml.consolidated.loan.validation.PenaltyRateExpiryValidator;
import fpml.consolidated.loan.validation.exists.PenaltyRateExpiryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PenaltyRateExpiry.class)
public class PenaltyRateExpiryMeta implements RosettaMetaData<PenaltyRateExpiry> {

	@Override
	public List<Validator<? super PenaltyRateExpiry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PenaltyRateExpiry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PenaltyRateExpiry> validator(ValidatorFactory factory) {
		return factory.<PenaltyRateExpiry>create(PenaltyRateExpiryValidator.class);
	}

	@Override
	public Validator<? super PenaltyRateExpiry> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PenaltyRateExpiry>create(PenaltyRateExpiryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PenaltyRateExpiry> validator() {
		return new PenaltyRateExpiryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PenaltyRateExpiry> typeFormatValidator() {
		return new PenaltyRateExpiryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PenaltyRateExpiry, Set<String>> onlyExistsValidator() {
		return new PenaltyRateExpiryOnlyExistsValidator();
	}
}
