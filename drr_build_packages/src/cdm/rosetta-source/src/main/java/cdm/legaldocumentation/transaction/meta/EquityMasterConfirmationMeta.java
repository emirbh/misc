package cdm.legaldocumentation.transaction.meta;

import cdm.legaldocumentation.transaction.EquityMasterConfirmation;
import cdm.legaldocumentation.transaction.validation.EquityMasterConfirmationTypeFormatValidator;
import cdm.legaldocumentation.transaction.validation.EquityMasterConfirmationValidator;
import cdm.legaldocumentation.transaction.validation.exists.EquityMasterConfirmationOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=EquityMasterConfirmation.class)
public class EquityMasterConfirmationMeta implements RosettaMetaData<EquityMasterConfirmation> {

	@Override
	public List<Validator<? super EquityMasterConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquityMasterConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquityMasterConfirmation> validator(ValidatorFactory factory) {
		return factory.<EquityMasterConfirmation>create(EquityMasterConfirmationValidator.class);
	}

	@Override
	public Validator<? super EquityMasterConfirmation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EquityMasterConfirmation>create(EquityMasterConfirmationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EquityMasterConfirmation> validator() {
		return new EquityMasterConfirmationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EquityMasterConfirmation> typeFormatValidator() {
		return new EquityMasterConfirmationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EquityMasterConfirmation, Set<String>> onlyExistsValidator() {
		return new EquityMasterConfirmationOnlyExistsValidator();
	}
}
