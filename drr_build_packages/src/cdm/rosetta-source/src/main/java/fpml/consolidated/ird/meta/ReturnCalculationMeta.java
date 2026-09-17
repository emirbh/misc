package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ReturnCalculation;
import fpml.consolidated.ird.validation.ReturnCalculationTypeFormatValidator;
import fpml.consolidated.ird.validation.ReturnCalculationValidator;
import fpml.consolidated.ird.validation.exists.ReturnCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReturnCalculation.class)
public class ReturnCalculationMeta implements RosettaMetaData<ReturnCalculation> {

	@Override
	public List<Validator<? super ReturnCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnCalculation> validator(ValidatorFactory factory) {
		return factory.<ReturnCalculation>create(ReturnCalculationValidator.class);
	}

	@Override
	public Validator<? super ReturnCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReturnCalculation>create(ReturnCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReturnCalculation> validator() {
		return new ReturnCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReturnCalculation> typeFormatValidator() {
		return new ReturnCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnCalculation, Set<String>> onlyExistsValidator() {
		return new ReturnCalculationOnlyExistsValidator();
	}
}
