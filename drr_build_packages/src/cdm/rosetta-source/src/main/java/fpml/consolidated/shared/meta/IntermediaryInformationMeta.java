package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.IntermediaryInformation;
import fpml.consolidated.shared.validation.IntermediaryInformationTypeFormatValidator;
import fpml.consolidated.shared.validation.IntermediaryInformationValidator;
import fpml.consolidated.shared.validation.datarule.IntermediaryInformationChoice;
import fpml.consolidated.shared.validation.exists.IntermediaryInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IntermediaryInformation.class)
public class IntermediaryInformationMeta implements RosettaMetaData<IntermediaryInformation> {

	@Override
	public List<Validator<? super IntermediaryInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<IntermediaryInformation>create(IntermediaryInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super IntermediaryInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IntermediaryInformation> validator(ValidatorFactory factory) {
		return factory.<IntermediaryInformation>create(IntermediaryInformationValidator.class);
	}

	@Override
	public Validator<? super IntermediaryInformation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IntermediaryInformation>create(IntermediaryInformationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IntermediaryInformation> validator() {
		return new IntermediaryInformationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IntermediaryInformation> typeFormatValidator() {
		return new IntermediaryInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IntermediaryInformation, Set<String>> onlyExistsValidator() {
		return new IntermediaryInformationOnlyExistsValidator();
	}
}
