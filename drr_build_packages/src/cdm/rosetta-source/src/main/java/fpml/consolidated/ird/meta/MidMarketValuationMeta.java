package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.MidMarketValuation;
import fpml.consolidated.ird.validation.MidMarketValuationTypeFormatValidator;
import fpml.consolidated.ird.validation.MidMarketValuationValidator;
import fpml.consolidated.ird.validation.datarule.MidMarketValuationChoice;
import fpml.consolidated.ird.validation.exists.MidMarketValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MidMarketValuation.class)
public class MidMarketValuationMeta implements RosettaMetaData<MidMarketValuation> {

	@Override
	public List<Validator<? super MidMarketValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MidMarketValuation>create(MidMarketValuationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super MidMarketValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MidMarketValuation> validator(ValidatorFactory factory) {
		return factory.<MidMarketValuation>create(MidMarketValuationValidator.class);
	}

	@Override
	public Validator<? super MidMarketValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MidMarketValuation>create(MidMarketValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MidMarketValuation> validator() {
		return new MidMarketValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MidMarketValuation> typeFormatValidator() {
		return new MidMarketValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MidMarketValuation, Set<String>> onlyExistsValidator() {
		return new MidMarketValuationOnlyExistsValidator();
	}
}
