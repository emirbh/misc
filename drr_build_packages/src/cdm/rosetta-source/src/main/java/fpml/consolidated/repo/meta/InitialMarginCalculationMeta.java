package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.InitialMarginCalculation;
import fpml.consolidated.repo.validation.InitialMarginCalculationTypeFormatValidator;
import fpml.consolidated.repo.validation.InitialMarginCalculationValidator;
import fpml.consolidated.repo.validation.datarule.InitialMarginCalculationChoice;
import fpml.consolidated.repo.validation.exists.InitialMarginCalculationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InitialMarginCalculation.class)
public class InitialMarginCalculationMeta implements RosettaMetaData<InitialMarginCalculation> {

	@Override
	public List<Validator<? super InitialMarginCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<InitialMarginCalculation>create(InitialMarginCalculationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super InitialMarginCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InitialMarginCalculation> validator(ValidatorFactory factory) {
		return factory.<InitialMarginCalculation>create(InitialMarginCalculationValidator.class);
	}

	@Override
	public Validator<? super InitialMarginCalculation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InitialMarginCalculation>create(InitialMarginCalculationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InitialMarginCalculation> validator() {
		return new InitialMarginCalculationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InitialMarginCalculation> typeFormatValidator() {
		return new InitialMarginCalculationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InitialMarginCalculation, Set<String>> onlyExistsValidator() {
		return new InitialMarginCalculationOnlyExistsValidator();
	}
}
