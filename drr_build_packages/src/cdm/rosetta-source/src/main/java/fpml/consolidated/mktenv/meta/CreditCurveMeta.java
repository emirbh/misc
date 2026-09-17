package fpml.consolidated.mktenv.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.mktenv.CreditCurve;
import fpml.consolidated.mktenv.validation.CreditCurveTypeFormatValidator;
import fpml.consolidated.mktenv.validation.CreditCurveValidator;
import fpml.consolidated.mktenv.validation.datarule.CreditCurveChoice;
import fpml.consolidated.mktenv.validation.exists.CreditCurveOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditCurve.class)
public class CreditCurveMeta implements RosettaMetaData<CreditCurve> {

	@Override
	public List<Validator<? super CreditCurve>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditCurve>create(CreditCurveChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditCurve, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditCurve> validator(ValidatorFactory factory) {
		return factory.<CreditCurve>create(CreditCurveValidator.class);
	}

	@Override
	public Validator<? super CreditCurve> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditCurve>create(CreditCurveTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditCurve> validator() {
		return new CreditCurveValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditCurve> typeFormatValidator() {
		return new CreditCurveTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditCurve, Set<String>> onlyExistsValidator() {
		return new CreditCurveOnlyExistsValidator();
	}
}
