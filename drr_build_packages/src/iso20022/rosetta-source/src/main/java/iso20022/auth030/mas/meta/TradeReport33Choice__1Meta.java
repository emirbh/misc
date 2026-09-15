package iso20022.auth030.mas.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.auth030.mas.TradeReport33Choice__1;
import iso20022.auth030.mas.validation.TradeReport33Choice__1TypeFormatValidator;
import iso20022.auth030.mas.validation.TradeReport33Choice__1Validator;
import iso20022.auth030.mas.validation.datarule.TradeReport33Choice__1Choice;
import iso20022.auth030.mas.validation.exists.TradeReport33Choice__1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeReport33Choice__1.class)
public class TradeReport33Choice__1Meta implements RosettaMetaData<TradeReport33Choice__1> {

	@Override
	public List<Validator<? super TradeReport33Choice__1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<TradeReport33Choice__1>create(TradeReport33Choice__1Choice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeReport33Choice__1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TradeReport33Choice__1> validator(ValidatorFactory factory) {
		return factory.<TradeReport33Choice__1>create(TradeReport33Choice__1Validator.class);
	}

	@Override
	public Validator<? super TradeReport33Choice__1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TradeReport33Choice__1>create(TradeReport33Choice__1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TradeReport33Choice__1> validator() {
		return new TradeReport33Choice__1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super TradeReport33Choice__1> typeFormatValidator() {
		return new TradeReport33Choice__1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReport33Choice__1, Set<String>> onlyExistsValidator() {
		return new TradeReport33Choice__1OnlyExistsValidator();
	}
}
