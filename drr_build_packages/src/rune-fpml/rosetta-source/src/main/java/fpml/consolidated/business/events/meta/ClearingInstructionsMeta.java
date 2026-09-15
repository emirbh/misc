package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ClearingInstructions;
import fpml.consolidated.business.events.validation.ClearingInstructionsTypeFormatValidator;
import fpml.consolidated.business.events.validation.ClearingInstructionsValidator;
import fpml.consolidated.business.events.validation.exists.ClearingInstructionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingInstructions.class)
public class ClearingInstructionsMeta implements RosettaMetaData<ClearingInstructions> {

	@Override
	public List<Validator<? super ClearingInstructions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingInstructions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingInstructions> validator(ValidatorFactory factory) {
		return factory.<ClearingInstructions>create(ClearingInstructionsValidator.class);
	}

	@Override
	public Validator<? super ClearingInstructions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingInstructions>create(ClearingInstructionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingInstructions> validator() {
		return new ClearingInstructionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingInstructions> typeFormatValidator() {
		return new ClearingInstructionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingInstructions, Set<String>> onlyExistsValidator() {
		return new ClearingInstructionsOnlyExistsValidator();
	}
}
