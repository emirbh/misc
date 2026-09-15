package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.CollateralValuation;
import fpml.consolidated.repo.validation.CollateralValuationTypeFormatValidator;
import fpml.consolidated.repo.validation.CollateralValuationValidator;
import fpml.consolidated.repo.validation.datarule.CollateralValuationChoice0;
import fpml.consolidated.repo.validation.datarule.CollateralValuationChoice1;
import fpml.consolidated.repo.validation.datarule.CollateralValuationChoice2;
import fpml.consolidated.repo.validation.datarule.CollateralValuationChoice3;
import fpml.consolidated.repo.validation.datarule.CollateralValuationChoice4;
import fpml.consolidated.repo.validation.exists.CollateralValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralValuation.class)
public class CollateralValuationMeta implements RosettaMetaData<CollateralValuation> {

	@Override
	public List<Validator<? super CollateralValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CollateralValuation>create(CollateralValuationChoice0.class),
			factory.<CollateralValuation>create(CollateralValuationChoice1.class),
			factory.<CollateralValuation>create(CollateralValuationChoice2.class),
			factory.<CollateralValuation>create(CollateralValuationChoice3.class),
			factory.<CollateralValuation>create(CollateralValuationChoice4.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralValuation> validator(ValidatorFactory factory) {
		return factory.<CollateralValuation>create(CollateralValuationValidator.class);
	}

	@Override
	public Validator<? super CollateralValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralValuation>create(CollateralValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValuation> validator() {
		return new CollateralValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralValuation> typeFormatValidator() {
		return new CollateralValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValuation, Set<String>> onlyExistsValidator() {
		return new CollateralValuationOnlyExistsValidator();
	}
}
