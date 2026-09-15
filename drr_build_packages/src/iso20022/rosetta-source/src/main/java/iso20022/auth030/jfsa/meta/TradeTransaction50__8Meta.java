package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeTransaction50__8;
import iso20022.auth030.jfsa.validation.TradeTransaction50__8TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeTransaction50__8Validator;
import iso20022.auth030.jfsa.validation.exists.TradeTransaction50__8OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeTransaction50__8.class)
public class TradeTransaction50__8Meta implements RosettaMetaData<TradeTransaction50__8> {

	@Override
	public List<Validator<? super TradeTransaction50__8>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeTransaction50__8, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeTransaction50__8> validator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__8>create(TradeTransaction50__8Validator.class);
	}

	@Override
	public Validator<? super TradeTransaction50__8> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeTransaction50__8>create(TradeTransaction50__8TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__8> validator() {
		return new TradeTransaction50__8Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeTransaction50__8> typeFormatValidator() {
		return new TradeTransaction50__8TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeTransaction50__8, Set<String>> onlyExistsValidator() {
		return new TradeTransaction50__8OnlyExistsValidator();
	}
}
