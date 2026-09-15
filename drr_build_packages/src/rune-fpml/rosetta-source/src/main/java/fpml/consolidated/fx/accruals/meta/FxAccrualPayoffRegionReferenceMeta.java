package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualPayoffRegionReference;
import fpml.consolidated.fx.accruals.validation.FxAccrualPayoffRegionReferenceTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualPayoffRegionReferenceValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualPayoffRegionReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualPayoffRegionReference.class)
public class FxAccrualPayoffRegionReferenceMeta implements RosettaMetaData<FxAccrualPayoffRegionReference> {

	@Override
	public List<Validator<? super FxAccrualPayoffRegionReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualPayoffRegionReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualPayoffRegionReference> validator(ValidatorFactory factory) {
		return factory.<FxAccrualPayoffRegionReference>create(FxAccrualPayoffRegionReferenceValidator.class);
	}

	@Override
	public Validator<? super FxAccrualPayoffRegionReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualPayoffRegionReference>create(FxAccrualPayoffRegionReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualPayoffRegionReference> validator() {
		return new FxAccrualPayoffRegionReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualPayoffRegionReference> typeFormatValidator() {
		return new FxAccrualPayoffRegionReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualPayoffRegionReference, Set<String>> onlyExistsValidator() {
		return new FxAccrualPayoffRegionReferenceOnlyExistsValidator();
	}
}
