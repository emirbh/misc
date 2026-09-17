package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.CreditCurveValuation;
import fpml.consolidated.mktenv.validation.CreditCurveValuationTypeFormatValidator;
import fpml.consolidated.mktenv.validation.CreditCurveValuationValidator;
import fpml.consolidated.mktenv.validation.datarule.CreditCurveValuationChoice;
import fpml.consolidated.mktenv.validation.exists.CreditCurveValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditCurveValuation.class)
public class CreditCurveValuationMeta implements RosettaMetaData<CreditCurveValuation> {

	@Override
	public List<Validator<? super CreditCurveValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditCurveValuation>create(CreditCurveValuationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditCurveValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditCurveValuation> validator(ValidatorFactory factory) {
		return factory.<CreditCurveValuation>create(CreditCurveValuationValidator.class);
	}

	@Override
	public Validator<? super CreditCurveValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditCurveValuation>create(CreditCurveValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditCurveValuation> validator() {
		return new CreditCurveValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditCurveValuation> typeFormatValidator() {
		return new CreditCurveValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditCurveValuation, Set<String>> onlyExistsValidator() {
		return new CreditCurveValuationOnlyExistsValidator();
	}
}
