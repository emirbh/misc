package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualLinearPayoffRegion;
import fpml.consolidated.fx.accruals.validation.FxAccrualLinearPayoffRegionTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualLinearPayoffRegionValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxAccrualLinearPayoffRegionChoice;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualLinearPayoffRegionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualLinearPayoffRegion.class)
public class FxAccrualLinearPayoffRegionMeta implements RosettaMetaData<FxAccrualLinearPayoffRegion> {

	@Override
	public List<Validator<? super FxAccrualLinearPayoffRegion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxAccrualLinearPayoffRegion>create(FxAccrualLinearPayoffRegionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualLinearPayoffRegion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualLinearPayoffRegion> validator(ValidatorFactory factory) {
		return factory.<FxAccrualLinearPayoffRegion>create(FxAccrualLinearPayoffRegionValidator.class);
	}

	@Override
	public Validator<? super FxAccrualLinearPayoffRegion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualLinearPayoffRegion>create(FxAccrualLinearPayoffRegionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualLinearPayoffRegion> validator() {
		return new FxAccrualLinearPayoffRegionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualLinearPayoffRegion> typeFormatValidator() {
		return new FxAccrualLinearPayoffRegionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualLinearPayoffRegion, Set<String>> onlyExistsValidator() {
		return new FxAccrualLinearPayoffRegionOnlyExistsValidator();
	}
}
