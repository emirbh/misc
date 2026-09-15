package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeTransaction50__6;
import iso20022.auth030.jfsa.validation.TradeTransaction50__6TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeTransaction50__6Validator;
import iso20022.auth030.jfsa.validation.exists.TradeTransaction50__6OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeTransaction50__6.class)
public class TradeTransaction50__6Meta implements RosettaMetaData<TradeTransaction50__6> {

	@Override
	public List<Validator<? super TradeTransaction50__6>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTransaction50__6, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeTransaction50__6> validator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__6>create(TradeTransaction50__6Validator.class);
	}

	@Override
	public Validator<? super TradeTransaction50__6> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__6>create(TradeTransaction50__6TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__6> validator() {
		return new TradeTransaction50__6Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__6> typeFormatValidator() {
		return new TradeTransaction50__6TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTransaction50__6, Set<String>> onlyExistsValidator() {
		return new TradeTransaction50__6OnlyExistsValidator();
	}
}
