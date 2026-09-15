package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConsentAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.ConsentAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConsentAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ConsentAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConsentAcknowledgement.class)
public class ConsentAcknowledgementMeta implements RosettaMetaData<ConsentAcknowledgement> {

	@Override
	public List<Validator<? super ConsentAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ConsentAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConsentAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<ConsentAcknowledgement>create(ConsentAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super ConsentAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConsentAcknowledgement>create(ConsentAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConsentAcknowledgement> validator() {
		return new ConsentAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConsentAcknowledgement> typeFormatValidator() {
		return new ConsentAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ConsentAcknowledgementOnlyExistsValidator();
	}
}
