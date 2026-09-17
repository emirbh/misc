package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualStrikeReference;
import fpml.consolidated.fx.accruals.validation.FxAccrualStrikeReferenceTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualStrikeReferenceValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualStrikeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualStrikeReference.class)
public class FxAccrualStrikeReferenceMeta implements RosettaMetaData<FxAccrualStrikeReference> {

	@Override
	public List<Validator<? super FxAccrualStrikeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualStrikeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualStrikeReference> validator(ValidatorFactory factory) {
		return factory.<FxAccrualStrikeReference>create(FxAccrualStrikeReferenceValidator.class);
	}

	@Override
	public Validator<? super FxAccrualStrikeReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualStrikeReference>create(FxAccrualStrikeReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualStrikeReference> validator() {
		return new FxAccrualStrikeReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualStrikeReference> typeFormatValidator() {
		return new FxAccrualStrikeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualStrikeReference, Set<String>> onlyExistsValidator() {
		return new FxAccrualStrikeReferenceOnlyExistsValidator();
	}
}
