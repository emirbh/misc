package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ResetCalculationElements;
import fpml.consolidated.business.events.validation.ResetCalculationElementsTypeFormatValidator;
import fpml.consolidated.business.events.validation.ResetCalculationElementsValidator;
import fpml.consolidated.business.events.validation.exists.ResetCalculationElementsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ResetCalculationElements.class)
public class ResetCalculationElementsMeta implements RosettaMetaData<ResetCalculationElements> {

	@Override
	public List<Validator<? super ResetCalculationElements>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResetCalculationElements, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResetCalculationElements> validator(ValidatorFactory factory) {
		return factory.<ResetCalculationElements>create(ResetCalculationElementsValidator.class);
	}

	@Override
	public Validator<? super ResetCalculationElements> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ResetCalculationElements>create(ResetCalculationElementsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ResetCalculationElements> validator() {
		return new ResetCalculationElementsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ResetCalculationElements> typeFormatValidator() {
		return new ResetCalculationElementsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResetCalculationElements, Set<String>> onlyExistsValidator() {
		return new ResetCalculationElementsOnlyExistsValidator();
	}
}
