package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.OtherAgreementType;
import fpml.consolidated.shared.validation.OtherAgreementTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.OtherAgreementTypeValidator;
import fpml.consolidated.shared.validation.exists.OtherAgreementTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OtherAgreementType.class)
public class OtherAgreementTypeMeta implements RosettaMetaData<OtherAgreementType> {

	@Override
	public List<Validator<? super OtherAgreementType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreementType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherAgreementType> validator(ValidatorFactory factory) {
		return factory.<OtherAgreementType>create(OtherAgreementTypeValidator.class);
	}

	@Override
	public Validator<? super OtherAgreementType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OtherAgreementType>create(OtherAgreementTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OtherAgreementType> validator() {
		return new OtherAgreementTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OtherAgreementType> typeFormatValidator() {
		return new OtherAgreementTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreementType, Set<String>> onlyExistsValidator() {
		return new OtherAgreementTypeOnlyExistsValidator();
	}
}
