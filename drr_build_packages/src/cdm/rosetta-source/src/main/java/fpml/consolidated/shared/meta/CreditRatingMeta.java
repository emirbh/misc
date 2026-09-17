package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.CreditRating;
import fpml.consolidated.shared.validation.CreditRatingTypeFormatValidator;
import fpml.consolidated.shared.validation.CreditRatingValidator;
import fpml.consolidated.shared.validation.exists.CreditRatingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditRating.class)
public class CreditRatingMeta implements RosettaMetaData<CreditRating> {

	@Override
	public List<Validator<? super CreditRating>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditRating, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditRating> validator(ValidatorFactory factory) {
		return factory.<CreditRating>create(CreditRatingValidator.class);
	}

	@Override
	public Validator<? super CreditRating> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditRating>create(CreditRatingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditRating> validator() {
		return new CreditRatingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditRating> typeFormatValidator() {
		return new CreditRatingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditRating, Set<String>> onlyExistsValidator() {
		return new CreditRatingOnlyExistsValidator();
	}
}
