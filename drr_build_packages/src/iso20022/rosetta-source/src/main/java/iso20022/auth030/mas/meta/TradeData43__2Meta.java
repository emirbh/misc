package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.TradeData43__2;
import iso20022.auth030.mas.validation.TradeData43__2TypeFormatValidator;
import iso20022.auth030.mas.validation.TradeData43__2Validator;
import iso20022.auth030.mas.validation.exists.TradeData43__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeData43__2.class)
public class TradeData43__2Meta implements RosettaMetaData<TradeData43__2> {

	@Override
	public List<Validator<? super TradeData43__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeData43__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeData43__2> validator(ValidatorFactory factory) {
		return factory.<TradeData43__2>create(TradeData43__2Validator.class);
	}

	@Override
	public Validator<? super TradeData43__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeData43__2>create(TradeData43__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__2> validator() {
		return new TradeData43__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeData43__2> typeFormatValidator() {
		return new TradeData43__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeData43__2, Set<String>> onlyExistsValidator() {
		return new TradeData43__2OnlyExistsValidator();
	}
}
