package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualPayoffRegion;
import fpml.consolidated.fx.accruals.validation.FxAccrualPayoffRegionTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualPayoffRegionValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualPayoffRegion.class)
public class FxAccrualPayoffRegionMeta implements RosettaMetaData<FxAccrualPayoffRegion> {

	@Override
	public List<Validator<? super FxAccrualPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualPayoffRegion> validator(ValidatorFactory factory) {
		return factory.<FxAccrualPayoffRegion>create(FxAccrualPayoffRegionValidator.class);
	}

	@Override
	public Validator<? super FxAccrualPayoffRegion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualPayoffRegion>create(FxAccrualPayoffRegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualPayoffRegion> validator() {
		return new FxAccrualPayoffRegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualPayoffRegion> typeFormatValidator() {
		return new FxAccrualPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxAccrualPayoffRegionOnlyExistsValidator();
	}
}
