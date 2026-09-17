package cdm.legaldocumentation.transaction.meta;

import cdm.legaldocumentation.transaction.MasterConfirmationBase;
import cdm.legaldocumentation.transaction.validation.MasterConfirmationBaseTypeFormatValidator;
import cdm.legaldocumentation.transaction.validation.MasterConfirmationBaseValidator;
import cdm.legaldocumentation.transaction.validation.exists.MasterConfirmationBaseOnlyExistsValidator;
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
@RosettaMeta(model=MasterConfirmationBase.class)
public class MasterConfirmationBaseMeta implements RosettaMetaData<MasterConfirmationBase> {

	@Override
	public List<Validator<? super MasterConfirmationBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterConfirmationBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterConfirmationBase> validator(ValidatorFactory factory) {
		return factory.<MasterConfirmationBase>create(MasterConfirmationBaseValidator.class);
	}

	@Override
	public Validator<? super MasterConfirmationBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterConfirmationBase>create(MasterConfirmationBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterConfirmationBase> validator() {
		return new MasterConfirmationBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterConfirmationBase> typeFormatValidator() {
		return new MasterConfirmationBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterConfirmationBase, Set<String>> onlyExistsValidator() {
		return new MasterConfirmationBaseOnlyExistsValidator();
	}
}
