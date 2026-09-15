package iso20022.auth030.jfsa.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.jfsa.TradeClearing11__2;
import iso20022.auth030.jfsa.validation.TradeClearing11__2TypeFormatValidator;
import iso20022.auth030.jfsa.validation.TradeClearing11__2Validator;
import iso20022.auth030.jfsa.validation.exists.TradeClearing11__2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeClearing11__2.class)
public class TradeClearing11__2Meta implements RosettaMetaData<TradeClearing11__2> {

	@Override
	public List<Validator<? super TradeClearing11__2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeClearing11__2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeClearing11__2> validator(ValidatorFactory factory) {
		return factory.<TradeClearing11__2>create(TradeClearing11__2Validator.class);
	}

	@Override
	public Validator<? super TradeClearing11__2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeClearing11__2>create(TradeClearing11__2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeClearing11__2> validator() {
		return new TradeClearing11__2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeClearing11__2> typeFormatValidator() {
		return new TradeClearing11__2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeClearing11__2, Set<String>> onlyExistsValidator() {
		return new TradeClearing11__2OnlyExistsValidator();
	}
}
