package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualAverageStrikeReference;
import fpml.consolidated.fx.accruals.validation.FxAccrualAverageStrikeReferenceTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualAverageStrikeReferenceValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualAverageStrikeReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualAverageStrikeReference.class)
public class FxAccrualAverageStrikeReferenceMeta implements RosettaMetaData<FxAccrualAverageStrikeReference> {

	@Override
	public List<Validator<? super FxAccrualAverageStrikeReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualAverageStrikeReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualAverageStrikeReference> validator(ValidatorFactory factory) {
		return factory.<FxAccrualAverageStrikeReference>create(FxAccrualAverageStrikeReferenceValidator.class);
	}

	@Override
	public Validator<? super FxAccrualAverageStrikeReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualAverageStrikeReference>create(FxAccrualAverageStrikeReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualAverageStrikeReference> validator() {
		return new FxAccrualAverageStrikeReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualAverageStrikeReference> typeFormatValidator() {
		return new FxAccrualAverageStrikeReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualAverageStrikeReference, Set<String>> onlyExistsValidator() {
		return new FxAccrualAverageStrikeReferenceOnlyExistsValidator();
	}
}
