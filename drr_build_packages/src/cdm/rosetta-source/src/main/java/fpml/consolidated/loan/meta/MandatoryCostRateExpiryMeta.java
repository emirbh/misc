package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MandatoryCostRateExpiry;
import fpml.consolidated.loan.validation.MandatoryCostRateExpiryTypeFormatValidator;
import fpml.consolidated.loan.validation.MandatoryCostRateExpiryValidator;
import fpml.consolidated.loan.validation.exists.MandatoryCostRateExpiryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MandatoryCostRateExpiry.class)
public class MandatoryCostRateExpiryMeta implements RosettaMetaData<MandatoryCostRateExpiry> {

	@Override
	public List<Validator<? super MandatoryCostRateExpiry>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MandatoryCostRateExpiry, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MandatoryCostRateExpiry> validator(ValidatorFactory factory) {
		return factory.<MandatoryCostRateExpiry>create(MandatoryCostRateExpiryValidator.class);
	}

	@Override
	public Validator<? super MandatoryCostRateExpiry> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MandatoryCostRateExpiry>create(MandatoryCostRateExpiryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryCostRateExpiry> validator() {
		return new MandatoryCostRateExpiryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryCostRateExpiry> typeFormatValidator() {
		return new MandatoryCostRateExpiryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryCostRateExpiry, Set<String>> onlyExistsValidator() {
		return new MandatoryCostRateExpiryOnlyExistsValidator();
	}
}
