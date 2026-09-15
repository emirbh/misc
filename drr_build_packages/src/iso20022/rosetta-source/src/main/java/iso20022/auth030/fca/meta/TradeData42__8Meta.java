package iso20022.auth030.fca.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.fca.TradeData42__8;
import iso20022.auth030.fca.validation.TradeData42__8TypeFormatValidator;
import iso20022.auth030.fca.validation.TradeData42__8Validator;
import iso20022.auth030.fca.validation.exists.TradeData42__8OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData42__8.class)
public class TradeData42__8Meta implements RosettaMetaData<TradeData42__8> {

	@Override
	public List<Validator<? super TradeData42__8>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData42__8, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData42__8> validator(ValidatorFactory factory) {
		return factory.<TradeData42__8>create(TradeData42__8Validator.class);
	}

	@Override
	public Validator<? super TradeData42__8> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData42__8>create(TradeData42__8TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__8> validator() {
		return new TradeData42__8Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData42__8> typeFormatValidator() {
		return new TradeData42__8TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData42__8, Set<String>> onlyExistsValidator() {
		return new TradeData42__8OnlyExistsValidator();
	}
}
