package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.FinancialSwapLeg;
import fpml.consolidated.com.validation.FinancialSwapLegTypeFormatValidator;
import fpml.consolidated.com.validation.FinancialSwapLegValidator;
import fpml.consolidated.com.validation.exists.FinancialSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FinancialSwapLeg.class)
public class FinancialSwapLegMeta implements RosettaMetaData<FinancialSwapLeg> {

	@Override
	public List<Validator<? super FinancialSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FinancialSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinancialSwapLeg> validator(ValidatorFactory factory) {
		return factory.<FinancialSwapLeg>create(FinancialSwapLegValidator.class);
	}

	@Override
	public Validator<? super FinancialSwapLeg> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinancialSwapLeg>create(FinancialSwapLegTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinancialSwapLeg> validator() {
		return new FinancialSwapLegValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FinancialSwapLeg> typeFormatValidator() {
		return new FinancialSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinancialSwapLeg, Set<String>> onlyExistsValidator() {
		return new FinancialSwapLegOnlyExistsValidator();
	}
}
