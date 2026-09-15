package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.CollateralArrangement;
import fpml.consolidated.repo.validation.CollateralArrangementTypeFormatValidator;
import fpml.consolidated.repo.validation.CollateralArrangementValidator;
import fpml.consolidated.repo.validation.exists.CollateralArrangementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CollateralArrangement.class)
public class CollateralArrangementMeta implements RosettaMetaData<CollateralArrangement> {

	@Override
	public List<Validator<? super CollateralArrangement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralArrangement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralArrangement> validator(ValidatorFactory factory) {
		return factory.<CollateralArrangement>create(CollateralArrangementValidator.class);
	}

	@Override
	public Validator<? super CollateralArrangement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralArrangement>create(CollateralArrangementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralArrangement> validator() {
		return new CollateralArrangementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralArrangement> typeFormatValidator() {
		return new CollateralArrangementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralArrangement, Set<String>> onlyExistsValidator() {
		return new CollateralArrangementOnlyExistsValidator();
	}
}
