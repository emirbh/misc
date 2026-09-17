package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ValuationPostponement;
import fpml.consolidated.ird.validation.ValuationPostponementTypeFormatValidator;
import fpml.consolidated.ird.validation.ValuationPostponementValidator;
import fpml.consolidated.ird.validation.exists.ValuationPostponementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationPostponement.class)
public class ValuationPostponementMeta implements RosettaMetaData<ValuationPostponement> {

	@Override
	public List<Validator<? super ValuationPostponement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationPostponement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationPostponement> validator(ValidatorFactory factory) {
		return factory.<ValuationPostponement>create(ValuationPostponementValidator.class);
	}

	@Override
	public Validator<? super ValuationPostponement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationPostponement>create(ValuationPostponementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationPostponement> validator() {
		return new ValuationPostponementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationPostponement> typeFormatValidator() {
		return new ValuationPostponementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationPostponement, Set<String>> onlyExistsValidator() {
		return new ValuationPostponementOnlyExistsValidator();
	}
}
