package iso20022.auth030.esma.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.esma.TradeClearing11__1;
import iso20022.auth030.esma.validation.TradeClearing11__1TypeFormatValidator;
import iso20022.auth030.esma.validation.TradeClearing11__1Validator;
import iso20022.auth030.esma.validation.exists.TradeClearing11__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeClearing11__1.class)
public class TradeClearing11__1Meta implements RosettaMetaData<TradeClearing11__1> {

	@Override
	public List<Validator<? super TradeClearing11__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeClearing11__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeClearing11__1> validator(ValidatorFactory factory) {
		return factory.<TradeClearing11__1>create(TradeClearing11__1Validator.class);
	}

	@Override
	public Validator<? super TradeClearing11__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeClearing11__1>create(TradeClearing11__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeClearing11__1> validator() {
		return new TradeClearing11__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeClearing11__1> typeFormatValidator() {
		return new TradeClearing11__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeClearing11__1, Set<String>> onlyExistsValidator() {
		return new TradeClearing11__1OnlyExistsValidator();
	}
}
