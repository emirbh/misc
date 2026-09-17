package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MasterConfirmationAnnexType;
import fpml.consolidated.shared.validation.MasterConfirmationAnnexTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.MasterConfirmationAnnexTypeValidator;
import fpml.consolidated.shared.validation.exists.MasterConfirmationAnnexTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MasterConfirmationAnnexType.class)
public class MasterConfirmationAnnexTypeMeta implements RosettaMetaData<MasterConfirmationAnnexType> {

	@Override
	public List<Validator<? super MasterConfirmationAnnexType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterConfirmationAnnexType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterConfirmationAnnexType> validator(ValidatorFactory factory) {
		return factory.<MasterConfirmationAnnexType>create(MasterConfirmationAnnexTypeValidator.class);
	}

	@Override
	public Validator<? super MasterConfirmationAnnexType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterConfirmationAnnexType>create(MasterConfirmationAnnexTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterConfirmationAnnexType> validator() {
		return new MasterConfirmationAnnexTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterConfirmationAnnexType> typeFormatValidator() {
		return new MasterConfirmationAnnexTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterConfirmationAnnexType, Set<String>> onlyExistsValidator() {
		return new MasterConfirmationAnnexTypeOnlyExistsValidator();
	}
}
