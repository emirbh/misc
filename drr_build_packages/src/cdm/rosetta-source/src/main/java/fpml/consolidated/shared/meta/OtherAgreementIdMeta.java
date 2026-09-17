package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.OtherAgreementId;
import fpml.consolidated.shared.validation.OtherAgreementIdTypeFormatValidator;
import fpml.consolidated.shared.validation.OtherAgreementIdValidator;
import fpml.consolidated.shared.validation.exists.OtherAgreementIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OtherAgreementId.class)
public class OtherAgreementIdMeta implements RosettaMetaData<OtherAgreementId> {

	@Override
	public List<Validator<? super OtherAgreementId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OtherAgreementId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OtherAgreementId> validator(ValidatorFactory factory) {
		return factory.<OtherAgreementId>create(OtherAgreementIdValidator.class);
	}

	@Override
	public Validator<? super OtherAgreementId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OtherAgreementId>create(OtherAgreementIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OtherAgreementId> validator() {
		return new OtherAgreementIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OtherAgreementId> typeFormatValidator() {
		return new OtherAgreementIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OtherAgreementId, Set<String>> onlyExistsValidator() {
		return new OtherAgreementIdOnlyExistsValidator();
	}
}
