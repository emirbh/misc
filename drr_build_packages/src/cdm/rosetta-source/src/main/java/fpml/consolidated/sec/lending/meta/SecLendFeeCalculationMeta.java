package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.SecLendFeeCalculation;
import fpml.consolidated.sec.lending.validation.SecLendFeeCalculationTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.SecLendFeeCalculationValidator;
import fpml.consolidated.sec.lending.validation.datarule.SecLendFeeCalculationChoice;
import fpml.consolidated.sec.lending.validation.exists.SecLendFeeCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecLendFeeCalculation.class)
public class SecLendFeeCalculationMeta implements RosettaMetaData<SecLendFeeCalculation> {

	@Override
	public List<Validator<? super SecLendFeeCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecLendFeeCalculation>create(SecLendFeeCalculationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SecLendFeeCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecLendFeeCalculation> validator(ValidatorFactory factory) {
		return factory.<SecLendFeeCalculation>create(SecLendFeeCalculationValidator.class);
	}

	@Override
	public Validator<? super SecLendFeeCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecLendFeeCalculation>create(SecLendFeeCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecLendFeeCalculation> validator() {
		return new SecLendFeeCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecLendFeeCalculation> typeFormatValidator() {
		return new SecLendFeeCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecLendFeeCalculation, Set<String>> onlyExistsValidator() {
		return new SecLendFeeCalculationOnlyExistsValidator();
	}
}
