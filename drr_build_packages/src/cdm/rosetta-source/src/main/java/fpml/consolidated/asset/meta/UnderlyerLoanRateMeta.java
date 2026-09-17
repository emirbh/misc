package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.UnderlyerLoanRate;
import fpml.consolidated.asset.validation.UnderlyerLoanRateTypeFormatValidator;
import fpml.consolidated.asset.validation.UnderlyerLoanRateValidator;
import fpml.consolidated.asset.validation.exists.UnderlyerLoanRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UnderlyerLoanRate.class)
public class UnderlyerLoanRateMeta implements RosettaMetaData<UnderlyerLoanRate> {

	@Override
	public List<Validator<? super UnderlyerLoanRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnderlyerLoanRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnderlyerLoanRate> validator(ValidatorFactory factory) {
		return factory.<UnderlyerLoanRate>create(UnderlyerLoanRateValidator.class);
	}

	@Override
	public Validator<? super UnderlyerLoanRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnderlyerLoanRate>create(UnderlyerLoanRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyerLoanRate> validator() {
		return new UnderlyerLoanRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnderlyerLoanRate> typeFormatValidator() {
		return new UnderlyerLoanRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnderlyerLoanRate, Set<String>> onlyExistsValidator() {
		return new UnderlyerLoanRateOnlyExistsValidator();
	}
}
