package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.VersionedLegalActionId;
import fpml.consolidated.loan.validation.VersionedLegalActionIdTypeFormatValidator;
import fpml.consolidated.loan.validation.VersionedLegalActionIdValidator;
import fpml.consolidated.loan.validation.exists.VersionedLegalActionIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=VersionedLegalActionId.class)
public class VersionedLegalActionIdMeta implements RosettaMetaData<VersionedLegalActionId> {

	@Override
	public List<Validator<? super VersionedLegalActionId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VersionedLegalActionId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super VersionedLegalActionId> validator(ValidatorFactory factory) {
		return factory.<VersionedLegalActionId>create(VersionedLegalActionIdValidator.class);
	}

	@Override
	public Validator<? super VersionedLegalActionId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<VersionedLegalActionId>create(VersionedLegalActionIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super VersionedLegalActionId> validator() {
		return new VersionedLegalActionIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super VersionedLegalActionId> typeFormatValidator() {
		return new VersionedLegalActionIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VersionedLegalActionId, Set<String>> onlyExistsValidator() {
		return new VersionedLegalActionIdOnlyExistsValidator();
	}
}
