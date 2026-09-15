package fpml.consolidated.clearing.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.clearing.processes.ClearingEligibilityAcknowledgement;
import fpml.consolidated.clearing.processes.validation.ClearingEligibilityAcknowledgementTypeFormatValidator;
import fpml.consolidated.clearing.processes.validation.ClearingEligibilityAcknowledgementValidator;
import fpml.consolidated.clearing.processes.validation.exists.ClearingEligibilityAcknowledgementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingEligibilityAcknowledgement.class)
public class ClearingEligibilityAcknowledgementMeta implements RosettaMetaData<ClearingEligibilityAcknowledgement> {

	@Override
	public List<Validator<? super ClearingEligibilityAcknowledgement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ClearingEligibilityAcknowledgement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingEligibilityAcknowledgement> validator(ValidatorFactory factory) {
		return factory.<ClearingEligibilityAcknowledgement>create(ClearingEligibilityAcknowledgementValidator.class);
	}

	@Override
	public Validator<? super ClearingEligibilityAcknowledgement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingEligibilityAcknowledgement>create(ClearingEligibilityAcknowledgementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingEligibilityAcknowledgement> validator() {
		return new ClearingEligibilityAcknowledgementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingEligibilityAcknowledgement> typeFormatValidator() {
		return new ClearingEligibilityAcknowledgementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingEligibilityAcknowledgement, Set<String>> onlyExistsValidator() {
		return new ClearingEligibilityAcknowledgementOnlyExistsValidator();
	}
}
