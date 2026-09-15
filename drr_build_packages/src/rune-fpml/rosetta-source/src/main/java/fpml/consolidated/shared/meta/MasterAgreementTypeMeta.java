package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.MasterAgreementType;
import fpml.consolidated.shared.validation.MasterAgreementTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.MasterAgreementTypeValidator;
import fpml.consolidated.shared.validation.exists.MasterAgreementTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MasterAgreementType.class)
public class MasterAgreementTypeMeta implements RosettaMetaData<MasterAgreementType> {

	@Override
	public List<Validator<? super MasterAgreementType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreementType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreementType> validator(ValidatorFactory factory) {
		return factory.<MasterAgreementType>create(MasterAgreementTypeValidator.class);
	}

	@Override
	public Validator<? super MasterAgreementType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MasterAgreementType>create(MasterAgreementTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementType> validator() {
		return new MasterAgreementTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MasterAgreementType> typeFormatValidator() {
		return new MasterAgreementTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreementType, Set<String>> onlyExistsValidator() {
		return new MasterAgreementTypeOnlyExistsValidator();
	}
}
