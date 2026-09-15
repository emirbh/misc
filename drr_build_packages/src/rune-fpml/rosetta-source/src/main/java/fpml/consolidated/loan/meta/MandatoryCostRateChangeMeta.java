package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MandatoryCostRateChange;
import fpml.consolidated.loan.validation.MandatoryCostRateChangeTypeFormatValidator;
import fpml.consolidated.loan.validation.MandatoryCostRateChangeValidator;
import fpml.consolidated.loan.validation.exists.MandatoryCostRateChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MandatoryCostRateChange.class)
public class MandatoryCostRateChangeMeta implements RosettaMetaData<MandatoryCostRateChange> {

	@Override
	public List<Validator<? super MandatoryCostRateChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MandatoryCostRateChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MandatoryCostRateChange> validator(ValidatorFactory factory) {
		return factory.<MandatoryCostRateChange>create(MandatoryCostRateChangeValidator.class);
	}

	@Override
	public Validator<? super MandatoryCostRateChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MandatoryCostRateChange>create(MandatoryCostRateChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryCostRateChange> validator() {
		return new MandatoryCostRateChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryCostRateChange> typeFormatValidator() {
		return new MandatoryCostRateChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryCostRateChange, Set<String>> onlyExistsValidator() {
		return new MandatoryCostRateChangeOnlyExistsValidator();
	}
}
