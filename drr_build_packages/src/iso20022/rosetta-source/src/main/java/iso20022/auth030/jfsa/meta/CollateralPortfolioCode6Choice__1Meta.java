package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.CollateralPortfolioCode6Choice__1;
import iso20022.auth030.jfsa.validation.CollateralPortfolioCode6Choice__1TypeFormatValidator;
import iso20022.auth030.jfsa.validation.CollateralPortfolioCode6Choice__1Validator;
import iso20022.auth030.jfsa.validation.exists.CollateralPortfolioCode6Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CollateralPortfolioCode6Choice__1.class)
public class CollateralPortfolioCode6Choice__1Meta implements RosettaMetaData<CollateralPortfolioCode6Choice__1> {

	@Override
	public List<Validator<? super CollateralPortfolioCode6Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralPortfolioCode6Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralPortfolioCode6Choice__1> validator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioCode6Choice__1>create(CollateralPortfolioCode6Choice__1Validator.class);
	}

	@Override
	public Validator<? super CollateralPortfolioCode6Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralPortfolioCode6Choice__1>create(CollateralPortfolioCode6Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioCode6Choice__1> validator() {
		return new CollateralPortfolioCode6Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralPortfolioCode6Choice__1> typeFormatValidator() {
		return new CollateralPortfolioCode6Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralPortfolioCode6Choice__1, Set<String>> onlyExistsValidator() {
		return new CollateralPortfolioCode6Choice__1OnlyExistsValidator();
	}
}
