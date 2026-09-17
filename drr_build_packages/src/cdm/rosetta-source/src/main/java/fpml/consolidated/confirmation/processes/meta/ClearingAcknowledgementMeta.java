package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ClearingAcknowledgement;
import fpml.consolidated.confirmation.processes.validation.ClearingAcknowledgementTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ClearingAcknowledgementValidator;
import fpml.consolidated.confirmation.processes.validation.exists.ClearingAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingAcknowledgement.class)
public class ClearingAcknowledgementMeta implements RosettaMetaData<ClearingAcknowledgement> {

	@Override
	public List<Validator<? super ClearingAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<ClearingAcknowledgement>create(ClearingAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super ClearingAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingAcknowledgement>create(ClearingAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingAcknowledgement> validator() {
		return new ClearingAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingAcknowledgement> typeFormatValidator() {
		return new ClearingAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ClearingAcknowledgementOnlyExistsValidator();
	}
}
