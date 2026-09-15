package drr.base.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.margin.CollateralDetails;
import drr.base.margin.validation.CollateralDetailsTypeFormatValidator;
import drr.base.margin.validation.CollateralDetailsValidator;
import drr.base.margin.validation.exists.CollateralDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CollateralDetails.class)
public class CollateralDetailsMeta implements RosettaMetaData<CollateralDetails> {

	@Override
	public List<Validator<? super CollateralDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralDetails> validator(ValidatorFactory factory) {
		return factory.<CollateralDetails>create(CollateralDetailsValidator.class);
	}

	@Override
	public Validator<? super CollateralDetails> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralDetails>create(CollateralDetailsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralDetails> validator() {
		return new CollateralDetailsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralDetails> typeFormatValidator() {
		return new CollateralDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralDetails, Set<String>> onlyExistsValidator() {
		return new CollateralDetailsOnlyExistsValidator();
	}
}
