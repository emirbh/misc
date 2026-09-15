package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.PriceData2__2;
import iso20022.auth030.jfsa.validation.PriceData2__2TypeFormatValidator;
import iso20022.auth030.jfsa.validation.PriceData2__2Validator;
import iso20022.auth030.jfsa.validation.exists.PriceData2__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PriceData2__2.class)
public class PriceData2__2Meta implements RosettaMetaData<PriceData2__2> {

	@Override
	public List<Validator<? super PriceData2__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceData2__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceData2__2> validator(ValidatorFactory factory) {
		return factory.<PriceData2__2>create(PriceData2__2Validator.class);
	}

	@Override
	public Validator<? super PriceData2__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PriceData2__2>create(PriceData2__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PriceData2__2> validator() {
		return new PriceData2__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super PriceData2__2> typeFormatValidator() {
		return new PriceData2__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceData2__2, Set<String>> onlyExistsValidator() {
		return new PriceData2__2OnlyExistsValidator();
	}
}
