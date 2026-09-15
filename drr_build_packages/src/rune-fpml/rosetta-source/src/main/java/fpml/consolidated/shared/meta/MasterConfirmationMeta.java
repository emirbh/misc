package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MasterConfirmation;
import fpml.consolidated.shared.validation.MasterConfirmationTypeFormatValidator;
import fpml.consolidated.shared.validation.MasterConfirmationValidator;
import fpml.consolidated.shared.validation.exists.MasterConfirmationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MasterConfirmation.class)
public class MasterConfirmationMeta implements RosettaMetaData<MasterConfirmation> {

	@Override
	public List<Validator<? super MasterConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterConfirmation> validator(ValidatorFactory factory) {
		return factory.<MasterConfirmation>create(MasterConfirmationValidator.class);
	}

	@Override
	public Validator<? super MasterConfirmation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterConfirmation>create(MasterConfirmationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterConfirmation> validator() {
		return new MasterConfirmationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterConfirmation> typeFormatValidator() {
		return new MasterConfirmationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterConfirmation, Set<String>> onlyExistsValidator() {
		return new MasterConfirmationOnlyExistsValidator();
	}
}
