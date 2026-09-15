package fpml.consolidated.sec.lending.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.sec.lending.SecLendRebateCalculation;
import fpml.consolidated.sec.lending.validation.SecLendRebateCalculationTypeFormatValidator;
import fpml.consolidated.sec.lending.validation.SecLendRebateCalculationValidator;
import fpml.consolidated.sec.lending.validation.datarule.SecLendRebateCalculationChoice;
import fpml.consolidated.sec.lending.validation.exists.SecLendRebateCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SecLendRebateCalculation.class)
public class SecLendRebateCalculationMeta implements RosettaMetaData<SecLendRebateCalculation> {

	@Override
	public List<Validator<? super SecLendRebateCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SecLendRebateCalculation>create(SecLendRebateCalculationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SecLendRebateCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecLendRebateCalculation> validator(ValidatorFactory factory) {
		return factory.<SecLendRebateCalculation>create(SecLendRebateCalculationValidator.class);
	}

	@Override
	public Validator<? super SecLendRebateCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SecLendRebateCalculation>create(SecLendRebateCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SecLendRebateCalculation> validator() {
		return new SecLendRebateCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SecLendRebateCalculation> typeFormatValidator() {
		return new SecLendRebateCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecLendRebateCalculation, Set<String>> onlyExistsValidator() {
		return new SecLendRebateCalculationOnlyExistsValidator();
	}
}
