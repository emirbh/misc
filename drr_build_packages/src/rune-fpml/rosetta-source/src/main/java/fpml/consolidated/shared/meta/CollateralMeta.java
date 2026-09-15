package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Collateral;
import fpml.consolidated.shared.validation.CollateralTypeFormatValidator;
import fpml.consolidated.shared.validation.CollateralValidator;
import fpml.consolidated.shared.validation.exists.CollateralOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Collateral.class)
public class CollateralMeta implements RosettaMetaData<Collateral> {

	@Override
	public List<Validator<? super Collateral>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Collateral, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Collateral> validator(ValidatorFactory factory) {
		return factory.<Collateral>create(CollateralValidator.class);
	}

	@Override
	public Validator<? super Collateral> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Collateral>create(CollateralTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Collateral> validator() {
		return new CollateralValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Collateral> typeFormatValidator() {
		return new CollateralTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Collateral, Set<String>> onlyExistsValidator() {
		return new CollateralOnlyExistsValidator();
	}
}
