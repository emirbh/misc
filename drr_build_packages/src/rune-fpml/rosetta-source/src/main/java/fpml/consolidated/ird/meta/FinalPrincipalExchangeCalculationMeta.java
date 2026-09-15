package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.FinalPrincipalExchangeCalculation;
import fpml.consolidated.ird.validation.FinalPrincipalExchangeCalculationTypeFormatValidator;
import fpml.consolidated.ird.validation.FinalPrincipalExchangeCalculationValidator;
import fpml.consolidated.ird.validation.exists.FinalPrincipalExchangeCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FinalPrincipalExchangeCalculation.class)
public class FinalPrincipalExchangeCalculationMeta implements RosettaMetaData<FinalPrincipalExchangeCalculation> {

	@Override
	public List<Validator<? super FinalPrincipalExchangeCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FinalPrincipalExchangeCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FinalPrincipalExchangeCalculation> validator(ValidatorFactory factory) {
		return factory.<FinalPrincipalExchangeCalculation>create(FinalPrincipalExchangeCalculationValidator.class);
	}

	@Override
	public Validator<? super FinalPrincipalExchangeCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FinalPrincipalExchangeCalculation>create(FinalPrincipalExchangeCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FinalPrincipalExchangeCalculation> validator() {
		return new FinalPrincipalExchangeCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FinalPrincipalExchangeCalculation> typeFormatValidator() {
		return new FinalPrincipalExchangeCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FinalPrincipalExchangeCalculation, Set<String>> onlyExistsValidator() {
		return new FinalPrincipalExchangeCalculationOnlyExistsValidator();
	}
}
